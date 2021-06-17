package com.smartepay.news.ui.base


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()

    }


    abstract fun setupView()




     fun showError(message: String?) {
            Toast.makeText(this, message , Toast.LENGTH_LONG).show()

    }



      fun showMessage(message: String?) {
            Toast.makeText(this, message , Toast.LENGTH_LONG).show()

    }



}