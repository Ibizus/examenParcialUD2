package org.iesvdm.ejercicio3;

import org.iesvdm.ejercicio3.utils.Contexto;

public class Main {

    public static void main(String[] args) {

        Login nuevo = new Login();
        Contexto.cargadorDeContexto(nuevo);

        for (User usuario: nuevo.getListaCredenciales()) {

            System.out.println(usuario);
        }
    }
}
