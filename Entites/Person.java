package Entites;

public class Person{

    private String name;
    private String number;

    public Person(){}

    public Person(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString(){
        return String.format("\nNome: %s\n" + "Telefone: %s\n",name, number);
    }
}