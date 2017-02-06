package chapter18;

import java.io.File;

public class DirSize2 {

	public static void main(String[] args) {
		Directory.TreeInfo ti;
		if(args.length==0)
			ti=Directory.walk("txt");
		else
			ti=Directory.walk("txt", args[0]);
		long total=0;
		for(File file:ti)
			total+=file.length();
		System.out.println(ti.files.size()+" files, "+total+" bytes");
	}

}
