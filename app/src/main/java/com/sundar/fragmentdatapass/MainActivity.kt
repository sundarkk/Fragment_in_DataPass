package com.sundar.fragmentdatapass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() , Communicator{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        supportFragmentManager.beginTransaction().replace(R.id.relativeLayout, firstFragment).commit()
    }



    override fun passDataCom(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("inputText", editTextInput)
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentTwo = SecondFragment()
        fragmentTwo.arguments = bundle
        transaction.replace(R.id.relativeLayout, fragmentTwo).commit()
//        transaction.addToBackStack(null)
//        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//        transaction.commit()
    }
}