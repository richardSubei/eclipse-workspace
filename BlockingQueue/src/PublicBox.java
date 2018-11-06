import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PublicBox {

	private final int MAX_SIZE = 100;
	
	private volatile BlockingQueue<Object> queue = new LinkedBlockingQueue<>(100);
	
	//alter
	public void increase(int i) {
		while(queue.size() == MAX_SIZE) {
			System.out.println("仓库已满，不必生产");
		}
		
		try {
			synchronized (queue) {
				queue.put(new Object());	//放入数据，如果queue没有空间则调用此方法的线程被阻塞，直到queue有空间	offer不阻塞线程
				System.out.println("生产者【" + i + "】生产一个产品" + "----目前库存：" + queue.size() + "个");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void decrease(int j) {
		while(queue.size() == 0) {
			System.out.println("库存不足，停止消费");
		}
		try {
			synchronized (queue) {
				queue.take();	//取走首位，若为空则阻塞
				System.out.println("消费者【" + j + "】消费一个产品" + "----目前库存：" + queue.size() + "个");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
