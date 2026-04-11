package DesignPatterns.TestAdapter;

public class WordAdapter implements Exporter {
    WordExporter word = new WordExporter();

    public void exportFile(){
        word.exportWord();
    }
}
