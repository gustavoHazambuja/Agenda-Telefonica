package Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import Entites.Person;
import Exception.AddException;
import Exception.DeleteException;
import Exception.SearchException;
import Exception.ShowException;
import Exception.UpdateException;

public class PhoneBook {
    Scanner dados = new Scanner(System.in);

    Person person = new Person();
    
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

        boolean isExist = contacts.values().stream()
            .anyMatch(c -> c.equals(number));

        if(isExist){
            throw new AddException("Número já cadastrado.");
        }    

        contacts.put(name, number);
        System.out.println("\nContato adicionado.");
    }


    public void showContacts(){
        if(contacts.isEmpty()){
            throw new ShowException("Nenhum contato adicionado.");
        }

        contacts.entrySet().stream()
            .forEach(System.out::println);
    }


    public void searchContact(){
        System.out.println("Informe o nome do contato:");
        name = dados.nextLine().toLowerCase();

        List<Map.Entry<String,String>> personFound = contacts.entrySet().stream()
            .filter(c -> c.getKey().toLowerCase().contains(name))
            .collect(Collectors.toList());

            if(personFound.isEmpty()){
                throw new SearchException("Contato não encontrado.");
            }

        personFound.forEach(System.out::println);  
        System.out.println("\nContato encontrado.");  
    }


    public void deleteContact(){
      System.out.println("Informe o nome do contato:");
      name = dados.nextLine().toLowerCase();


      Map.Entry<String,String> personDelete = contacts.entrySet().stream()
        .filter(c -> c.getKey().equalsIgnoreCase(name))
        .findFirst()
        .orElseThrow(() -> new DeleteException("Contato não encontrado."));

            contacts.remove(personDelete.getKey());
            System.out.println("\nContato deletado.");
    }

    public void updateContact(){
        System.out.println("Informe o nome do contato para atualizar o número:");
        name = dados.nextLine().toLowerCase();

        Map.Entry<String,String> personUpdate = contacts.entrySet().stream()
            .filter(c -> c.getKey().equalsIgnoreCase(name))
            .findFirst()
            .orElseThrow(() -> new UpdateException("Contato não encontrado"));

            System.out.println("Informe o novo número");
            String newNumber = dados.nextLine();

            boolean numberExists = contacts.entrySet().stream()
                .anyMatch(c -> c.getValue().equalsIgnoreCase(newNumber));

            if(numberExists){
                throw new UpdateException("Número já existente");
            }    

            contacts.put(name, newNumber);
            System.out.println("Número atualizado.");
    }
}
