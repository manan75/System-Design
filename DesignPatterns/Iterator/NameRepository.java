package DesignPatterns.Iterator;

public class NameRepository implements Aggregate {
    private String[] names = {"Alice", "Bob", "Charlie", "Diana"};

    public String[] getNames() {
        return names;
    }

    @Override
    public Iterator createIterator() {
        return new NameIterator(this);
    }
}
