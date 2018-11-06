
public class PublicBox {

	private int apple = 0;
	
	public int getApple() {
		return apple;
	}


	public void setApple(int apple) {
		this.apple = apple;
	}


	public synchronized void increase(int i) {
		synchronized (this) {
			while(apple == 10) {
				try {
					System.out.println("生产者【" + i + "】" + "仓库已满，停止生产");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			apple++;
			System.out.println("生产者【" + i + "】生产一个产品" + "----目前库存：" + apple + "个");
			notifyAll();
			try {
				Thread.sleep((long) (Math.random()*10));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	
	public synchronized void decrease(int j) {
		synchronized (this) {
			while(apple == 0) {
				try {
					System.out.println("消费者【" + j + "】" + "仓库不足，停止消费");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			apple--;
			System.out.println("消费者【" + j + "】消费一个产品" + "----目前库存：" + apple + "个");
			notifyAll();
			try {
				Thread.sleep((long) (Math.random()*10));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
}

