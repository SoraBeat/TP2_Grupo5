package com.example.tp2_grupo5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;

public class ListarContactos extends AppCompatActivity {
    private TextView txtPrueba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_contactos);

        txtPrueba = (TextView) findViewById(R.id.txtPrueba);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String datos = preferences.getString("datosPersonas","");

        txtPrueba.setText(datos);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.agregarContacto){
            Intent i = new Intent(this,AgregarContactos1.class);
            startActivity(i);
        } else if(id==R.id.listarContactos){
            return true;
        }
        return true;
    }
}