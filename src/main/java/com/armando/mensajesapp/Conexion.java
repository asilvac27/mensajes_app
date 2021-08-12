/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.armando.mensajesapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;

/**
 *
 * @author Ares
 */
public class Conexion {
    
    
    public Connection getConexion(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_db", "root", "Armando#27");
//            if(!Objects.isNull(conn)){
//                System.out.println("Se creó la conexion");
//            }
        } catch (Exception e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
         
        return conn;
    }
}
