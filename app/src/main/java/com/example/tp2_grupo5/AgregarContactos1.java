package com.example.tp2_grupo5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgregarContactos1 extends AppCompatActivity {

    private Spinner spinnerTel;
    private Spinner spinnerEmail;
    private EditText editTxtEmail;
    private EditText editTxtDate;
    private EditText editTxtApellido;
    private EditText editTxtNombre;
    private EditText editTextTel;
    private EditText editTextDireccion;
    Pattern formatoSoloLetras = Pattern.compile("[^0-9]*");
    Pattern fechaNacFormato = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contactos1);

        editTxtApellido = (EditText)findViewById(R.id.etApellido);
        editTxtNombre = (EditText)findViewById(R.id.etNombre);
        editTxtEmail = (EditText)findViewById(R.id.etEmail);
        editTxtDate = (EditText)findViewById(R.id.etFechaNac);
        editTextTel = (EditText)findViewById(R.id.etTelefono);
        editTextDireccion = (EditText)findViewById(R.id.etDireccion);
        spinnerTel = (Spinner)findViewById(R.id.spinnerTelefono);
        spinnerEmail = (Spinner)findViewById(R.id.spinnerEmail);

        //Opciones del Spinner
        String[] opciones = {"Casa", "Trabajo", "Móvil"};
        ArrayAdapter<String> adapterSpinnner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);

        spinnerTel.setAdapter(adapterSpinnner);
        spinnerEmail.setAdapter(adapterSpinnner);
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
            //Intent i = new Intent(this,AgregarContactos1.class);
            //startActivity(i);
            return true;
        } else if(id==R.id.listarContactos){
            Intent i = new Intent(this,ListarContactos.class);
            startActivity(i);
        }
        return true;
    }

    //Controlador del boton continuar
    public void btnContinuar_Click(View view)
    {
        String apellido = editTxtApellido.getText().toString().trim();
        String nombre = editTxtNombre.getText().toString().trim();
        String email = editTxtEmail.getText().toString().trim();
        String fechaNac = editTxtDate.getText().toString().trim();
        String tel = editTextTel.getText().toString().trim();
        String direccion  = editTextDireccion.getText().toString().trim();
        String sppinerTel = spinnerTel.getSelectedItem().toString();
        String sppinerEmail = spinnerEmail.getSelectedItem().toString();

        Matcher matcherApellido = formatoSoloLetras.matcher(apellido);
        Matcher matcherNombre = formatoSoloLetras.matcher(nombre);

        Matcher matcherFechaNac = fechaNacFormato.matcher(fechaNac);

        //Verifico que el apellido no contenga numeros
        if(!nombre.isEmpty() && matcherNombre.matches())
        {
            //Verifico que el nombre no contenga numeros
            if(!apellido.isEmpty() && matcherApellido.matches())
            {
                //Verifico que sea un mail valido
                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!fechaNac.isEmpty() && matcherFechaNac.matches()) //Si la fecha no esta vacia y el formato es valido dd/MM/yyyy
                    {
                        Intent viewAgregarContactos2 = new Intent(this, AgregarContactos2.class);
                        //Paso la información al 2do formulario
                        viewAgregarContactos2.putExtra("nombre", nombre);
                        viewAgregarContactos2.putExtra("apellido", apellido);
                        viewAgregarContactos2.putExtra("tel", tel);
                        viewAgregarContactos2.putExtra("email", email);
                        viewAgregarContactos2.putExtra("direccion", direccion);
                        viewAgregarContactos2.putExtra("fechaNac", fechaNac);
                        viewAgregarContactos2.putExtra("spinnerTel", sppinerTel);
                        viewAgregarContactos2.putExtra("spinnerEmail", sppinerEmail);

                        startActivity(viewAgregarContactos2);
                    } else {
                        Toast.makeText(this, "La fecha de nacimiento no es valida", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Correo electrónico no válido", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(this, "El apellido no puede quedar vacio o contener números", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "El nombre no puede quedar vacio o contener números", Toast.LENGTH_SHORT).show();
        }
    }
}