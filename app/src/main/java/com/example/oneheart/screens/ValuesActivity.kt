package com.example.oneheart.screens

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oneheart.R

class ValuesActivity : AppCompatActivity() {
    var arr = ArrayList<Triple>()
    var rec: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.values)
        val rec = findViewById<View>(R.id.recyclerview) as RecyclerView
        rec.layoutManager = LinearLayoutManager(this)
        arr.add(Triple(R.drawable.home, "A", "890564321"))
        arr.add(Triple(R.drawable.home, "B", "890564321"))
        arr.add(Triple(R.drawable.home, "C", "890564321"))
        arr.add(Triple(R.drawable.home, "D", "890564321"))
        arr.add(Triple(R.drawable.home, "E", "890564321"))
        arr.add(Triple(R.drawable.home, "F", "890564321"))
        arr.add(Triple(R.drawable.home, "G", "890564321"))
        arr.add(Triple(R.drawable.home, "H", "890564321"))
        val adapter = Adapter(this, arr)
        rec.adapter = adapter
    }
}