package com.example.exament3.Model;

public class EntrenadorClass {
    String nombre, pueblo, url_imagen;

    public EntrenadorClass() {
    }

    public EntrenadorClass(String nombre, String tipo, String url_imagen) {
        this.nombre = nombre;
        this.pueblo = pueblo;
        this.url_imagen = url_imagen;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPueblo() {
        return pueblo;
    }

    public void setPueblo(String pueblo) {
        this.pueblo = pueblo;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }
}
