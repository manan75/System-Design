
public class LaptopMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        LaptopShop shop1 = new LaptopShop();
        shop1.setShopName("TechWorld");
        shop1.loadData();
    
        LaptopShop shop2 = shop1.clone();
        shop2.setShopName("Manan sales");

       
        System.out.println(shop1);
        System.out.println(shop2);

       
        shop1.getLaptops().remove(2);
        shop1.getLaptops().remove(1);

         shop2 = shop1.clone();

        System.out.println("After modifying Shop1:");
        System.out.println(shop1);
        System.out.println(shop2);
    }
}
