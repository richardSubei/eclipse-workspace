
public class Test {

	public static void main(String[] args) {
		PublicBox box = new PublicBox();		
		
		for(int i=1; i<6; i++) {
			new Thread(new Producer(box,i)).start();;
		}
		
		for(int i=1; i<4; i++) {
			new Thread(new Consumer(box,i)).start();
		}
		
	}
}
