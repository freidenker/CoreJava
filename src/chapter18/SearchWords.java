package chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import chapter11.TextFile;

public class SearchWords {

	public static void main(String[] args) {
		File path=new File(".");
		String[] list;
		if(args.length==0)
			list=path.list();
		else
			list=path.list(new FilenameFilter() {
				private String ext=args[0].toLowerCase();
				@Override
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					if(name.toLowerCase().endsWith(ext)){
						if(args.length==1)
							return true;
						Set<String> words=new HashSet<String>(new TextFile(new File(dir, name).getAbsolutePath(),"\\W+"));
						for(int i=1;i<args.length;i++)
							if(words.contains(args[i]))
								return true;
					}
					return false;
				}
			});
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for(String dir:list)
			System.out.println(dir);
	}

}
