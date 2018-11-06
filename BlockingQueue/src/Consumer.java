
public class Consumer implements Runnable{

	private PublicBox box;
	private int j;
	
	public Consumer(PublicBox box,int j) {
		this.box = box;
		this.j = j;
	}
	
	
	@Override
	public  void run() {
		box.decrease(j);
	}
}
