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
public class MatPrimaDao implements CRUD{
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
           List <MateriaPrima> lista = new ArrayList<>();
        String sql = " select * from matprima";
        try {
            con= cn.Conectar();
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                MateriaPrima mp = new MateriaPrima();
                mp.codmat=rs.getInt(1);
                mp.nombre= rs.getString(2);
                mp.feccad=rs.getString(3);
                mp.cantidad = rs.getInt(4);
                mp.unidad = rs.getString(5);
                mp.precio = rs.getDouble(6);
               lista.add(mp);
                
                
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
         int r=0;
      String sql = "insert into matprima(codmat,nombre,feccad,cantidad,unidad,precio) values (?,?,?,?,)";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
