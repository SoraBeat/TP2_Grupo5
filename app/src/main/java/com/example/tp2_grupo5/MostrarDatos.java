package com.example.tp2_grupo5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.TextView;

public class MostrarDatos extends AppCompatActivity {
    private TextView Nombre;
    private TextView Telefono;
    private TextView spinnerTel;
    private TextView Email;
    private TextView spinnerEmail;
    private TextView Fecha;
    private TextView Direccion;
    private TextView Estudios;
    private TextView Intereses;
    private TextView swtConfirmInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        Nombre = (TextView)findViewById(R.id.txtNombre);
        Nombre.setText("Nombre y Apellido: " + (getIntent().getStringExtra("nombre")+" "+getIntent().getStringExtra("apellido")).replaceAll("\"",""));

        Telefono = (TextView)findViewById(R.id.txtTelefono);
        Telefono.setText("Telefono: " + getIntent().getStringExtra("tel").replaceAll("\"",""));

        spinnerTel = (TextView)findViewById(R.id.SpinnerTel);
        spinnerTel.setText(getIntent().getStringExtra("spinnerTel").replaceAll("\"",""));

        Email = (TextView)findViewById(R.id.txtEmail);
        Email.setText(getIntent().getStringExtra("email").replaceAll("\"",""));

        spinnerEmail = (TextView)findViewById(R.id.SpinnerEmail);
        spinnerEmail.setText(getIntent().getStringExtra("spinnerEmail").replaceAll("\"",""));

        Fecha = (TextView)findViewById(R.id.txtFecha);
        Fecha.setText(getIntent().getStringExtra("fechaNac").replaceAll("\"",""));

        Direccion = (TextView)findViewById(R.id.txtDireccion);
        Direccion.setText(getIntent().getStringExtra("direccion").replaceAll("\"",""));

        Estudios = (TextView)findViewById(R.id.txtEstudios);
        Estudios.setText("Estudios: " + getIntent().getStringExtra("radeoGroup").replaceAll("\"",""));

        Intereses = (TextView)findViewById(R.id.txtInteres);
        Intereses.setText("Intereses: " +getIntent().getStringExtra("Intereses").replaceAll("\"",""));

        swtConfirmInfo = (TextView)findViewById(R.id.txtInformacion);
        swtConfirmInfo.setText("¿Recibe informacion? " + (getIntent().getStringExtra("Informacion").replaceAll("\"", "").equals("true") ? "Sí" : "No"));


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
}