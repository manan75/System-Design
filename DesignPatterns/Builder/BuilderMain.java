public class BuilderMain{
    public static void main(String[] args) {
        BillBuilder bill1 = new BillBuilder(); //initialising a billbuulder
        ShoppingBill myBill = bill1.makeBill(); //calling makeBill which returns a bill of type object(of shopping bill)

        myBill.display();
        float totalAmt = myBill.getBill();
        System.out.println("Total bill: "+ totalAmt);

    }
}