package mx.edu.utez.secondapp.models;


import mx.edu.utez.secondapp.utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoUser implements DaoRepository<User> {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private CallableStatement cs;

    //completo
    //select u.*, a.*, r.*  from users u
    //    join addresses a on u.id_address = a.id_address
    //    join roles r on u.id_role = r.id_role;

    public User loadUserByUsernameAndPassword(String usuario,
                                              String password) {
        System.out.println(usuario + password);
        try {
            conn = new MySQLConnection().connect();
            String query = "select id_user, username, password, estado, nombre, apellido_paterno.apellido_materno, curp,fecha_nacimiento,role from users where usuario=? and password=? ;";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, usuario);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id_user"));
                user.setUsuario(rs.getString("usuario"));
                user.setPassword(rs.getString("password"));
                user.setEstado((rs.getString("estado")));
                user.setNombre(rs.getString("nombre"));
                user.setApellido_paterno("apellido_paterno");
                user.setApellido_materno(rs.getString("apellido_materno"));
                user.setCurp(rs.getString("curp"));
                user.setFecha_nacimiento("curp");
                return user;

            }
        } catch (SQLException e) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE,
                            "Credentials mismatch: " + e.getMessage());
        } finally {
            close();
        }
        return null;
    }


    public void close() {
        try {
            if (conn != null) conn.close();
            if (pstm != null) pstm.close();
            if (rs != null) rs.close();
        } catch (SQLException e) {

        }

    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            conn = new MySQLConnection().connect();
            String query = "SELECT * FROM usuarios;";
            pstm  =conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsuario(rs.getString("usuario"));
                user.setPassword(rs.getString("password"));
                user.setEstado(rs.getString("estado"));
                user.setRol(rs.getString("rol"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido_paterno(rs.getString("apellido_paterno"));
                user.setApellido_materno(rs.getString("apellido_materno"));
                user.setCurp(rs.getString("curp"));
                user.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                users.add(user);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE,"ERROR findAll"+e.getMessage());
        }finally {
            close();
        }
        return users;
    }

    @Override
    public boolean save(User object) {
        try{
            conn = new MySQLConnection().connect();
            String query = "INSERT INTO usuarios (usuario,password,rol,estado,nombre,apellido_paterno,apellido_materno,curp,fecha_nacimiento)" +
                    "VALUES (?,?,'USER_ROLE','ACTIVO',?,?,?,?,?);";
            pstm = conn.prepareStatement(query);
            pstm.setString(1,object.getUsuario());
            pstm.setString(2,object.getPassword());
            pstm.setString(3,object.getNombre());
            pstm.setString(4,object.getApellido_paterno());
            pstm.setString(5,object.getApellido_materno());
            pstm.setString(6,object.getCurp());
            pstm.setString(7,object.getFecha_nacimiento());
            return  pstm.executeUpdate() > 0;
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, "Error save" + e.getMessage());
        }finally {
            close();
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
