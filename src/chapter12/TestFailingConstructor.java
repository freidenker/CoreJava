package chapter12;


class ConstructionException extends Exception {}

class WithDispose {
	private final int id;
	WithDispose(int id) { this.id = id; }
	void dispose() {
		System.out.println("WithDispose.dispose(): " + id);
	}
}

class FailingConstructor2 {
	private final WithDispose wd1, wd2;
	FailingConstructor2(boolean fail)throws ConstructionException{
		wd1 = new WithDispose(1);
		try{
			if(fail) throw new ConstructionException();
		}catch(ConstructionException e){
			wd1.dispose();
			throw e;
		}
		wd2 = new WithDispose(2);
	}
	void dispose() {
		wd2.dispose();
		wd1.dispose();
	}
}

class FailingConstructor {
  FailingConstructor(boolean fail)throws ConstructionException {
    if(fail) throw new ConstructionException();
  }
}

public class TestFailingConstructor {

	public static void main(String args[]) {
		for(boolean b = false; ; b = !b){
			try{
				System.out.println("Constructing...");
			//	FailingConstructor fc = new FailingConstructor(b);
				FailingConstructor2 fc = new FailingConstructor2(b);
				try{
					System.out.println("Processing...");
				}finally{
					System.out.println("Cleanup...");
					fc.dispose();
				}
			}catch(ConstructionException e){
				System.out.println("Construction has failed: " + e);
				break;
			}
		}
	}
}
