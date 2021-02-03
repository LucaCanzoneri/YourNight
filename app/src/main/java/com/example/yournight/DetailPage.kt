package com.example.yournight

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_detail_page.*

class DetailPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)

        if (intent.hasExtra("name")) {

            val name = intent.getStringExtra("name")
            val indirizzo = intent.getStringExtra("indirizzo")
            val telefono = intent.getStringExtra("numero")
            titoloAttivita.text = name.toString()
            indirizzoAttivita.text = indirizzo.toString()
            telefonoAttivita.text = telefono.toString()
        }

    }
}