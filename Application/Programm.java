package Application;

import java.util.Scanner;

import Exception.AddException;
import Exception.DeleteException;
import Exception.SearchException;
import Exception.ShowException;
import Exception.UpdateException;
import Service.PhoneBook;

public class Programm {
    public static void main(String[] args) {
        Scanner dados = new Scanner(System.in);

        PhoneBook phoneBook = new PhoneBook();

        int opcao;

        do{

            System.out.println("****************************");
            System.out.println("******** MENU DE OPÇÕES *****");
            System.out.println("****************************");
    
            System.out.println("(1) Adicionar contato");
            System.out.println("(2) Listar contatos");
            System.out.println("(3) Pesquisar contato");
            System.out.println("(4) Atualizar número");
            System.out.println("(5) Remover contato");
            System.out.println("(6) Sair");
            opcao = dados.nextInt();
            dados.nextLine();

            switch (opcao) {
                case 1:
                    try{
                        phoneBook.addContact();
                    }catch(AddException e){
                        System.out.println("Erro. " + e.getMessage());
                    }
                    break;
                 
                case 2:
                    try{
                        phoneBook.showContacts();
                    }catch(ShowException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try{
                        phoneBook.searchContact();
                    }catch(SearchException e){
                        System.out.println(e.getMessage());
                    }
                
                    break;

                case 4:
                    try{
                        phoneBook.updateContact();
                    }catch(UpdateException e){
                        System.out.println("Erro. " + e.getMessage());
                    }

                    break;

                case 5:
                    try{
                        phoneBook.deleteContact();
                    }catch(DeleteException e){
                        System.out.println("Erro. " + e.getMessage());
                    }
                    break;
                    
                case 6:
                    System.out.println("Saindo...");
                    break;
                    
                default:
                    System.out.println("Opção inválida.");    
                    break;
            }

           

        }while(opcao != 6);

        dados.close();
    }
}
