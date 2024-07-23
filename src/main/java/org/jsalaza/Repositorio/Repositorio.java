package org.jsalaza.Repositorio;

import org.jsalaza.modelo.Usuario;

public interface Repositorio {
    Usuario actualizar(String opcionUsuario);

    Usuario insertUsuario(Usuario usuario);

    void eliminarUsuario(String usuario);

    void Listar();

}
