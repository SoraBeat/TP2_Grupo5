package com.example.tp2_grupo5;

public class Persona {
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String SpinnerTelefono;
    private String Email;
    private String SpinnerEmail;
    private String Date;
    private String Direccion;
    private String radeoGroup;
    private String Intereses;
    private String Informacion;

    public Persona(String nombre, String apellido, String telefono, String spinnerTelefono, String email, String spinnerEmail, String date, String direccion, String radeoGroup, String intereses, String informacion) {
        Nombre = nombre;
        Apellido = apellido;
        Telefono = telefono;
        SpinnerTelefono = spinnerTelefono;
        Email = email;
        SpinnerEmail = spinnerEmail;
        Date = date;
        Direccion = direccion;
        this.radeoGroup = radeoGroup;
        Intereses = intereses;
        Informacion = informacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getSpinnerTelefono() {
        return SpinnerTelefono;
    }

    public void setSpinnerTelefono(String spinnerTelefono) {
        SpinnerTelefono = spinnerTelefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSpinnerEmail() {
        return SpinnerEmail;
    }

    public void setSpinnerEmail(String spinnerEmail) {
        SpinnerEmail = spinnerEmail;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getRadeoGroup() {
        return radeoGroup;
    }

    public void setRadeoGroup(String radeoGroup) {
        this.radeoGroup = radeoGroup;
    }

    public String getIntereses() {
        return Intereses;
    }

    public void setIntereses(String intereses) {
        Intereses = intereses;
    }

    public String getInformacion() {
        return Informacion;
    }

    public void setInformacion(String informacion) {
        Informacion = informacion;
    }

    @Override
    public String toString() {
        return "com.example.tp2_grupo5.Persona{" +
                "Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", SpinnerTelefono='" + SpinnerTelefono + '\'' +
                ", Email='" + Email + '\'' +
                ", SpinnerEmail='" + SpinnerEmail + '\'' +
                ", Date='" + Date + '\'' +
                ", Direccion='" + Direccion + '\'' +
                ", radeoGroup='" + radeoGroup + '\'' +
                ", Intereses='" + Intereses + '\'' +
                ", Informacion='" + Informacion + '\'' +
                '}';
    }
}
