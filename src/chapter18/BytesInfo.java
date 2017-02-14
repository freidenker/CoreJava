package chapter18;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BytesInfo {
	public static void main(String[] args) throws IOException{
		Map<Byte,Integer> bytesStat=new HashMap<Byte,Integer>();
		for(Byte bt : BinaryFile.read("D:\\Dev\\JavaWorkSpace\\CoreJava\\bin\\chapter18\\BytesInfo.class")) {
			Integer freq = bytesStat.get(bt);
			bytesStat.put(bt, freq == null ? 1 : freq + 1);
		}
		List<Byte> keys =new ArrayList<Byte>(bytesStat.keySet());
		Collections.sort(keys);
		for(Byte key : keys)
			System.out.println(key + " => " + bytesStat.get(key));

	}
}
