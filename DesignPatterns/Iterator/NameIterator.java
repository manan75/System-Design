package DesignPatterns.Iterator;

public class NameIterator implements Iterator {
    private int index = 0;
    private final NameRepository nameRepository;

    public NameIterator(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    @Override
    public boolean hasNext() {
        return index < nameRepository.getNames().length;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return nameRepository.getNames()[index++];
        }
        return null;
    }
}
