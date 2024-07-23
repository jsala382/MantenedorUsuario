package org.jsalaza.clase;

import org.jsalaza.Repositorio.Repositorio;
import org.jsalaza.conexion.*;
import org.jsalaza.modelo.Usuario;

import java.sql.*;
import java.util.Scanner;

public class usuarioRepositorioImp implements Repositorio {

    Scanner input = new Scanner(System.in);

    @Override
    public Usuario actualizar(String opcionUsaurio) {
        Usuario usuario = new Usuario();
        try {
            Connection connection = conexionBBDD.getConnection();
            String sql = "SELECT *FROM tabla_usuario.usuario where username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, opcionUsaurio);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usuario.setId(resultSet.getInt("id"));
                usuario.setUsername(resultSet.getNString("username"));
                usuario.setPassword(resultSet.getNString("password"));
                usuario.setEmail(resultSet.getString("email"));
                System.out.println("el usuario existe");
            } else {
                System.out.println("NO EXISTE EL USURIO PRESIONe 3 PARA CREARLO");
            }
        } catch (SQLException e) {
            throw new RuntimeException("ERROR AL ACTUALZAR LA BASE DE DATOS" + e);
        }

        return usuario;
    }

    @Override
   public Usuario insertUsuario(Usuario user) {

        try {
            Connection connection = conexionBBDD.getConnection();
            String sql = "insert into tabla_usuario.usuario (username,password,email) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.executeUpdate();
        } catch (SQLException E) {
            throw new RuntimeException("ERROR AL INSERTAR DATOS" + E);
        }

        return user;
    }

    public Usuario crearUsuario(Usuario usuario) {
        System.out.println("Ingrese el nombre del usuraio");
        String username = input.next();
        System.out.println("Ingrese la contrasena");
        String password = input.next();
        System.out.println("Ingrese el email");
        String email = input.next();
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setEmail(email);
        insertUsuario(usuario);
        return usuario;
    }


    @Override
    public void eliminarUsuario(String usuario) {
        try {
            Connection conn = conexionBBDD.getConnection();
            String sql = "delete from tabla_usuario.usuario where username=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, usuario);
            System.out.println("DESEA ELIMINAR AL USUARUO");
            String respuesta = input.next();
            if (respuesta.equalsIgnoreCase("SI")) {
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("ERROR AL ELIMINAR UN USUARIO");
        }
    }

    @Override
    public void Listar() {
        try{
            Connection connection=  conexionBBDD.getConnection();
            String sql="select *from tabla_usuario.usuario";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.print(resultSet.getInt("id"));
                System.out.print("|");
                System.out.print(resultSet.getString("username"));
                System.out.print("|");
                System.out.print(resultSet.getString("password"));
                System.out.print("|");
                System.out.println(resultSet.getString("email"));
            }

        }catch (SQLException e){
            throw new RuntimeException("ERROR AL LISTAR LA BASE" +e);
        }
    }
}
