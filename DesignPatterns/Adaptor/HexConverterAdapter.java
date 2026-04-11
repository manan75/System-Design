package DesignPatterns.Adaptor;

class HexConverterAdapter implements NumberConverter {
    @Override
    public String convert(int number) {
        return Integer.toHexString(number).toUpperCase(); // Convert to hexadecimal
    }
}