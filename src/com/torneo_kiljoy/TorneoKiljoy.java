/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.torneo_kiljoy; //www.torneokiljoy.com

import com.torneo_kiljoy.controlador.ControladorLista1;
import com.torneo_kiljoy.modelo.Aspirante;


/**
 *
 * @author LAURA MELISSA
 */
public class TorneoKiljoy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ControladorLista1 control = new ControladorLista1();
        control.adicionarAspirante(new Aspirante("Salo" , "Skillghost", (byte)18, 8987689));
        control.adicionarAspirante(new Aspirante("Meli" , "Pinkfrost", (byte)18, 32545452));
        control.adicionarAspirante(new Aspirante("Andres" , "Macheta08", (byte)18, 4545642));
        control.adicionarAspirante(new Aspirante("Milena" , "Macheta05", (byte)18, 724695169));
        control.adicionarAspirante(new Aspirante("Mauricio" , "Petroski", (byte)18, 354687951));
        control.adicionarAspirante(new Aspirante("Petroski" , "Uriboski", (byte)18, 45878545));
        control.adicionarAspirante(new Aspirante("Camilo" , "Pink", (byte)18, 854695));
        control.adicionarAspirante(new Aspirante("Santiago" , "frost", (byte)18, 8));
        control.adicionarAspirante(new Aspirante("nop" , "cait", (byte)18, 7689));
        
        
        System.out.println(control.adicionarAspirante(new Aspirante("nidea" , "Barry", (byte)18, 9)));
    
    }
    
    
      
}
