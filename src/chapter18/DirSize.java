package chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirSize {

public static void main(String[] args) {
	File path = new File(".");
	String[] list;
	if(args.length == 0)
		list = path.list();
	else
		list = path.list(new FilenameFilter() {
			private Pattern pattern = Pattern.compile(args[0]);
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
	});
	Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
	long total=0;
	long fs;
	for(String dirItem:list){
		fs=new File(path,dirItem).length();
		System.out.println(dirItem+", "+fs+" bytes");
		total+=fs;
	}
	System.out.println("============================");
	System.out.println(list.length+" files, "+total+" bytes");
}

}
