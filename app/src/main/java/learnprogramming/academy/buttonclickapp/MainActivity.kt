package learnprogramming.academy.buttonclickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private const val TAG = "MainActivity"
private const val TEXT_CONTENTS = "TextContent"

class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null
    private var numTimesClicked = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput: EditText = findViewById<EditText>(R.id.editText)
        val button: Button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.textView)
        textView?.text = ""
        textView?.movementMethod = ScrollingMovementMethod()

        userInput.setText("")

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d(TAG, "onClick: called")
                if (userInput.text.toString() != "") {
                    numTimesClicked++
                    textView?.append(userInput.text.toString())
                    textView?.append("- Button click counter : $numTimesClicked\n")
                    userInput.setText("")

                } else {
                    numTimesClicked++
                    textView?.append(("Button click counter : $numTimesClicked\n"))
                }
            }
        })
    }

    override fun onStart() {
        Log.d(TAG, "onStart: called")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState: called")
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text = savedInstanceState?.getString(TEXT_CONTENTS, "")
        numTimesClicked= savedInstanceState?.getInt("clicking",0)
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart: called")
        super.onRestart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume: called")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause: called")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState: called")
        super.onSaveInstanceState(outState)
        outState?.putString(TEXT_CONTENTS, textView?.text.toString())
        outState?.putInt("clicking", numTimesClicked)
    }

    override fun onStop() {
        Log.d(TAG, "onStop: called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: called")
        super.onDestroy()
    }
}