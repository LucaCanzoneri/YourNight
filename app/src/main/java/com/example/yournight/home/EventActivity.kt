package com.example.yournight.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yournight.ElementList
import com.example.yournight.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.its.lezione27maggio.ElementListAdapter
import kotlinx.android.synthetic.main.activity_event.*
import kotlinx.android.synthetic.main.activity_event.recycleView
import kotlinx.android.synthetic.main.activity_pub.*
import java.util.ArrayList

class EventActivity : AppCompatActivity() {

    private var recipes: ArrayList<ElementList>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        backEvent.setOnClickListener {
            finish()
        }

        /*
        val db = Firebase.firestore
        db.collection("eventi")
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
            } */
    }
}