package mx.edu.utez.secondapp.models;

import mx.edu.utez.secondapp.utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Daoclases implements DaoRepository{
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public List<clases> findAll() {
        List<clases> clases = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * from clases;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                clases clase1 = new clases();
                clase1.setId(rs.getLong("id"));
                clase1.setNombre(rs.getString("nombre"));
                clase1.setEstado(rs.getString("estado"));
                clase1.setDescripcion(rs.getString("descripcion"));
                clase1.setIdinstructor(rs.getInt("idinstructor"));
                clases.add(clase1);
            }
        }catch (SQLException e){
            Logger.getLogger(Daoclases.class.getName()).log(Level.SEVERE, "Error findAll"+e.getMessage());
        }finally {
            close();
        }
        return clases;
    }

    @Override
    public boolean save(Object object) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
    public void close() {
        try {
            if (conn != null) conn.close();
            if (pstm != null) pstm.close();
            if (rs != null) rs.close();
        } catch (SQLException e) {

        }

    }
}
