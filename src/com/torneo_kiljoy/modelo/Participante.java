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
public class Participante extends Aspirante implements Serializable{

    public Participante(String nombre, String nickname, byte edad, long puntuacion) {
        super(nombre, nickname, edad, puntuacion);
    }

    @Override
    public String obtenerCodigo( String nickname) {
        
        setCodigo(getCodigo()+"final");
        return super.obtenerCodigo(nickname); //To change body of generated methods, choose Tools | Templates.
    }
    
}
