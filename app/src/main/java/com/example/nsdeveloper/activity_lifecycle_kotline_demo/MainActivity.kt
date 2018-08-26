package com.example.nsdeveloper.activity_lifecycle_kotline_demo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var show: TextView
    lateinit var data: EditText
    var persist: String?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        data = findViewById(R.id.text)
        show = findViewById(R.id.show)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        show.text = savedInstanceState?.getString("KEY")
        Toast.makeText(this,"On Restart",Toast.LENGTH_SHORT).show()

    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this,"On Restart",Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"On Start",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"On Resume",Toast.LENGTH_SHORT).show()
    }

    fun submit(view : View){
        persist = data.text.toString()
        show.text  = data.text.toString()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString("KEY",persist)
        Toast.makeText(this,"On SaveInstance",Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"On Pause",Toast.LENGTH_SHORT).show()

    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"On Stop",Toast.LENGTH_SHORT).show()
        persist = show.text.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"On Destroy",Toast.LENGTH_SHORT).show()
    }



}
