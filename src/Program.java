
public class Program {

    public static void main(String[] args) {
        // 实例化一个产品池
        ProductPool productPool = new ProductPool(15);

        new Producer(productPool).start();

        new Consumer(productPool).start();
    }
}
