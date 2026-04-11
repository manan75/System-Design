package DesignPatterns.Type1Builder;
//defining a car with some attributes
class BuilderCar {
    private String engine;
    private int wheels;
    private boolean airConditioning;

   
    BuilderCar(Builder1 builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels; 
        this.airConditioning = builder.airConditioning;
    }

    @Override
    public String toString() {
        return "Car{engine='" + engine + "', wheels=" + wheels + ", airConditioning=" + airConditioning + "}";
    }
}
