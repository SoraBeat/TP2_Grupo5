package com.example.tp2_grupo5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.example.tp2_grupo5.MostrarDatos;

import kotlin.jvm.internal.markers.KMutableMap;

public class ListarContactos extends AppCompatActivity {
    private ConstraintLayout listaPersonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_contactos);

        listaPersonas = (ConstraintLayout) findViewById(R.id.listaPersonas);

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String datos = preferences.getString("datosPersonas","");
        Gson gson = new Gson();
        JsonObject jsonGuardado = new Gson().fromJson(datos,JsonObject.class);//Obtengo los datos y los convierto a Json

        Map<String, Object> attributes = new HashMap<String, Object>();//Creo una lista por cada atributo del objeto
        Set<Map.Entry<String, JsonElement>> entrySet = jsonGuardado.entrySet();
        for(Map.Entry<String,JsonElement> entry : entrySet){
            attributes.put(entry.getKey(), jsonGuardado.get(entry.getKey()));
        }

        for(Map.Entry<String,Object> att : attributes.entrySet()){ //Por cada persona puedo covertirla a un JsonObject para poder manipular los valores individualmente, creo un botopor cada person
            JsonObject jsonPersona= new Gson().fromJson(att.getValue().toString(),JsonObject.class);
            //System.out.println("Nombre de la persona:"+objetoPrueba.get("Nombre"));
            Button boton = new Button(this);
            boton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            boton.setText((jsonPersona.get("Nombre").toString() +" "+ jsonPersona.get("Apellido").toString()+" "+ jsonPersona.get("Email").toString()).replaceAll("\"",""));
            boton.setBackgroundColor(getResources().getColor(R.color.transparent));
            boton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent viewMostrarDatos= new Intent(v.getContext(), MostrarDatos.class);
                    //Paso la información al 2do formulario
                    viewMostrarDatos.putExtra("nombre", jsonPersona.get("Nombre").toString());
                    viewMostrarDatos.putExtra("apellido", jsonPersona.get("Apellido").toString());
                    viewMostrarDatos.putExtra("tel", jsonPersona.get("Telefono").toString());
                    viewMostrarDatos.putExtra("email", jsonPersona.get("Email").toString());
                    viewMostrarDatos.putExtra("direccion", jsonPersona.get("Direccion").toString());
                    viewMostrarDatos.putExtra("fechaNac", jsonPersona.get("Date").toString());
                    viewMostrarDatos.putExtra("spinnerTel", jsonPersona.get("SpinnerTelefono").toString());
                    viewMostrarDatos.putExtra("spinnerEmail", jsonPersona.get("SpinnerEmail").toString());
                    viewMostrarDatos.putExtra("radeoGroup", jsonPersona.get("radeoGroup").toString());
                    viewMostrarDatos.putExtra("Intereses", jsonPersona.get("Intereses").toString());
                    viewMostrarDatos.putExtra("Informacion", jsonPersona.get("Informacion").toString());

                    startActivity(viewMostrarDatos);
                }
            });
            listaPersonas.addView(boton);
        }


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