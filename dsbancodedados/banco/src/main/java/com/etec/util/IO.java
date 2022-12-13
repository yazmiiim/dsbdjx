/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.etec.util;

/**
 *
 * @author gilde
 */
import javax.swing.JOptionPane;


public class IO {
   private String texto;
   
   
   public IO(){
   
   }
   
   public String getTexto(){
   return texto;
   }  
    
   public void setTexto(String texto){
   this.texto = texto;
   }   
   public void exibirTexto(){
   JOptionPane.showMessageDialog(null, texto);
   }
  

   public String digitarTexto(String mensagem){
   this.setTexto(JOptionPane.showInputDialog(mensagem));
   
   return this.getTexto();
   }
   
}