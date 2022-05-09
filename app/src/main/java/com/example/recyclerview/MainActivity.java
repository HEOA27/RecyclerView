package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
List<ListElement> elementos;
TextView telefono, correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
    public void init(){
        elementos=new ArrayList<>();
        elementos.add(new ListElement("Heidy","9711399552","HeidyA408@gmail.com"));
        elementos.add(new ListElement("Miriam","9711349253","RegiOrdaz@gmail.com"));
        elementos.add(new ListElement("Helena","9711376253","HelenaTel@gmail.com"));
        elementos.add(new ListElement("Joey","9611399253","Joey2013@gmail.com"));
        elementos.add(new ListElement("Oliver","9711349259","OliAl@gmail.com"));

        ListAdapter listAdapter = new ListAdapter(elementos,this);
        RecyclerView recyclerView = findViewById(R.id.myRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

        listAdapter.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){

               telefono=view.findViewById(R.id.telefonoTextView);
               correo=view.findViewById(R.id.correoTextView);
               Intent i =new Intent(Intent.ACTION_DIAL);
               String telephone=telefono.getText().toString();
               String email=correo.getText().toString();
               i.setData(Uri.parse("tel:" + telephone));

               startActivity(i);
           }
        });



    }
}