package com.code.code1.application

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews();
    }

    private fun initViews() {
        Log.e("cdk say" , "zjsb")
        Log.e("cdk say again" , "zjsb")
        Log.e("cdk say again again" , "zjsb")
    }
}
