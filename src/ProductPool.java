
import java.util.ArrayList;
import java.util.List;

public class ProductPool {
    //产品池
    private List<Product> list;
    //最多产品数量
    private int maxSize = 0;

    public ProductPool(int maxSize){
        this.list = new ArrayList<>();
        this.maxSize = maxSize;
    }

    /**
     * 将生产者生产的产品 放入产品池
     */
    public synchronized void push(Product product){
        // 判断是否还需要生产产品
        if(this.list.size() == this.maxSize){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.list.add(product);
        this.notifyAll();

    }

    /**
     * 消费者从商品池中取商品
     */
    public synchronized Product pop(){
        //判断是否还有商品
        if(this.list.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Product product = this.list.remove(0);
        this.notifyAll();
        return product;
    }
}
