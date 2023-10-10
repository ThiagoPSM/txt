/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

import java.util.ArrayList;
import entidades.Usuarios;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Thiago
 */
public class registrar {
    
    public static Usuarios nuevoUsuario(JTextField usuario, JPasswordField contraseña){
        String nombreUsuario = usuario.getText();
        String contraseñaUsuario= String.valueOf(contraseña.getPassword());
        
        Usuarios u = new Usuarios(nombreUsuario, contraseñaUsuario);

        return u;
     }
    
    }

