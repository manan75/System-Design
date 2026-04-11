package Factory;
public class Cars {
   public String name;
   public String paint;
   public String carType;   //sedan,suv etc


   public Cars(String name,String carType ,  String paint) {
    this.name = name;
    this.carType = carType;
    this.paint = paint;
   }

}
