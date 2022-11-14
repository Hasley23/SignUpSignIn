package com.zebrano.signupsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.zebrano.signupsignin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingObj : ActivityMainBinding
    // activity launcher
    private var launcher : ActivityResultLauncher<Intent>?=null
    // Data
    private var login : String = String()
    private var pWord : String = String()
    private var name1 : String = String()
    private var name2 : String = String()
    private var name3 : String = String()
    private var avatarID : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingObj = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingObj.root)

        // init callback
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result : ActivityResult ->
            // if result code is OK then do something..
            if(result.resultCode == RESULT_OK){
                val state = result.data?.getStringExtra(Consts.SIGN_STATE)
                Log.d("AppLog",state.toString())
                if(state == Consts.SIGN_IN_STATE){
                    val l = result.data?.getStringExtra(Consts.LOGIN)
                    val p = result.data?.getStringExtra(Consts.PASSWORD)
                    if(login == l && pWord == p){
                        bindingObj.avatarImgTrue.setImageResource(avatarID)
                        val textMain = "$name1 $name2 $name3"
                        bindingObj.tvMain.text = textMain
                    } else {
                        bindingObj.tvMain.text = Consts.doesntExists
                    }
                } else if (state == Consts.SIGN_UP_STATE){
                    login = result.data?.getStringExtra(Consts.LOGIN)!!
                    pWord = result.data?.getStringExtra(Consts.PASSWORD)!!
                    name1 = result.data?.getStringExtra(Consts.NAME)!!
                    name2 = result.data?.getStringExtra(Consts.LASTNAME)!!
                    name3 = result.data?.getStringExtra(Consts.PATRON)!!
                    avatarID = result.data?.getStringExtra(Consts.AVATAR_ID)!!.toInt()
                }
                Log.d("AppLog", login+" "+pWord+" "+name1+" "+name2+" "+name3+" "+avatarID)


            }
        }

        // set listeners
        bindingObj.bSignIn.setOnClickListener {
            val i = Intent(this,SideActivity::class.java)
            i.putExtra(Consts.SIGN_STATE,Consts.SIGN_IN_STATE)
            launcher?.launch(i)
        }

        bindingObj.bSignUp.setOnClickListener {
            val i = Intent(this,SideActivity::class.java)
            i.putExtra(Consts.SIGN_STATE,Consts.SIGN_UP_STATE)
            launcher?.launch(i)
        }
    }
}