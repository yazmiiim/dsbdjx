/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.etec.padrao;
import com.etec.util.IO;
/**

 *
 * @author gilde
 */
public class Principal {
    public static void main(String[] args){
        
        Conexao conexao = new Conexao();
        IO io = new IO();
        Menu menu = new Menu();
        
        int select = 0;
        
        while (select == 0){
        
            menu.setSelect(Integer.parseInt(io.digitarTexto("Digite o número da função que deseja realizar: \n"
                     + "0 Exit \n"
                    + "1 New Database \n"
                    + "2 New Table \n"
                    + "3 Inset \n"
                    + "4 Update \n"
                    + "5 Select All \n"
                    + "6 Delete \n"
                    + "7 Delete Table \n"
                    + "8 Delete Database \n"
                    + "9 Testar Conexão")));
            
            switch(menu.getSelect()){
                
                case 0 -> {
                    
                    io.setTexto("Tchau");
                    io.exibirTexto();
                    
                    System.exit(0);
                    
                }
                
                case 1 -> {
                
                    menu.setBancoD(io.digitarTexto("Digite o nome do Banco de Dados: \n (De ok para usar banco_teste.db)"));
                    conexao.createNewDatabase(menu.getBancoD());
                    
                    break;
                    
                }
                
                case 2 -> {
                
                    menu.setTabela(io.digitarTexto("Digite o nome da Tabela: \n (De ok para usar TB_ALUNOS)"));
                    conexao.createNewTable(menu.getTabela());
                    
                    break;
                
                }
                
                case 3 -> {
                
                    menu.setNome(io.digitarTexto("Digite o nome do aluno: \n"));
                    menu.setPeso(Double.parseDouble(io.digitarTexto("Digite o peso do aluno: \n")));
                    conexao.insert(menu.getTabela(), menu.getNome(), menu.getPeso());
                
                    break;
                    
                }
                
                case 4 -> {
                
                    menu.setId(Integer.parseInt(io.digitarTexto("Digite o ID do aluno: \n")));
                    menu.setNome(io.digitarTexto("Digite o nome do usuário: \n"));
                    menu.setPeso(Double.parseDouble(io.digitarTexto("Digite o peso do aluno: \n")));
                    conexao.uptade(menu.getId(), menu.getNome(), menu.getPeso());
                    
                    break;
                    
                }
                
                case 5 -> {
                
                    conexao.selectALL(menu.getTabela());
                
                    break;
                
                }
                
                case 6 -> {
                
                    menu.setId(Integer.parseInt(io.digitarTexto("Digite o ID do aluno: \n")));
                    conexao.Delete(menu.getTabela(), menu.getId());
                    
                    break;
                
                }
                
                case 7 -> {
                
                    conexao.DeleteTable(menu.getTabela());
                    
                    break;
                
                }
                
                case 8 -> {
                
                    conexao.DeleteDatabase(menu.getBancoD());
                
                    break;
                    
                }
                
                case 9 -> {
                
                    conexao.connect();
                    
                }
               
            }
                
        }
        
    }
    
}
