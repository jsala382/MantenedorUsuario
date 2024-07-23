package org.jsalaza;

import org.jsalaza.clase.usuarioRepositorioImp;
import org.jsalaza.modelo.Usuario;

import java.sql.ResultSet;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class aplicacion {
    public static void main(String[] args) {
        int opcion = 0;
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        Usuario usuario=new Usuario();
        usuarioRepositorioImp usuarioRepositorioImp=new usuarioRepositorioImp();


        System.out.println("Lista de opciones");
        System.out.println("Presione 1 para actualizar");
        System.out.println("Presione 2 para Eliminarr");
        System.out.println("Presione 3 para para crear");
        System.out.println("Presione 4 para Listar");
        System.out.println("Presione  5 para Salir");


        do {
            System.out.println("Ingresar la opcion");
            opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingresar el usuario");
                    String option = input.next();
                    usuarioRepositorioImp.actualizar(option);
                    break;
                case 2:
                    System.out.println("Ingrese el usuario a eliminar");
                    String option2=input.next();
                    usuarioRepositorioImp.eliminarUsuario(option2);
                    break;
                case 3:
                    usuarioRepositorioImp.crearUsuario(usuario);
                    break;
                case 4:
                    usuarioRepositorioImp.Listar();
                    break;
                case 5:
                    flag = false;
                    break;
            }
        } while (flag);

    }
}