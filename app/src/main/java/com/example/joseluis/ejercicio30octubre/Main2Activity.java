package com.example.joseluis.ejercicio30octubre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final ArrayList<String> nacionalidad = new ArrayList<>();
        nacionalidad.add("Español");
        nacionalidad.add("Portugues");
        nacionalidad.add("Frances");
        nacionalidad.add("Britanico");
        nacionalidad.add("Aleman");
        nacionalidad.add("Belga");
        nacionalidad.add("Ruso");
        nacionalidad.add("Rumano");
        nacionalidad.add("Holandes");
        nacionalidad.add("Italiano");
        nacionalidad.add("Suizo");
        nacionalidad.add("Estadounidense");
        nacionalidad.add("Brasileño");
        nacionalidad.add("Mexicano");

        lista = (ListView)findViewById(R.id.lista);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nacionalidad);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int posicion, long id) {
                String text = parent.getItemAtPosition(posicion).toString();
                Intent i = new Intent();
                i.putExtra("result",text);
                setResult(RESULT_OK,i);
                finish();

            }
        });/*
        lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                Intent i = new Intent();
                i.putExtra("result",text);
                setResult(RESULT_OK,i);
                finish();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }
}
