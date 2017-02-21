package chapter18;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class InBufferDemo {
	private static final int BSIZE=1024;
	public static void main(String[] args){
		ByteBuffer bb=ByteBuffer.allocate(BSIZE);
		IntBuffer ib=bb.asIntBuffer();
		ib.put(new int[]{11,42,47,99,143,811,1016});
		ib.flip();
		while(ib.hasRemaining()){
			int i=ib.get();
			System.out.println(i);
		}
	}
}
