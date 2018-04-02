/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JAVABEANS.Produtos;
import JDBC.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonas
 */
public class ProdutoDao {
    
    private final Connection conecta;
    private PreparedStatement stmt;
    private String cmdsql;
    
    public ProdutoDao() {
        this.conecta = new ConnectionFactory().conecta();
    }
    
    
    public void cadastrarProduto(Produtos obj){
        try{
            cmdsql = "INSERT INTO produto(pro_nome, pro_descricao, pro_preco) VALUES (?, ?, ?)";
            stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getDescricao());
            stmt.setFloat(3, obj.getPreco());
            
            stmt.execute();
            stmt.close();
            
        } catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    public List<Produtos> listarProdutos(){
        try{
            List<Produtos> lista = new ArrayList<Produtos>();
            cmdsql = "SELECT * FROM produto";
            stmt = conecta.prepareStatement(cmdsql);
            ResultSet rs = stmt.executeQuery();
                                //executeQuery() => busca informações do banco
            
            while(rs.next()){
                Produtos p = new Produtos();
                p.setCodigo(rs.getInt("pro_codigo"));
                p.setNome(rs.getString("pro_nome"));
                p.setDescricao(rs.getString("pro_descricao"));
                p.setPreco(rs.getFloat("pro_preco"));//Float.parseFloat(rs.getString("pro_preco"));
                
                lista.add(p);
            }
            
            return lista;
            
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void alterarProduto(Produtos obj){
        try{
            cmdsql = "UPDATE produto SET pro_nome=?, pro_descricao=?, pro_preco=? WHERE pro_codigo=?";
            stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getDescricao());
            stmt.setFloat(3, obj.getPreco());
            stmt.setInt(4, obj.getCodigo());
            
            stmt.execute();
            stmt.close();
            
        } catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    public void excluirProduto(Produtos obj){
        try{
            cmdsql = "DELETE FROM produto WHERE pro_codigo=?";
            stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setInt(1, obj.getCodigo());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException erro){
            throw new RuntimeException(erro);
        }
    }
}
