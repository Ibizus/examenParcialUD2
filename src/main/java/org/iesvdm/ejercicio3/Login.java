package org.iesvdm.ejercicio3;


import org.iesvdm.ejercicio3.annotations.Credencial;

import java.util.ArrayList;
import java.util.List;

@Credencial(usuario = "usuario1", password="1234")
@Credencial(usuario = "ususario2", password="admin.1")

public class Login {

    public List<User> listaCredenciales = new ArrayList<>();

    public Login(){}

    public List<User> getListaCredenciales() {
        return listaCredenciales;
    }
}
