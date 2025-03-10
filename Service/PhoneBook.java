package Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Exceptionn.ShowException;

public class PhoneBook {
    Scanner dados = new Scanner(System.in);
    
    private Map<String, String> contacts;

    String name;
    String number;

    public PhoneBook(){
        this.contacts = new HashMap<String, String>();
    }

    public void addContact(){
        System.out.println("Informe o nome do contato:");
        name = dados.nextLine().toLowerCase();

        System.out.println("Informe seu número");
        number = dados.nextLine();

        contacts.put(name, number);
        System.out.println("Contato adicionado.");
    }

    public void showContacts(){
        if(contacts.isEmpty()){
            throw new ShowException("Nenhum contato adicionado.");
        }

        contacts.entrySet().stream()
            .forEach(System.out::println);
    }
}
