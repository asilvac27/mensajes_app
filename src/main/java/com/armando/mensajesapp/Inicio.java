/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.armando.mensajesapp;

import java.util.Scanner;

/**
 *
 * @author Ares
 */
public class Inicio {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        do {
            if (opcion > 5) {
                System.out.println("Opción invalida");
            }
            System.out.println("Aplicación de mensajes");
            System.out.println("1.- Crear");
            System.out.println("2.- Listar");
            System.out.println("3.- Editar");
            System.out.println("4.- Eliminar");
            System.out.println("5.- Salir");
            System.out.println("");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    for (Mensaje msg : MensajesService.listarMensajes()) {
                        System.out.println("IdMensaje " + msg.getIdMensaje() + "\nMensaje: " + msg.getMensaje() +
                                "\nAutor: " + msg.getAutorMensaje() + "\nFecha " + msg.getFechaMensaje() + " s  adasd");
                    }
                    break;
                case 3:
                    if(MensajesService.modificarMensaje()!=0){
                        System.out.println("Mensaje editado!");
                    }else{
                        System.out.println("No se pudo editar el mensaje");
                    }
                    break;
                case 4:
                    int regreso = MensajesService.borrarMensaje();
                    if (regreso != 0) {
                        System.out.println("Se borró el mensaje.");
                    } else {
                        System.out.println("No se enontro el mensaje!");
                    }

                    break;
                default:
                    break;

            }

        } while (opcion != 5);

    }
}
