package com.gendigital.tiendamascotas.pojo;

import java.util.ArrayList;

/**
 * Created by Gaby on 10/06/2016.
 */
public class PetInfo {
    private String nombre;
    private int foto;
    private int meGusta;
    private static ArrayList<Object> listaItems = new ArrayList<Object>();

    public PetInfo() {
        this.nombre = "";
        this.foto = 0;
        this.meGusta = 0;
    }

    public PetInfo(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
        this.meGusta = 0;
    }

    public PetInfo(String nombre, int foto, int meGusta) {
        this.nombre = nombre;
        this.foto = foto;
        this.meGusta = meGusta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getMeGusta() {
        return String.valueOf(meGusta);
    }

    public void setMeGusta(int meGusta) {
        this.meGusta = meGusta;
    }
    public void incrementaMeGusta() {
        this.meGusta ++;
    }

    public static void setItem(Object newObjeto) {
        listaItems.add(newObjeto);
    }

    public static PetInfo getItem(int indice) {
        return (PetInfo) listaItems.get(indice);
    }
}