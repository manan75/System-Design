package DesignPatterns.Type1Builder;

public class BuilderPatternType1 {
    public static void main(String[] args) {
        BuilderCar car1 = new Builder1("V6").build();
        BuilderCar car2 = new Builder1("V8").setWheels(6).build();
        BuilderCar car3 = new Builder1("V12").setWheels(4).setAirConditioning(true).build();

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
    }
}
