/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ces_java;

import JDBC.ConnectionFactory;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonas
 */
public class CES_JAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            JOptionPane.showMessageDialog(null, "Testando a conexão");
            Connection con =  new ConnectionFactory().conecta();
            JOptionPane.showMessageDialog(null,"Conexão realizada com sucesso");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro" + e);
        }
    }
    
}
