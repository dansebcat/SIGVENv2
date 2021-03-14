/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danie
 */
public class ClienteDao  implements CRUD{
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
        
        List <Cliente> lista = new ArrayList<>();
        String sql = " select * from cliente";
        try {
            con= cn.Conectar();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                c.ci=rs.getString(1);
                c.nombres= rs.getString(2);
                c.apellidos=rs.getString(3);
                c.domicilio = rs.getString(4);
                c.numero=rs.getInt(5);
                c.email=rs.getString(6);
                c.estado = rs.getBoolean(7);
                lista.add(c);
                
                
            }
        } catch (Exception e) {
        }
        return lista;
        
    }

    @Override
    public int add(Object [] o) {
        int r=0;
      String sql = "insert into cliente(ci,nombres,apellidos,domicilio,numero,email,estado) values (?,?,?,?,?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            ps.setObject(7, o[6]);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public int actualizar(Object [] o) {
        String sql = " update cliente set nombres=?,apellidos=?,domicilio=?,numero=?,email=?,estado=? where ci=?";
        int r =0;
        try {
            con= cn.Conectar();
            ps=con.prepareStatement(sql);
             ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r ;
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
