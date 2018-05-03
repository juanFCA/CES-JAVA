/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JAVABEANS.Usuarios;
import JDBC.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alunoces
 */
public class UsuarioDao {
    
    private final Connection conecta;
    private PreparedStatement stmt;
    private String cmdsql;

    public UsuarioDao() {
        this.conecta = new ConnectionFactory().conecta();
    }
    
    public void cadastrarUsuario(Usuarios obj) {
        try {
            String cmdsql = "INSERT INTO usuario(email, senha, tipo) VALUES (?, ?, ?)";
            stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setString(1, obj.getEmail());
            stmt.setString(2, obj.getSenha());
            stmt.setString(3, obj.getTipo());
           
            stmt.execute();
            stmt.close();
            
        } catch(SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
    
    public List<Usuarios> listarUsuarios() {
        try {
            List<Usuarios> lista = new ArrayList<Usuarios>();
            cmdsql = "SELECT * FROM usuario";
            stmt = conecta.prepareStatement(cmdsql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Usuarios us = new Usuarios();
                us.setId(rs.getInt("id"));
                us.setEmail(rs.getString("email"));
                us.setSenha(rs.getString("senha"));
                us.setTipo(rs.getString("tipo"));
                
                lista.add(us);
            }
            
            return lista;
            
        } catch(SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
    
    public void alterarUsuario(Usuarios obj) {
        try {
            cmdsql = "UPDATE usuario SET email=?, senha=?, tipo=? WHERE id=?";
            stmt = conecta.prepareStatement(cmdsql);
        
            stmt.setString(1, obj.getEmail());
            stmt.setString(2, obj.getSenha());
            stmt.setString(3, obj.getTipo());
            stmt.setInt(4, obj.getId());
            
            stmt.execute();
            stmt.close();            
            
        } catch(SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
    
    public void excluirUsuario(Usuarios obj) {
        try {
            cmdsql = "DELETE FROM usuario WHERE id=?";
            stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setInt(1, obj.getId());
            
            stmt.execute();
            stmt.close();
            
        } catch(SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
}
