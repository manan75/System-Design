package Factory;

public class Ferrari extends Cars implements CarFeatures {
    public String model;
        public int modelNum;

        public Ferrari(String name, String carType,  String paint, String model, int modelNum) {
            super(name, carType, paint);
            this.model = model;
            this.modelNum = modelNum;
         }

         public String getFrame(){
            return "Stainless-steel";
         }
         public String getWheels(){
            return "Alloy";
         }
         public int getSeats(){
            return 2;
         }

         public String getGearShift(){
            return "Automatic";
         }
         public String getEngine(){
            return "V12";
         }
         public String getBrakes(){
            return "Disc";
         }
         public String getFuelType(){
            return "Gasoline";
         }

         public void displayDetails(){
            System.out.println("1.Car name: "+ name);
            System.out.println("2.Car type: "+ carType);
            System.out.println("3.Paint color: "+ paint);
            System.out.println("4.Model: "+ model);
            System.out.println("5.Model num: "+ modelNum);
            System.out.println("6.Frame material: "+ getFrame());
            System.out.println("7.Wheel type: "+ getWheels());
            System.out.println("8.Number of seats: "+ getSeats());
            System.out.println("9.Gear type: "+ getGearShift());
            System.out.println("10.Engine type: "+ getEngine());
            System.out.println("11.Brake types: "+ getBrakes());
            System.out.println("12.Fuel type: "+ getFuelType());
         }
}
