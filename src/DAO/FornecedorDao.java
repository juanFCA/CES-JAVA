/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JAVABEANS.Fornecedores;
import JDBC.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juan
 */
public class FornecedorDao {
    
    private final Connection conecta;
    private PreparedStatement stmt;
    private String cmdsql;

    public FornecedorDao() {
        this.conecta = new ConnectionFactory().conecta();
    }
    
    public void CadastrarFornecedor(Fornecedores obj) {
        try {
            String cmdsql = "INSERT INTO fornecedor(for_nome, for_rua, for_numero, for_bairro, "
                    + "for_cidade, for_uf, for_telefone) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRua());
            stmt.setInt(3, obj.getNumero());
            stmt.setString(4, obj.getBairro());
            stmt.setString(5, obj.getCidade());
            stmt.setString(6, String.valueOf(obj.getUf()));
            stmt.setString(7, obj.getTelefone());
            
            stmt.execute();
            stmt.close();
            
        } catch(SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
    
    public List<Fornecedores> listarFornecedores() {
        try {
            List<Fornecedores> lista = new ArrayList<Fornecedores>();
            cmdsql = "SELECT * FROM fornecedor";
            stmt = conecta.prepareStatement(cmdsql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Fornecedores f = new Fornecedores();
                f.setId(rs.getInt("for_id"));
                f.setNome(rs.getString("for_nome"));
                f.setRua(rs.getString("for_rua"));
                f.setNumero(rs.getInt("for_numero"));
                f.setBairro(rs.getString("for_bairro"));
                f.setCidade(rs.getString("for_cidade"));
                f.setUf(rs.getString("for_uf"));
                f.setTelefone(rs.getString("for_telefone"));
                
                lista.add(f);
            }
            
            return lista;
            
        } catch(SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
    
    public void alterarFornecedor(Fornecedores obj) {
        try {
            cmdsql = "UPDATE fornecedor SET for_nome=?, for_rua=?, for_numero=?, for_bairro=?, "
                    + "for_cidade=?, for_uf=?, for_telefone=? WHERE for_id=?";
            stmt = conecta.prepareStatement(cmdsql);
        
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRua());
            stmt.setInt(3, obj.getNumero());
            stmt.setString(4, obj.getBairro());
            stmt.setString(5, obj.getCidade());
            stmt.setString(6, String.valueOf(obj.getUf()));
            stmt.setString(7, obj.getTelefone());
            stmt.setInt(8, obj.getId());
            
            stmt.execute();
            stmt.close();            
            
        } catch(SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
    
    public void excluirFornecedor(Fornecedores obj) {
        try {
            cmdsql = "DELETE FROM fornecedor WHERE for_id=?";
            stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setInt(1, obj.getId());
            
            stmt.execute();
            stmt.close();
            
        } catch(SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
}
