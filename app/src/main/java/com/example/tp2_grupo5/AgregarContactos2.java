package com.example.tp2_grupo5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.example.tp2_grupo5.Persona;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class AgregarContactos2 extends AppCompatActivity {
    private RadioGroup rgEstudio;
    private CheckBox chkDeporte;
    private CheckBox chkArte;
    private CheckBox chkTecnologia;
    private CheckBox chkMusica;
    private Switch swtConfirmInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contactos2);

        rgEstudio = (RadioGroup) findViewById(R.id.rgEstudios);
        chkDeporte = (CheckBox) findViewById(R.id.chkDeporte);
        chkMusica = (CheckBox) findViewById(R.id.chkMusica);
        chkArte = (CheckBox) findViewById(R.id.chkArte);
        chkTecnologia = (CheckBox) findViewById(R.id.chkTecnologia);
        swtConfirmInfo = (Switch) findViewById(R.id.swtConfirmInfo);

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


        //Validar radeoGroup
        if(rgEstudio.getCheckedRadioButtonId() != -1){
            SharedPreferences Preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
            SharedPreferences.Editor Obj_Editor = Preferencias.edit();

            int selectedRadioButtonId = rgEstudio.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            String selectedText = selectedRadioButton.getText().toString();

            String intereses = "";

            if(chkArte.isChecked()){

                if(intereses.isEmpty()){
                    intereses += "Arte";
                }
                else{
                    intereses += ",Arte";
                }
            }

            if(chkTecnologia.isChecked()){

                if(intereses.isEmpty()){
                    intereses += "Tecnologia";
                }
                else{
                    intereses += ",Tecnologia";
                }
            }

            if(chkMusica.isChecked()){
                if(intereses.isEmpty()){
                    intereses += "Musica";
                }
                else{
                    intereses += ",Musica";
                }
            }
            if(chkDeporte.isChecked()){
                if(intereses.isEmpty()){
                    intereses += "Deporte";
                }
                else{
                    intereses += ",Deporte";
                }

            }

            Persona Obj_Persona = new Persona(nombre,apellido,tel,spinnerTel,email,spinnerEmail,fecha,direccion,selectedText,intereses, String.valueOf(swtConfirmInfo.isChecked()));

            SharedPreferences prefGuardadas = getSharedPreferences("datos", Context.MODE_PRIVATE);
            String datosGuardados = prefGuardadas.getString("datosPersonas","");

            Gson gson = new Gson();
            if(!datosGuardados.isEmpty()){
                JsonObject jsonGuardado = new Gson().fromJson(datosGuardados,JsonObject.class); //Los datos que tengo guardado los transforma a JSONObject
                JsonElement persona = new Gson().fromJson(gson.toJson(Obj_Persona),JsonElement.class); //Los datos que ingrese de la persona los transforma a JSONElement
                jsonGuardado.add(String.valueOf(jsonGuardado.size()+1),persona); //Guardo la persona dentro del JSONGuardado

                Obj_Editor.putString("datosPersonas", jsonGuardado.toString());
                Obj_Editor.commit();
            }else {
                JsonObject jsonGuardado = new JsonObject(); //Los datos que tengo guardado los transforma a JSONObject
                JsonElement persona = new Gson().fromJson(gson.toJson(Obj_Persona), JsonElement.class); //Los datos que ingrese de la persona los transforma a JSONElement
                jsonGuardado.add(String.valueOf(jsonGuardado.size() + 1), persona); //Guardo la persona dentro del JSONGuardado

                Obj_Editor.putString("datosPersonas", jsonGuardado.toString());
                Obj_Editor.commit();
            }

            //Volver al primer formulario
            Intent viewAgregarContactos1 = new Intent(this, AgregarContactos1.class);
            startActivity(viewAgregarContactos1);
        }
        else {
            Toast.makeText(this, "Tenes que seleccionar un estudio", Toast.LENGTH_SHORT).show();
        }



    }
}