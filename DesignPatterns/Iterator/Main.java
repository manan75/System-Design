package DesignPatterns.Iterator;

public class Main {
    public static void main(String[] args) {
        NameRepository names = new NameRepository();
        Iterator it = names.createIterator();

        while (it.hasNext()) {
            System.out.println("Name: " + it.next());
        }
    }
}
