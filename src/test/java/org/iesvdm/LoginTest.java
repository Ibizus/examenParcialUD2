package org.iesvdm;

import org.iesvdm.ejercicio3.Login;
import org.iesvdm.ejercicio3.utils.Contexto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

    Login nuevo;

    @Test
    @BeforeEach
    public void testProcesadorDeContexto(){

        nuevo = new Login();
        Contexto.cargadorDeContexto(nuevo);
    }

    @Test
    public void testCargadorFunciona(){

        int expected = 2;
        Assertions.assertEquals(expected, nuevo.getListaCredenciales().size());
    }


}
