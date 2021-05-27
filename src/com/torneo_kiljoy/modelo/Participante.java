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
    
    private String codigo;

    public Participante(String nombre, String nickname, byte edad, long puntuacion) {
        super(nombre, nickname, edad, puntuacion);
        codigo = "Final" + obtenerCodigo(nickname);
    }

    /**
     * @param codigo the codigo to set
     */
    @Override
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the codigo
     */
    @Override
    public String getCodigo() {
        return codigo;
    }
    
}
