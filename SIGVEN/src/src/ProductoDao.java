/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class ProductoDao implements CRUD{
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
public Producto consultar (String nombre){
    Producto p = new Producto();
  String sql = "select * from producto where nombres=?";
   try {
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        ps.setString(1, nombre);
        rs=ps.executeQuery();
        while(rs.next()){
            p.codproducto=rs.getInt(1);
                p.nombre= rs.getString(2);
                 p.tipo = rs.getString(3);
                p.precio=rs.getDouble(4);
            
        }
    } catch (Exception e) {
    }
    return p;
  
} 
public Producto consultar (int codproducto){
    Producto p = new Producto();
  String sql = "select * from producto where codproducto=?";
   try {
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        ps.setInt(1, codproducto);
        rs=ps.executeQuery();
        while(rs.next()){
            p.codproducto=rs.getInt(1);
                p.nombre= rs.getString(2);
                 p.tipo = rs.getString(3);
                p.precio=rs.getDouble(4);
            
        }
    } catch (Exception e) {
    }
    return p;
  
}  
public boolean existeProducto(String nombre){
    String sql = "select * from producto where nombres=?";
    try {
        con = cn.Conectar();
        ps = con.prepareStatement(sql);
        ps.setString(1, nombre);
        rs=ps.executeQuery();
        if(rs.next()){
            return true;
        }else{
            return false;
        }
    } catch (Exception e) {
    }
    return false;
}
    @Override
    public List listar() {
        List <Producto> lista = new ArrayList<>();
        String sql ="select * from producto";
        try {
            con= cn.Conectar();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.codproducto=rs.getInt(1);
                p.nombre= rs.getString(2);
                 p.tipo = rs.getString(3);
                p.precio=rs.getDouble(4);
              
               lista.add(p);    
            }
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null,s);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"otro error");
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
         int r=0;
      String sql = "insert into producto(nombres,tipo,precio) values (?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            r = ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }catch (Exception s){
              JOptionPane.showMessageDialog(null, "Error" + s);
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
