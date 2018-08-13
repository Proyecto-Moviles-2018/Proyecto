package com.example.marcelo.proyectoappmoviles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*button_reproducto.setOnClickListener{v: View ->
            irAActividadReproductor()
        }*/
    }

    /*fun irAActividadReproductor(){
        val intent = Intent(this,SearchActivity::class.java)
        startActivity(intent)
    }*/
}
