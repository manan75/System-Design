
import java.util.ArrayList;
import java.util.List;


public class LaptopShop implements Cloneable {
    private String shopName;
    private List<Laptop> laptops = new ArrayList<>();

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }
//loads the datawhen shop is created
    public void loadData() {
        for (int i = 1; i <= 3; i++) {
            Laptop laptop = new Laptop();
            laptop.setId(i);
            laptop.setName("Laptop" + i);
            laptop.setPrice(50000 + (i * 2000)); // Setting price 
            laptops.add(laptop);
        }
    }
//when clone is called a new shop is created but it has references of original laptops only
    @Override
    protected LaptopShop clone() throws CloneNotSupportedException {
        LaptopShop shop = new LaptopShop();
        for (Laptop l : this.getLaptops()) {
            shop.getLaptops().add(l); // shallow copy 
        }
        return shop;
    }

    @Override
    public String toString() {
        return "LaptopShop [shopName=" + shopName + ", laptops=" + laptops + "]";
    }
}
