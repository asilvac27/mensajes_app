/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.armando.mensajesapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ares
 */
public class MensajesDAO {

    public static void insertaMensaje(Mensaje mensaje) {
        Conexion conexion = new Conexion();
        PreparedStatement pstmt = null;
        try {
            Connection conn = conexion.getConexion();
            String query = "insert into mensajes (mensaje, autor_mensaje) values (?,?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, mensaje.getMensaje());
            pstmt.setString(2, mensaje.getAutorMensaje());

            pstmt.executeUpdate();

            System.out.println("Se creo el mensaje");

        } catch (Exception e) {
            System.err.println("No se pudo realizar a conexion " + e.getMessage());
        }

    }

    public static List<Mensaje> traerMensajes() {
        Conexion conexion = new Conexion();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Mensaje> listaMensajes = new ArrayList();
        Mensaje mensaje = null;
        try {
            Connection conn = conexion.getConexion();
            String query = "select id_mensaje,\n"
                    + "	   mensaje,\n"
                    + "       autor_mensaje,\n"
                    + "       fecha_mensaje\n"
                    + " from mensajes";

            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                mensaje = new Mensaje();
                mensaje.setIdMensaje(rs.getInt("id_mensaje"));
                mensaje.setMensaje(rs.getString("mensaje"));
                mensaje.setAutorMensaje(rs.getString("autor_mensaje"));
                mensaje.setFechaMensaje(new Date(rs.getDate("fecha_mensaje").getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
                listaMensajes.add(mensaje);

            }

            //System.out.println("Se recuperaron todos los mensajes");
        } catch (SQLException e) {
            System.err.println("No se pudieron consultar la conexion " + e.getMessage());
        }

        return listaMensajes;
    }

    public static int editaMensaje(Mensaje mensaje) {
        Conexion conexion = new Conexion();
        PreparedStatement pstmt = null;
        int regreso = 0;
        try (Connection conn = conexion.getConexion()) {
            String query = "update mensajes set mensaje= ?, autor_mensaje=? where id_mensaje = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, mensaje.getMensaje());
            pstmt.setString(2, mensaje.getAutorMensaje());
            pstmt.setInt(3, mensaje.getIdMensaje());

            regreso = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al editar mensaje " + e.getMessage());
        }
        
        return regreso;
    }

    public static int eliminaMensaje(int idMensaje) {
        Conexion conexion = new Conexion();
        PreparedStatement pstmt = null;
        int regreso = 0;
        try {
            Connection conn = conexion.getConexion();
            String query = "delete from mensajes where id_mensaje = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idMensaje);
            regreso = pstmt.executeUpdate();

            System.out.println("Se eliminó el mensaje");

        } catch (Exception e) {
            System.err.println("No se pudo borrar el mensaje conexion " + e.getMessage());
        }

        return regreso;
    }

}
