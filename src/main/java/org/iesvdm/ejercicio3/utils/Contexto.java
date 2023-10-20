package org.iesvdm.ejercicio3.utils;

import org.iesvdm.ejercicio3.Login;
import org.iesvdm.ejercicio3.User;
import org.iesvdm.ejercicio3.annotations.Credencial;
import org.iesvdm.ejercicio3.annotations.Credenciales;

public class Contexto {

    public static void cargadorDeContexto(Login nuevo){

        Credenciales usuarios = nuevo.getClass().getAnnotation(Credenciales.class);
        Credencial[] webUser = usuarios.value();

        // itero para cargar las anotaciones:

        for (Credencial pass: webUser) {

            String usuario = pass.usuario();
            String password = pass.password();

            nuevo.getListaCredenciales().add(new User(usuario, password));
        }
    }
}
