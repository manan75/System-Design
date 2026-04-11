package DesignPatterns.TestAdapter;

public class PdfAdapter implements Exporter{
    PdfExporter pdf = new PdfExporter();
    public void exportFile(){
        pdf.exportPdf();
    }
}
