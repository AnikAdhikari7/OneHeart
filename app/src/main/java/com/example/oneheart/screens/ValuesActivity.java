package com.example.oneheart.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.oneheart.R;

import java.util.ArrayList;

public class ValuesActivity extends AppCompatActivity {

    ArrayList<Triple> arr=new ArrayList<>();
    RecyclerView rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.values);
        RecyclerView rec=(RecyclerView) findViewById(R.id.recyclerview);
        rec.setLayoutManager(new LinearLayoutManager(this));
        arr.add(new Triple(R.drawable.home,"A","890564321"));
        arr.add(new Triple(R.drawable.home,"B","890564321"));
        arr.add(new Triple(R.drawable.home,"C","890564321"));
        arr.add(new Triple(R.drawable.home,"D","890564321"));
        arr.add(new Triple(R.drawable.home,"E","890564321"));
        arr.add(new Triple(R.drawable.home,"F","890564321"));
        arr.add(new Triple(R.drawable.home,"G","890564321"));
        arr.add(new Triple(R.drawable.home,"H","890564321"));
        Adapter adapter=new Adapter(this,arr);
        rec.setAdapter(adapter);
    }
}