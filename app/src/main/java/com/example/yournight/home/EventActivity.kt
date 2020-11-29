package com.example.yournight.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yournight.R
import kotlinx.android.synthetic.main.activity_event.*

class EventActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        backEvent.setOnClickListener {
            finish()
        }
    }
}