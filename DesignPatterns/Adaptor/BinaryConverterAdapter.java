package DesignPatterns.Adaptor;


class BinaryConverterAdapter implements NumberConverter {
    @Override
    public String convert(int number) {
        return Integer.toBinaryString(number); // Convert to binary
    }
}


