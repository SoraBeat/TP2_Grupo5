package com.example.tp2_grupo5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class AgregarContactos2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contactos2);
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
            Intent i = new Intent(this,ListarContactos.class);
            startActivity(i);
        }
        return true;
    }

    public void btnGuardar_Click(View view)
    {
        //Datos del 1er formulario
        String nombre = getIntent().getStringExtra("nombre");
        String apellido = getIntent().getStringExtra("apellido");
        String tel = getIntent().getStringExtra("tel");
        String email = getIntent().getStringExtra("email");
        String direccion = getIntent().getStringExtra("direccion");
        String fecha = getIntent().getStringExtra("fechaNac");
        String spinnerTel = getIntent().getStringExtra("spinnerTel");
        String spinnerEmail = getIntent().getStringExtra("spinnerEmail");
    }
}