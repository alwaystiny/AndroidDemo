package com.code.code1.application

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("test","test")
        Log.i("test2","test222222")
        Log.i("test3","test3333333333333333")
    }
}
