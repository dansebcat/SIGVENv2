/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author danie
 */
public class UsuarioDao {

    PreparedStatement ps;
    ResultSet rs;

    Conexion con = new Conexion();
    Connection acceso;

    public EtnidadUsuario validarUsuario(String user, String pass) {
        EtnidadUsuario usuario = new EtnidadUsuario();
        String sql = " select * from usuario where codusuario=? and Password=?";
        try {
            acceso = con.Conectar();
            ps = (PreparedStatement) acceso.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                usuario.setNickname(rs.getString(1));
                usuario.setPassword(rs.getString(2));

            }
        } catch (Exception e) {
        }
        return usuario;
    }

    public EtnidadUsuario registrarUsuario(String user, String pass) {
        ps = null;
        rs = null;
        EtnidadUsuario usuario = new EtnidadUsuario();
        String sql = "INSERT INTO `usuario` (`codusuario`, `Password`) VALUES (?,?)";
        try {
            acceso = con.Conectar();
            ps = (PreparedStatement) acceso.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.execute();
            usuario.setNickname(user);
            usuario.setPassword(pass);
        } catch (Exception e) {

        }
        return usuario;
    }

    public boolean existeUsuario(String user) {
        ps = null;
        rs = null;
        String sql = "select * from usuario where codusuario=?";
        try {
           acceso=con.Conectar();
           ps=(PreparedStatement) acceso.prepareStatement(sql);
           ps.setString(1, user);
           rs = ps.executeQuery();
           return rs.next();
        } catch (Exception e) {
            return false;
        }

    }
}
