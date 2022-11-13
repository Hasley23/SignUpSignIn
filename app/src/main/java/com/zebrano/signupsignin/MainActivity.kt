package com.zebrano.signupsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.zebrano.signupsignin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingObj : ActivityMainBinding
    // activity launcher
    private var launcher : ActivityResultLauncher<Intent>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingObj = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingObj.root)

        // init callback
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            //TODO
            //callback
        }

        // set listeners
        bindingObj.bSignIn.setOnClickListener {
            //TODO
            //sign in act
            launchAct()
        }

        bindingObj.bSignUp.setOnClickListener {
            //TODO
            //sign up act
            launchAct()
        }

    }

    fun launchAct(){
        //TODO
        //?
        launcher?.launch(Intent(this, SideActivity::class.java))
    }
}