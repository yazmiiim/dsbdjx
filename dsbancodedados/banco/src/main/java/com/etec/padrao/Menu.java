/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.etec.padrao;

/**
 *
 * @author gilde
 */
public class Menu {
    int select = 0;
    
    int id = 0;
    String nome = "";
    double peso = 0;
    
    public String bancoD = "banco_teste.db";
    public String tabela = "TB_ALUNO";
            
    public Menu(){
    
    }
    
    public int getSelect(){
    
        return select;
        
    }
    
    public void setSelect(int select){
    
        this.select = select;
        
    }
    
    public int getId(){
    
        return id;
        
    }
    
    public void setId(int id){
    
        this.id = id;
    
    }
    
    public String getNome(){
    
        return nome; 
        
    }
    
    public void setNome(String nome){
    
        this.nome = nome;
        
    }
    
    public double getPeso(){
    
        return peso;
    
    }
    
    public void setPeso(double peso){
    
        this.peso = peso;
        
    }
    
    public String getBancoD(){
    
        return bancoD;
        
    }
    
    public void setBancoD(String bancoD){
    
        this.bancoD = bancoD;
        
    }
    
    public String getTabela(){
    
        return tabela;
        
    }
    
    public void setTabela(String tabela){
    
        this.tabela = tabela;
        
    }
    
}
