package chapter18;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.BitSet;

public class PrintCharBuffer {
	static BitSet isPrintable=new BitSet(127);
	static String encoding=System.getProperty("file.encoding");
	static{
		for(int i=32;i<127;i++){
			isPrintable.set(i);
		}
	}
	
	public static void setPrintableLimit(CharBuffer cb){
		cb.rewind();
		while(isPrintable.get(cb.get()));
		cb.limit(cb.position()-1);
		cb.rewind();
	}
	
	public static void main(String[] args) {
		System.out.println("Default Encoding is: "+encoding);
		CharBuffer buffer=ByteBuffer.allocate(16).asCharBuffer();
		buffer.put("ABCDE"+(char)0x01+"FG");
		buffer.rewind();
		System.out.println(buffer);
		setPrintableLimit(buffer);
		System.out.println(buffer);
	}

}
