package chapter18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

class OSExecute2{
	public static List<String> command(String command){
		boolean err=false;
		List<String> output=new LinkedList<String>();
		try{
			Process process=new ProcessBuilder(command.split(" ")).start();
			BufferedReader results=new BufferedReader(new InputStreamReader(process.getInputStream()));
			String s;
			while((s=results.readLine())!=null)
				output.add(s);
			
			BufferedReader errors=new BufferedReader(new InputStreamReader(process.getErrorStream()));
			while((s=errors.readLine())!=null){
				System.err.println(s);
				err=true;
			}
		}catch(IOException e){
			if(!command.startsWith("CMD /C"))
				return command("CMD /C "+command);
			throw new RuntimeException(e);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		if(err)
			throw new OSExecuteException("Errors executing "+command);
		return output;
	}
}
public class OSExecuteDemo2 {
	public static void main(String[] args) {
		List<String> results=OSExecute2.command("echo HAllo ");
		for(String s:results)
			System.out.println(s);
	}

}
