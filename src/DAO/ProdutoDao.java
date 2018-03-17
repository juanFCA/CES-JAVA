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
 * @author alunoces
 */
public class ProdutoDao {
    private Connection conecta;

    public ProdutoDao() {
        this.conecta = new ConnectionFactory().conecta();
    }
   
    public void cadastrarProduto(Produtos obj){
        try {
            String cmdSql = "INSERT INTO produto (pro_nome, pro_descricao, pro_preco) VALUES (?,?,?)";
            PreparedStatement stmt = conecta.prepareStatement(cmdSql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getDescricao());
            stmt.setFloat(3, obj.getPreco());
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException erro) {
            throw new RuntimeException(erro); 
        }
    }
    
    public List<Produtos> listarProdutos() {
        try {
            List<Produtos> lista = new ArrayList<Produtos>();
            String Sql="SELECT * FROM produto";
            PreparedStatement stmt = conecta.prepareStatement(Sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Produtos p = new Produtos();
                p.setCodigo(rs.getInt("pro_codigo"));
                p.setNome(rs.getString("pro_nome"));
                p.setDescricao(rs.getString("pro_descricao"));
                p.setPreco(rs.getFloat("pro_preco"));
                
                lista.add(p);
            }
     
            return lista;
            
        } catch(SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
    
    public void atualizarProduto(Produtos obj) {
        
    }
    
    public void removerProduto(Produtos obj) {
        
    }
}

