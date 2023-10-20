package org.iesvdm.ejercicio3;

import java.util.Objects;

public class User {

    private String usuario;
    private String password;

    public User(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(usuario, that.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario);
    }

    public String getUser() {
        return usuario;
    }

    public void setUser(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
