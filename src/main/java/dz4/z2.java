package dz4;

public class z2 {
    public static void main(String[] args) {
        Object[][] info = {{peaple[0],items[0],1}};
        int capacity = 0;
        int i = 0;
        while (capacity != orders.length - 1 || i != info.length){
            try {
                orders[capacity] = buy((Buyer) info[i][0],(Product) info[i][2],(int)info[i][2]);
                capacity++;
            } catch (ProductException e){
                e.printStackTrace();
            }catch (OrderException e){
                orders[capacity++] = buy((Buyer) info[i][0],(Product) info[i][2],1);
            }catch (BuyerException e){
                throw new RuntimeException();
            }finally {
                System.out.println("Заказ сделан емкостью на: " + capacity);
            }
            ++i;
        }
    }


    private static boolean isInArray(Object[]arr, Object o){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(o)) {return true;}
        }
        return false;
    }
    public static Order buy(Buyer who, Product what, int howMuch){
        if(!isInArray(peaple, who)){
            throw new BuyerException("Кто покупатель: " + who);
        }
        if (!isInArray(items, what)) {
            throw new ProductException("Что за продукт: " + what);
        }
        if(howMuch<0 || howMuch>100){
            throw new OrderException("Количество: " +howMuch);
        }
        return new Order(who,what,howMuch);
    }



    private final static Buyer[] peaple = {
            new Buyer("David Marmonov", 20, "+11111111111"),
            new Buyer("Ivan Chpokin", 30, "+2222222222222")};
    private final static Product[] items = {
            new Product("Car1", 100),
            new Product("Car2", 200),
            new Product("Car3", 200),
            new Product("Car4", 200),
            new Product("Car5", 200)};
    private static Order[] orders = new Order[5];


    public static class BuyerException extends RuntimeException {
        public BuyerException(String message) {
            super(message);
        }
    }

    public static class ProductException extends RuntimeException {
        public ProductException(String message) {
            super(message);
        }
    }

    public static class OrderException extends RuntimeException {
        public OrderException(String message) {
            super(message);
        }
    }
}



class Buyer {
    String nameSurename;
    int age;
    String phoneNumber;
    public Buyer(String nameSurename, int age, String phoneNumber){
        this.nameSurename = nameSurename;
        this.age = age;
        this.phoneNumber = phoneNumber;



    }
    @Override
    public String toString(){
        return "Покупатель{ФИО='" + nameSurename +'\'' + "возвраст = " + age + "Телефон = " + phoneNumber +"'}" ;
    }

}
class Product{
    String name;
    int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;

    }
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
class Order{
    Buyer a;
    Product b;
    int quantity;

    public Order(Buyer a, Product b, int quantity) {
        this.a = a;
        this.b = b;
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Order{" +
                "a=" + a +
                ", b=" + b +
                ", quantity=" + quantity +
                '}';
    }
}