package com.example.yournight.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yournight.DetailPage
import com.example.yournight.ElementList
import com.example.yournight.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.its.lezione27maggio.ElementListAdapter
import kotlinx.android.synthetic.main.activity_restaurant.*
import java.util.*

class RestaurantActivity : AppCompatActivity() {

    private var recipes: ArrayList<ElementList>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        backRestaurant.setOnClickListener {
            finish()
        }

        val db = Firebase.firestore
        db.collection("ristoranti")
            .get()
            .addOnSuccessListener { result ->
                recipes = ArrayList()
                for (document in result) {

                    Log.d("RISTORANTI", "Successo")
                    val restaurant = ElementList(document.data["nome"].toString(), document.data["valutazione"].toString(), document.data["indirizzo"].toString(), document.data["immagine"].toString(), document.data["telefono"].toString())
                    recipes!!.add(restaurant)

                }

                //Dichiaro l'adapter
                val adapter = ElementListAdapter(recipes!!, this)

                //Layout manager
                val layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                recycleView.layoutManager = layoutManager
                recycleView.adapter = adapter

            }
            .addOnFailureListener { exception ->
                Log.d("RISTORANTI", "Fail")
            }
    }
}