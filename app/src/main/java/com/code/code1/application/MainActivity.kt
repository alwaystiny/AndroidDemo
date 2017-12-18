package com.code.code1.application

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        Log.i("test","test")
        Log.i("test2","test222222")
        Log.i("test3","test3333333333333333")
        Log.i("test4","test4444444444444")
        initViews();
    }

    private fun initViews() {
        Log.e("cdk say" , "zjsb")
        Log.e("cdk say again" , "zjsb")
        Log.e("cdk say again again" , "zjsb")
    }
}
