package chapter18;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;


public class LineNumber {

	public static void main(String[] args) throws IOException{
		if(args.length!=2){
			System.err.println("Usage: java LineNumber infile outfile");
			return;
		}
		List<String> list=FileIntoList.read(args[0]);
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter(args[1])));
		int line=list.size();
		for(ListIterator<String> it=list.listIterator(list.size()); it.hasPrevious();)
			out.println(line-- + ": "+it.previous());
		out.close();
	}

}
