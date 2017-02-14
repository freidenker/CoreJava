package chapter18;

import java.io.IOException;
import java.io.RandomAccessFile;

public class UsingAllRandomAccessFileAllType {
	static String file = "rtest.dat";
	static void display() throws IOException{
		RandomAccessFile rf = new RandomAccessFile(file, "r");
		System.out.println(rf.readBoolean());
		System.out.println(rf.readByte());
		System.out.println(rf.readUnsignedByte());
		System.out.println(rf.readChar());
		System.out.println(rf.readFloat());
		System.out.println(rf.readLong());
		System.out.println(rf.readInt());
		System.out.println(rf.readShort());
		System.out.println(rf.readUnsignedShort());
		System.out.println(rf.readDouble());
		System.out.println(rf.readUTF());
		rf.close();
	}
	public static void main(String[] args) throws IOException {
			RandomAccessFile rf = new RandomAccessFile(file, "rw");
			rf.writeBoolean(true);
			rf.writeByte(100);
			rf.writeByte(255);
			rf.writeChar('A');
			rf.writeFloat(1.41413f);
			rf.writeLong(1000000000L);
			rf.writeInt(100000);
			rf.writeShort(30000);
			rf.writeShort(65535);
			rf.writeDouble(3.14159);
			rf.writeUTF("The end of the file");
			rf.close();
			display();
			rf = new RandomAccessFile(file, "rw");
			rf.seek(3); // 1 boolean + 2 bytes
			rf.writeChar('B');
			rf.close();
			display();
			}
}
