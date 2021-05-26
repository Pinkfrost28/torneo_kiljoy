/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.torneo_kiljoy.modelo;

import java.io.Serializable;

/**
 *
 * @author LAURA MELISSA
 */
public class Aspirante implements Serializable {
    private String nombre;
    private String codigo;
    private String nickname;
    private byte edad;
    private long puntuacion;

    public Aspirante(String nombre, String nickname, byte edad, long puntuacion) {
        this.nombre = nombre;
        this.nickname = nickname;
        this.edad = edad;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public long getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(long puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    public String obtenerCodigo(String nickname){
        
        char primer;
        char segundo;
        
        primer = nickname.charAt(0);
        segundo = nickname.charAt(1);
        
        this.codigo = Character.toString(primer) + "Kiljoy" + Character.toString(segundo) + Math.floor(Math.random()*20);
            System.out.println(this.codigo);
        return this.codigo;
}
}    