package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReadText {

	
	public ReadText() {
		// TODO Auto-generated constructor stub
	}
	
	public static String getFilePath() {
		
//		String currentClassFilePath = className.getClassLoader().getResource("").getFile();
		
//		File currentClassFle = new File(currentClassFilePath);
//		String absolutePath = currentClassFle.getAbsolutePath();
		
		String absolutePath = System.getProperty("user.dir");
		
//		String filePath = (System.getProperty("user.dir")+ "\\ProjectStatus.txt").replaceAll("%20", " ");
		
		String filePath =  (absolutePath.substring(0, absolutePath.lastIndexOf("\\") + 1)).
				replaceAll("%20", " ");
		
		return filePath;
	}

	public static void readFromFile(String filePath) {

		List<String> result = new ArrayList<String>(); 
		String line = "";
		BufferedReader in;
		BufferedWriter writer = null;
		try {
	//		in = new BufferedReader(new FileReader(new File(filePath)));
			in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));
			while((line = in.readLine()) != null){
				result.add(line.trim());
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<String> sames=new HashSet<String>();
		int count=0;
		for(int i=1;i<result.size();i++){
			
			for(int j=0;j<i;j++){
				if(result.get(i).equals(result.get(j))){
					System.out.println("i: "+i+": "+result.get(i)+"     ** j:"+j+" "+result.get(j));
					sames.add(result.get(i));
					count++;
				}
			}
		}
		System.out.println("\nhow many same round: "+count);
		System.out.println("\n ***********************\n ");
		
		for(String same : sames){
			System.out.println(same);
		}
		
		System.out.println("\nhowe many same: "+sames.size());
		System.out.println("\n############################ ");
		System.out.println("\n***************************** ");
		HashSet<String> nosame=new HashSet<String>(result);
		result.clear();
		result.addAll(nosame);
		System.out.println("all not same number: "+result.size());
		
		//cut result to many txt files by one per 100
		int hundert=result.size()/100;
		List<List<String>> sublists=new ArrayList<List<String>>();	

		for(int j=0;j<hundert;j++){
			sublists.add(result.subList(j*100, (j+1)*100));
		}
			
		if(result.size()%100 !=0){
			sublists.add(result.subList(hundert*100, result.size()));
		}
		
		for(List<String> sublist:sublists){
			System.out.println(sublists.indexOf(sublist)+": one sublist######################");
			System.out.println(sublist);	
		}
			
		System.out.println("\nhow many sublists: "+sublists.size());
		System.out.println("\n***********##########################################**************\n");
		List<File> newtxts=new ArrayList<File>();
		for(int i=0;i<sublists.size();i++){
			newtxts.add(new File("E:\\starteamProjects\\GetProjectsList\\Need\\IT1\\new"+i+".txt"));
		}
		int sum=0;
		for(int i=0;i<sublists.size();i++){
			sum=sum+sublists.get(i).size();
			try{
				BufferedWriter wr;
				wr = new BufferedWriter(new FileWriter(newtxts.get(i)));
				for(String oneline : sublists.get(i)){
					if(sublists.get(i).get(sublists.get(i).size()-1)!=oneline){				
						oneline=oneline+System.getProperty("line.separator");	
					}				
					wr.write(oneline);				
				}
		
				wr.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		System.out.println("how many of all sum: "+sum);
		
		
		//write new file for new result
/*		try{
		    File newtxt = new File("E:\\starteamProjects\\withDelete\\deactived-projects\\tsg1_new.txt");
		    System.out.println(newtxt.getCanonicalPath());
		    writer = new BufferedWriter(new FileWriter(newtxt));
		    for(String oneline : result){
		    	oneline=oneline+System.getProperty("line.separator");
		    	writer.write(oneline);
		    }
		    writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}*/
		
		
		
/*		for(int i=0;i<result.size();i++){
			System.out.println(i+": "+result.get(i));
		}*/
/*		for(String each : result){
			System.out.println(each.trim());
		}*/
//		return result;
	}
	
	public static void main(String[] args){
		readFromFile("E:\\starteamProjects\\GetProjectsList\\Need\\it1.txt");
	}

}
