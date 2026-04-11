public class BillBuilder {
    //this creates an object of a shopping bill and adds items to it and returns that object
    public ShoppingBill makeBill(){
        ShoppingBill bill = new ShoppingBill();
        bill.addItem(new Shirt());
        bill.addItem(new Ball());
        bill.addItem(new Soap());
        return bill;
    }
}
