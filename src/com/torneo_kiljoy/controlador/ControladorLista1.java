/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.torneo_kiljoy.controlador;

import com.torneo_kiljoy.excepciones.JugadorExcepcion;
import com.torneo_kiljoy.modelo.Aspirante;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author LAURA MELISSA
 */
public class ControladorLista1 {

    public static final int NUMERO_ASPIRANTES = 10;
    private Aspirante[] aspirantes;
    private int contAspirantes = 0;

    public ControladorLista1() {
        aspirantes = new Aspirante[NUMERO_ASPIRANTES];
        llenarAspirantes();
    }

    public void llenarAspirantes() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String nombre;
        String nickname;
        byte edad;
        long puntuacion;
        Aspirante aspirante;
        int contador = 0;

        try {
            archivo = new File("aspirantes.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            String[] datos;
            while ((linea = br.readLine()) != null) {
                datos = linea.split(",");
                nombre = datos[0];
                nickname = datos[1];
                edad = Byte.parseByte(datos[2]);
                puntuacion = Long.parseLong(datos[3]);
                aspirante = new Aspirante(nombre, nickname, edad, puntuacion);
                aspirantes[contador] = aspirante;
                contador++;
                contAspirantes++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public Aspirante[] getAspirantes() {
        return aspirantes;
    }

    public String adicionarAspirante(Aspirante asp) {
        if (contAspirantes < NUMERO_ASPIRANTES) {
            aspirantes[contAspirantes] = asp;
            contAspirantes++;
            return "Aspirante adicionado";
        } else {
            return "No se pueden adicionar más aspirantes";
        }
    }

    public Aspirante verificarAspirante(String nombre, String nickname, String edad, String puntuacion)
            throws JugadorExcepcion {

        if (nombre == null || nombre.equals("") || nickname == null || nickname.equals("")) {
            throw new JugadorExcepcion("Debe diligenciar todos los datos");
        }
        if (Byte.parseByte(edad) < 15 || Byte.parseByte(edad) > 50) {
            throw new JugadorExcepcion("Edad invalida");
        }
        if (!isNumeric(puntuacion)) {
            throw new JugadorExcepcion("Puntuación debe ser numérico");
        }

        if (nickname.length() < 2) {
            throw new JugadorExcepcion("El nickname debe tener al menos 2 caracteres");
        }

        return null;

    }

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public void completar(Aspirante aspirante) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("aspirantes.txt", true);
            pw = new PrintWriter(fichero);
            
                pw.println("\n"+aspirante.getNombre()+","+aspirante.getNickname()+","+aspirante.getEdad()+","+aspirante.getPuntuacion());
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
