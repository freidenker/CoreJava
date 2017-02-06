package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NeedItems {

	public NeedItems() {
		// TODO Auto-generated constructor stub
	}
	
	static List<String> getNeed(String stayfile,String originfile,String needfile){
		List<String> staylist=new ArrayList<String>();
		List<String> originlist=new ArrayList<String>();
		List<String> needlist=new ArrayList<String>();
		
		String line1 = "";
		String line2 = "";
		BufferedReader in;
		BufferedReader in2;
		BufferedWriter writer = null;
		
		try{
			in = new BufferedReader(new InputStreamReader(new FileInputStream(stayfile),"UTF-8"));
			while((line1 = in.readLine()) != null){
				staylist.add(line1.trim());
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try{
			in2 = new BufferedReader(new InputStreamReader(new FileInputStream(originfile),"UTF-8"));
			while((line2 = in2.readLine()) != null){
				originlist.add(line2.trim());
			}
			in2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int st=0;
		if(originlist != null){
			for(String each:originlist){
				if(!staylist.contains(each)){
					needlist.add(each);
				}else{
					st++;
					System.out.println("maybe stay: "+each);
				}
			}
		}
		System.out.println("\nhow many counld be stay: "+st+", but should stay: "+staylist.size()+"\n");
		if(st != staylist.size()){
			System.out.println("there are some items in staylist not be included origin list!\n ");
		}
/*		for(String need:needlist){
			System.out.println("the need to be removed: "+need);
		}*/
		
		try{
			 File newtxt = new File(needfile);
			 System.out.println(newtxt.getCanonicalPath());
			 writer = new BufferedWriter(new FileWriter(newtxt));
			 for(String oneline : needlist){
				if(needlist.indexOf(oneline) != needlist.size()-1){
			    oneline=oneline+System.getProperty("line.separator");
				}
			    writer.write(oneline);
			 }
			 writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return needlist;
	}
	
	public static void main(String[] args){
		System.out.println("started: ");
		System.out.println("\ntest one: ***************************\n");
		getNeed("E:\\starteamProjects\\GetProjectsList\\W-test\\stay.txt",
				"E:\\starteamProjects\\GetProjectsList\\W-test\\all.txt",
				"E:\\starteamProjects\\GetProjectsList\\W-test\\need.txt");
		
		System.out.println("\nit1: ***************************\n");
		getNeed("E:\\starteamProjects\\GetProjectsList\\Stay\\it1.txt",
				"E:\\starteamProjects\\GetProjectsList\\Alls\\it1-all.txt",
				"E:\\starteamProjects\\GetProjectsList\\Need\\it1.txt");
		
		System.out.println("\nit2: ***************************\n");
		getNeed("E:\\starteamProjects\\GetProjectsList\\Stay\\it2.txt",
				"E:\\starteamProjects\\GetProjectsList\\Alls\\it2-all.txt",
				"E:\\starteamProjects\\GetProjectsList\\Need\\it2.txt");
		
		System.out.println("\ntsg1: ***************************\n");
		getNeed("E:\\starteamProjects\\GetProjectsList\\Stay\\tsg1.txt",
				"E:\\starteamProjects\\GetProjectsList\\Alls\\tsg1-all.txt",
				"E:\\starteamProjects\\GetProjectsList\\Need\\tsg1.txt");
		
		System.out.println("\ntsg3: ***************************\n");
		getNeed("E:\\starteamProjects\\GetProjectsList\\Stay\\tsg3.txt",
				"E:\\starteamProjects\\GetProjectsList\\Alls\\tsg3-all.txt",
				"E:\\starteamProjects\\GetProjectsList\\Need\\tsg3.txt");
		
		System.out.println("\nscr1: ***************************\n");
		getNeed("E:\\starteamProjects\\GetProjectsList\\Stay\\scr1.txt",
				"E:\\starteamProjects\\GetProjectsList\\Alls\\scr1-all.txt",
				"E:\\starteamProjects\\GetProjectsList\\Need\\scr1.txt");
	}

}
