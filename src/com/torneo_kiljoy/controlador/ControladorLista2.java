/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.torneo_kiljoy.controlador;

import com.torneo_kiljoy.excepciones.JugadorExcepcion;
import com.torneo_kiljoy.modelo.Aspirante;
import com.torneo_kiljoy.modelo.Participante;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author LAURA MELISSA
 */
public class ControladorLista2 {

    public static final int NUMERO_PARTICIPANTES = 5;
    private Participante[] participantes;
    private int contParicipantes = 0;

    public ControladorLista2() {
        participantes = new Participante[NUMERO_PARTICIPANTES];
        llenarParticipantes();
    }
    
    public void llenarParticipantes() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String nombre;
        String nickname;
        byte edad;
        long puntuacion;
        Participante participante;
        int contador=0;

        try {
            archivo = new File("participantes.txt");
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
                participante = new Participante(nombre, nickname, edad, puntuacion);
                participantes[contador]=participante;
                contador++;
                contParicipantes++;
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

    public Participante[] getParticipantes() {
        return participantes;
    }


    public String adicionarParticipante(Participante part) {
        if (contParicipantes < NUMERO_PARTICIPANTES) {
            participantes[contParicipantes] = part;
            contParicipantes++;
            return "Participante adicionado";
        } else {
            return "No se pueden adicionar más participantes";
        }
    }

    public Participante verificarParticipante(String nombre, String nickname, String edad, String puntuacion)
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
    
    public void completar(Participante participante) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("participantes.txt", true);
            pw = new PrintWriter(fichero);
            
                pw.println("\n"+participante.getNombre()+","+participante.getNickname()+","+participante.getEdad()+","+participante.getPuntuacion());
            

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
