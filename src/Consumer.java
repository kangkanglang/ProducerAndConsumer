
public class Consumer extends Thread{
    private ProductPool productPool;

    public Consumer(ProductPool productPool){
        this.productPool = productPool;
    }

    @Override
    public void run() {
        while (true){
            Product product = productPool.pop();
            System.out.println("消费了：" + product.getName());
        }
    }
}
