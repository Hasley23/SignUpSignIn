package com.zebrano.signupsignin

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.zebrano.signupsignin.databinding.ActivitySideBinding

class SideActivity : AppCompatActivity() {
    private lateinit var bindingObj : ActivitySideBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingObj = ActivitySideBinding.inflate(layoutInflater)
        setContentView(bindingObj.root)

        // get sign state
        val signState = intent.getStringExtra(Consts.SIGN_STATE)
        Log.d("AppLog",signState.toString())

        if(signState == Consts.SIGN_IN_STATE){
            bindingObj.tiName.visibility = View.GONE
            bindingObj.tiLastname.visibility = View.GONE
            bindingObj.tiPatron.visibility = View.GONE
            bindingObj.bAvatar.visibility = View.INVISIBLE
            bindingObj.tvActionFormName.text = bindingObj.tiLogin.hint
        }

        bindingObj.bAvatar.setOnClickListener{
            bindingObj.avatarImg.setImageResource(R.drawable.man_with_brown_hair)
        }

        bindingObj.bOk.setOnClickListener {
            intent.putExtra(Consts.SIGN_STATE,signState)
            if (signState == Consts.SIGN_UP_STATE){
                val intent = Intent()
                intent.putExtra(Consts.LOGIN, bindingObj.tiLogin.text.toString())
                intent.putExtra(Consts.PASSWORD, bindingObj.tiPas.text.toString())
                intent.putExtra(Consts.NAME, bindingObj.tiName.text.toString())
                intent.putExtra(Consts.LASTNAME, bindingObj.tiLastname.text.toString())
                intent.putExtra(Consts.PATRON, bindingObj.tiPatron.text.toString())
                if(bindingObj.avatarImg.id != R.drawable.user)
                    intent.putExtra(Consts.AVATAR_ID, bindingObj.avatarImg.id)
                setResult(RESULT_OK, intent)
            } else if (signState == Consts.SIGN_IN_STATE) {
                val intent = Intent()
                intent.putExtra(Consts.LOGIN, bindingObj.tiLogin.text.toString())
                intent.putExtra(Consts.PASSWORD, bindingObj.tiPas.text.toString())
                setResult(RESULT_OK, intent)
            } else return@setOnClickListener
            finish()
        }
    }
}