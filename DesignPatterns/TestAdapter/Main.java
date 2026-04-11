package DesignPatterns.TestAdapter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter which format would you like the export the file in: ");
        System.out.println("1. Word(.docx)");
        System.out.println("2. Pdf(.pdf)");
        choice = scan.nextInt();

        if(choice==1){
            Exporter word = new WordAdapter();
            word.exportFile();
        }
        else{
            Exporter pdf = new PdfAdapter();
            pdf.exportFile();
        }

        scan.close();

    }
}
