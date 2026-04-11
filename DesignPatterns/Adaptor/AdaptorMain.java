package DesignPatterns.Adaptor;

import java.util.Scanner;

public class AdaptorMain{


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int decimalNumber =0; 
        System.out.println("Enter the number you want to covnert: ");
        decimalNumber = scan.nextInt();

        NumberConverter binaryConverter = new BinaryConverterAdapter();
        System.out.println("Binary: " + binaryConverter.convert(decimalNumber));

        NumberConverter hexConverter = new HexConverterAdapter();
        System.out.println("Hexadecimal: " + hexConverter.convert(decimalNumber));
    }
}   