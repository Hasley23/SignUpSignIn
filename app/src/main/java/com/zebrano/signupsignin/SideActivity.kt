package com.zebrano.signupsignin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zebrano.signupsignin.databinding.ActivityMainBinding
import com.zebrano.signupsignin.databinding.ActivitySideBinding

class SideActivity : AppCompatActivity() {
    private lateinit var bindingObj : ActivitySideBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingObj = ActivitySideBinding.inflate(layoutInflater)
        setContentView(bindingObj.root)

        bindingObj.bOk.setOnClickListener {
            //TODO
            finish()
        }
    }
}