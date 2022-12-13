/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.etec.padrao;

import com.etec.padrao.Menu;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


/**
 *
 * @author Gilde
 */
public class Conexao{
   
    public Conexao(){
        
    }
    
    Menu menu = new Menu();
    public Connection connect()
    {
         String path = System.getProperty("user.dir");
     
        String url = "jdbc:sqlite:" + path + "\\banco\\" + menu.bancoD;
        
        Connection conn = null;

        try {
            
            conn = DriverManager.getConnection(url);

            DatabaseMetaData meta = conn.getMetaData();

            JOptionPane.showMessageDialog(null, "o nome do driver de conexão é: " + meta.getDriverName());

            if (conn != null) {
                
                JOptionPane.showMessageDialog(null, "Conexão com o banco de dados estabelecida");
                
            }
            
        }
        
        catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        return conn;
        
    }
    
    public void createNewTable(String nomeTabela){
        nomeTabela = menu.tabela;
        
        String path = System.getProperty("user.dir");
        String url = "jdbc:sqlite:" + path + "\\banco\\" + menu.bancoD;
        String sql = "CREATE TABLE IF NOT EXISTS TB_ALUNO(\n"
                    + "     id integer PRIMARY KEY, \n"
                    + "     nome text NOT NULL,\n"
                    + "     peso real\n"
                    + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement()) {
            
            stmt.execute(sql);
            
            JOptionPane.showMessageDialog(null, "Uma nova tabela foi inserida com sucesso!");
            
        }
        
        catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
    }
    
    public void insert(String nomeTabela, String nome, double peso) {
        
        String path = System.getProperty("user.dir");
        String url = "jdbc:sqlite:" + path + "\\banco\\" + menu.bancoD;
        String sql = "INSERT INTO TB_ALUNO (nome, peso) VALUES(?, ?)";
        
        try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setString(1, nome);
            pstmt.setDouble(2, peso);
            
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados inseridos na tabela!");
            
        }
        
        catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
    }
    
    public void selectALL(String nomeTabela){
        nomeTabela = menu.tabela;
        
        String path = System.getProperty("user.dir");
        String url = "jdbc:sqlite:" + path + "\\banco\\" + menu.bancoD;
        String sql = "SELECT id , nome , peso FROM TB_ALUNO";
        
        try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
            
            String lista = "";
            
            while (rs.next()){
                
                lista = lista + rs.getInt("id") + " , " + rs.getString("nome") + " , " + rs.getDouble("peso") + "\n";
                
            }
            
            JOptionPane.showMessageDialog(null, "Dados da Tabela TB_ALUNO \n\n" + lista);
            
        }
        
        catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
    }
    
    public void uptade(int id, String nome, double peso){
        
        String path = System.getProperty("user.dir");
        String nomeBanco = "banco_teste.db";
        String url = "jdbc:sqlite:" + path + "\\banco\\" + nomeBanco;
        String sql = "UPDATE TB_ALUNO SET nome = ? , peso = ? WHERE id = ? ;";
        
        try (Connection conn = DriverManager.getConnection(url);
        PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setString(1, nome);
            pstmt.setDouble(2, peso);
            pstmt.setInt(3, id);
            
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados atualizados na tabela");
            
        }
        
        catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
    }
    
    public void Delete(String nomeTabela, int Id){
            nomeTabela = menu.tabela;
        
            String path = System.getProperty("user.dir");
            String url = "jdbc:sqlite:" + path + "\\banco\\" + menu.bancoD;
            String sql = "DELETE FROM TB_ALUNO WHERE Id = ?;";
            
             
            try(Connection conn = DriverManager.getConnection(url);        
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setInt(1, Id);
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null , "Dados do Id " + Id + " foram excluidos da tabela! ");
            
            }
            
            catch(SQLException e){
                
                JOptionPane.showMessageDialog(null , e.getMessage());
                
            }
            
        }
    
    public void DeleteTable(String nomeTabela){
            nomeTabela = menu.tabela;
        
            String path = System.getProperty("user.dir");
            String url = "jdbc:sqlite:" + path + "\\banco\\" + menu.bancoD;
            String sql = "DROP TABLE TB_ALUNO";
            
            try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()){
                
                stmt.execute(sql);
                
                JOptionPane.showMessageDialog(null, "A tabela " + nomeTabela + " foi removida do banco! ");
                
            }   
            
            catch(SQLException e){
                
                JOptionPane.showMessageDialog(null , e.getMessage());
                
            }
            
        }
    public void DeleteDatabase(String nomeBanco){
            nomeBanco = menu.bancoD;
            
            String path = System.getProperty("user.dir");
            Path Path = Paths.get(path + "\\Banco\\" + nomeBanco);
            
            try {
  
            Files.delete(Path);
            
             JOptionPane.showMessageDialog(null, "O banco de dados " + nomeBanco + " foi deletado com sucesso!");
             
            }
            
            catch (IOException e) {
                
                JOptionPane.showMessageDialog(null , e.getMessage());
                
            }
            
    }

    public void createNewDatabase(String bancoD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
}

