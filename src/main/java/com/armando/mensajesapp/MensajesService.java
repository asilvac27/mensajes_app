/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.armando.mensajesapp;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ares
 */
public class MensajesService {

    public static void crearMensaje() {
        Scanner sc = new Scanner(System.in);
        Mensaje mensaje = new Mensaje();
        System.out.println("Escriba el mensaje:");
        String msg = sc.nextLine();

        System.out.println("Su nombre:");
        String nombre = sc.nextLine();
        mensaje.setMensaje(msg);
        mensaje.setAutorMensaje(nombre);

        MensajesDAO.insertaMensaje(mensaje);
    }

    public static List<Mensaje> listarMensajes() {
        return MensajesDAO.traerMensajes();

    }

    public static int modificarMensaje() {
        Scanner sc = new Scanner(System.in);
        Mensaje mensaje = new Mensaje();
        String str = null;
        System.out.println("Id del mensaje a editar:");
        int id = sc.nextInt();
        mensaje.setIdMensaje(id);
        System.out.println("Ingrese el nuevo texto del mensaje");
        sc = new Scanner(System.in);
        str = sc.nextLine();
        mensaje.setMensaje(str);
        System.out.println("Ingrese el nuevo autor:");
        str = sc.nextLine();
        mensaje.setAutorMensaje(str);

        return MensajesDAO.editaMensaje(mensaje);
    }

    public static int borrarMensaje() {
        System.out.println("Id del mensaje a eliminar:");
        Scanner sc = new Scanner(System.in);
        int idMensaje = sc.nextInt();
        return MensajesDAO.eliminaMensaje(idMensaje);

    }

}
