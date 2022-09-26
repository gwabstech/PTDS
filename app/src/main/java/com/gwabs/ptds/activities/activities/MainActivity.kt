package com.gwabs.ptds.activities.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gwabs.ptds.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mainBinding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = mainBinding!!.root
        setContentView(view)
        mainBinding!!.btnGetStarted.setOnClickListener { view1: View? ->
            //Toast.makeText(this, "you clicked me", Toast.LENGTH_SHORT).show();
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
    }
}