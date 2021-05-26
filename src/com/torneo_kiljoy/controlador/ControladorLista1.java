/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.torneo_kiljoy.controlador;

import com.torneo_kiljoy.modelo.Aspirante;

/**
 *
 * @author LAURA MELISSA
 */
public class ControladorLista1 {
    public static final int NUMERO_ASPIRANTES=10;
    private Aspirante[] aspirantes;
    private int contAspirantes = 0;

    public ControladorLista1() {
        aspirantes = new Aspirante[NUMERO_ASPIRANTES];
        inicializarAspirante();
    }

    public Aspirante[] getAspirantes() {
        return aspirantes;
    }
    
    private void inicializarAspirante()
    {
        aspirantes[0] = new Aspirante("Laura Melissa", "Pinkfrost", (byte)19, (long)45621574);
    }
    
    public String adicionarAspirante(Aspirante asp)
    {
        if(contAspirantes < NUMERO_ASPIRANTES)
        {
            aspirantes[contAspirantes]=asp;
            contAspirantes++;
            return "Aspirante adicionado";
        }
        else
        {
            return "No se pueden adicionar más aspirantes";
        }
    }

    
    
    
}
