/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.torneo_kiljoy.controlador;

import com.torneo_kiljoy.excepciones.UsuarioExcepcion;
import com.torneo_kiljoy.modelo.Rol;
import com.torneo_kiljoy.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author LAURA MELISSA
 */
public class ControladorUsuario {

    private Rol[] roles;
    private List<Usuario> usuarios;

    public ControladorUsuario() {
        inicializarColecciones();
    }

    private void inicializarColecciones() {
        roles = new Rol[3];
        roles[0] = new Rol((byte) 1, "Asministrador");
        roles[1] = new Rol((byte) 2, "Aspirante");
        roles[2] = new Rol((byte) 3, "Participante");

        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("meli@gmail.com", "123456", roles[0],"Laura"));
        usuarios.add(new Usuario("lucas@gmail.com", "123456", roles[1],"Lucas"));
        usuarios.add(new Usuario("andres@gmail.com", "123456", roles[2],"Andres"));
    }

//    public boolean verificarUsuario(String correo, String contrasenia)
//    {
//        for(Usuario usu: usuarios)
//        {
//            if (usu.getCorreo().equals(correo)
//                  && (usu.getContrasenia().equals(contrasenia))  )
//            {
//              return true;  
//            }
//        }
//        return false;
//    }
//    
    public Usuario verificarUsuario(String correo, String contrasenia)
            throws UsuarioExcepcion {
        if (correo == null || correo.equals("") || contrasenia == null
                || contrasenia.equals("")) {
            throw new UsuarioExcepcion("Debe diligenciar todos los datos");
        }
        if (!validarCorreo(correo)) {
            throw new UsuarioExcepcion("En el campo usuario debe ingresar un correo válido");
        }
        if (contrasenia.length() < 6) {
            throw new UsuarioExcepcion("La contraseña debe tener al menos 6 caracteres");
        }
        for (Usuario usu : usuarios) {
            if (usu.getCorreo().equals(correo)
                    && (usu.getContrasenia().equals(contrasenia))) {
                return usu;
            }
        }
        //Significa que el ususario o la contraseña son errados
        throw new UsuarioExcepcion("Los datos ingresados son errados");
      
    }

    private boolean validarCorreo(String email) {
        boolean espacios = true;

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher matcher = pattern.matcher(email);

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == ' ') {
                espacios = false;
                break;
            }
        }

        return matcher.find() && espacios;
    }

}
