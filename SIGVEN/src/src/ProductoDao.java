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
public class ProductoDao implements CRUD{
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
        List <Producto> lista = new ArrayList<>();
        String sql = " select * from producto";
        try {
            con= cn.Conectar();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.codproducto=rs.getInt(1);
                p.nombre= rs.getString(2);
                p.precio=rs.getDouble(3);
                p.tipo = rs.getString(4);
               lista.add(p);
                
                
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
         int r=0;
      String sql = "insert into producto(codproducto,nombre,precio,tipo) values (?,?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
          String sql = " update producto set nombre=?,precio=?,tipo=? where codproducto=?";
        int r =0;
        try {
            con= cn.Conectar();
            ps=con.prepareStatement(sql);
             ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
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
