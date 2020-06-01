
public class Producer extends Thread{

    private ProductPool productPool;

    public Producer(ProductPool productPool){
        this.productPool = productPool;
    }

    @Override
    public void run() {
        while (true){
            String name = (int) (Math.random() * 100) + "号产品";
            Product product = new Product(name);
            System.out.println("生产了：" + name);
            productPool.push(product);
        }
    }
}
