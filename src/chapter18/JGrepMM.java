package chapter18;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrepMM {

	public static void main(String[] args) throws Exception{
		if(args.length<2){
			System.out.println("Usage: java JGrepMM file regex");
			System.exit(0);
		}
		Pattern p=Pattern.compile(args[1]);
		FileChannel fc=new FileInputStream(args[0]).getChannel();
		ByteBuffer buffer=fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
		CharBuffer cb=Charset.forName(System.getProperty("file.encoding")).decode(buffer);
		String[] fileAsArray=cb.toString().split("\n");
		int index=0;
		Matcher m=p.matcher("");
		for(String line:fileAsArray){
			m.reset(line);
			while(m.find()){
				System.out.println( index++ + ": "+m.group()+": "+m.start());
			}
		}
		fc.close();
	}

}
