
public class Producer implements Runnable{

	private PublicBox box;
	private int i;
	
	public Producer(PublicBox box, int i) {
		this.box = box;
		this.i = i;
	}
	
	
	@Override
	public void run() {
		box.increase(i);
	}

}
