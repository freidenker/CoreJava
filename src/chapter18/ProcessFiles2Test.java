package chapter18;

import java.io.File;
import java.io.IOException;

class ProcessFiles2{
	private ProcessFiles.Strategy strategy;
	private String regex;
	public ProcessFiles2(ProcessFiles.Strategy strategy,String regex){
		this.strategy=strategy;
		this.regex=regex;
	}
	public void start(String[] args){
		try{
			if(args.length==0)
				processDirectoryTree(new File("."));
			else
				for(String arg : args) {
					File fileArg = new File(arg);
					if(fileArg.isDirectory())
						processDirectoryTree(fileArg);
					else
						if(arg.matches(regex))
							strategy.process(fileArg.getCanonicalFile());
				}
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	public void processDirectoryTree(File root) throws IOException {
	for(File file : Directory.walk(root.getAbsolutePath(), regex))
		strategy.process(file.getCanonicalFile());
	}
}
public class ProcessFiles2Test {

	public static void main(String[] args) {
		new ProcessFiles2(new ProcessFiles.Strategy() {
			public void process(File file) {
				System.out.println(file);
			}
		}, ".*\\.java").start(args);
	}

}
