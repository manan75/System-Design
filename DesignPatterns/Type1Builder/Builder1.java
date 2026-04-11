package DesignPatterns.Type1Builder;

public class Builder1 {
    String engine;
    int wheels = 4;
    boolean airConditioning = false; 

    public Builder1(String engine) {  
        this.engine = engine;
    }

    public Builder1 setWheels(int wheels) {
        this.wheels = wheels;
        return this;
    }

    public Builder1 setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
        return this;
    }

    public BuilderCar build() {
        return new BuilderCar(this);
    }
}
