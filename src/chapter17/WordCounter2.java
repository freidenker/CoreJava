package chapter17;

import java.util.List;

import chapter11.TextFile;

public class WordCounter2 {

	public static void main(String[] args) {
		List<String> words=new TextFile("C:\\Users\\chlin\\workspace\\CoreJava\\src\\chapter17\\MapsDemo.java", "\\W+");
		SlowMap<String, Integer> map=new SlowMap<String,Integer>();
		for(String word:words){
			Integer freq=map.get(word);
			map.put(word, freq==null?1:freq+1);
		}
		System.out.println(map);
	}

}
