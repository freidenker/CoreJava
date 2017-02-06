package test;

//import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

public class CuttList {

public static void main(String[] args){
	
//	BufferedReader in;
	
	
	String mylove="I Celebrate myself, and sing myself,And what I assume you shall assume,For every atom belonging to me as good belongs to you.I loafe and invite my soul,I lean and loafe at my ease observing a spear of summer grass.My tongue, every atom of my blood, form’d from this soil, this air,Born here of parents born here from parents the same, and their parents the same,I, now thirty-seven years old in perfect health begin,Hoping to cease not till death.Creeds and schools in abeyance,Retiring back a while sufficed at what they are, but never forgotten,I harbor for good or bad, I permit to speak at every hazard,Nature without check with original energy.Houses and rooms are full of perfumes.... the shelves are crowded with perfumes,I breathe the fragrance myself, and know it and like it,The distillation would intoxicate me also, but I shall not let it.The atmosphere is not a perfume.... it has no taste of the distillation.... it is odorless,It is for my mouth forever.... I am in love with it,I will go to the bank by the wood and become undisguised and naked,I am mad for it to be in contact with me.The smoke of my own breath,Echoes, ripples, and buzzed whispers.... loveroot, silkthread, crotch and vine,My	respiration and inspiration.... the beating of my heart.... the passing of blood and air through my lungs,The sniff of green leaves and dry leaves, and of the shore and darkcolored sea-rocks, and of hay in the barn,The sound of the belched words of my voice.... words loosed to the eddies of the wind,A few light kisses.... a few embraces.... reaching around of arms,The play of shine and shade on the trees as the supple boughs wag,The delight alone or in the rush of the streets, or along the fields and hill-sides,The feeling of health.... the full-noon trill.... the song of me rising from bed and meeting the sun.Have you reckoned a thousand acres much? Have you reckoned the earth much?Have you practiced so long to learn to read?Have you felt so proud to get at the meaning of poems?Stop	this day and night with me and you shall possess the origin of all poems,You shall possess the good of the earth and sun.... there are millions of suns left,You shall no longer take things at second or third hand.... nor look through the eyes of the dead, nor feed on the spectres in books,You shall not look through my eyes either, nor take things from me,You shall listen to all sides and filter them from yourself.A child said What is the grass? fetching it to me with full hands;How could I answer the child? I do not know what it is any more than he.I guess it must be the flag of my disposition, out of hopeful green stuff woven.Or I guess if is the handkerchief of the Lord,A scented gift and remembrancer designedly dropt,Bearing the owner’s name someway in the corners, that we may see and remark, and say Whose?Or I guess the grass is itself a child, the produced babe of the vegetation.Or I guess it is a uniform hieroglyphic,And it means, Sprouting alike in broad zones and narrow zones,Growing among black folks as among white,Kanuck, Tuckahoe, Congressman, Cuff, I give them the same, I receive then the same.And now it seems to me the beautiful uncut hair of graves.Tenderly will I use you curling grass,It may be you transpire from the breasts of young men,It may be you are from old people, or from offspring taken,It may be if I had known them I would have loved them, soon out of their mother’s laps,And here you are the mothers’ laps.This grass is very dark to be from the white heads of old mothers,Darker than the colorless beards of old men,Dark to come from under the faint red roofs of mouths.O I perceive after all so many uttering tongues,And I perceive they do not come from the roofs of mouths for nothing.I wish I could translate the hints about the dead young men and women,And the hints about old men and mothers, and the offspring taken soon out of their laps.What do you think has become of the young and old men?And what do you think has become of the women and children?They are alive and well somewhere,The smallest sprout shows there is really no death,And if ever there was it led forward life, and does not wait at the end to arrest it,And ceas’d the moment life appear’d.All goes onward and outward, nothing collapses,And to die is different from what any one supposed, and luckier.The spotted hawk swoops by and accuses me, he complains of my gab and my loitering.I too am not a bit tamed, I too am untranslatable,I sound my barbaric yawp over the roofs of the world.The last scud of day holds back for me, flings my likeness after the rest and true as any on the shadow’d wildsIt coaxes me to the vapor and the dusk.I depart as air, I shake my white locks at the runaway sun,I effuse my flesh in eddies, and drift it in lacy jags.I bequeath myself to the dirt to grow from the grass I love,If you want me again look for me under your boot-soles.You will hardly know who I am or what I mean,But I shall be good health to you nevertheless,And filter and fibre your blood.Failing to fetch me at first keep encouraged,Missing me one place search another,I stop somewhere waiting for you";
	String love=mylove.replaceAll("[^a-zA-Z\\s+]", "");
	String[] stArr=love.split("\\s+");
	List<String> result=new ArrayList<String>();
	for(int i=0;i<stArr.length;i++){
	//	stArr[i]=stArr[i]+System.getProperty("line.separator");
		result.add(stArr[i]);
	}
/*	for(String one:result){
		System.out.println(one);
	}*/
	System.out.println(result.size());
	
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
		newtxts.add(new File("C:\\Users\\chlin\\Desktop\\test\\new"+i+".txt"));
	}
//	File[] newtxts=new File[sublists.size()];
	
//	List<String>[] slsa= (List<String>[]) sublists.toArray();
	//ArrayList<String>[] slsa=new ArrayList[sublists.size()];
	//slsa=sublists.toArray(slsa);
	int sum=0;
	for(List<String> sub:sublists){
		sum=sum+sub.size();
	}
	
	int sum2=0;
	
	for(int i=0;i<sublists.size();i++){
		sum2=sum2+sublists.get(i).size();
		try{
			
			BufferedWriter writer;
			writer = new BufferedWriter(new FileWriter(newtxts.get(i)));
			for(String oneline : sublists.get(i)){
			//	if(sublists.get(i).indexOf(oneline)==(sublists.get(i).size()-1)){
				
				if(sublists.get(i).get(sublists.get(i).size()-1)!=oneline){
				//	System.out.println(oneline);
					oneline=oneline+System.getProperty("line.separator");	
				}
			//	if(sublists.get(i).indexOf(oneline)<sublists.get(i).size()-2){
			//	oneline=oneline+System.getProperty("line.separator");	
/*				if(sublists.get(i).indexOf(oneline)==sublists.get(i).size()-1){
					String newone=oneline.trim();
				}*/
				
				writer.write(oneline);
				
			}
		//	System.out.println(sublists.get(i).size());
			writer.close();
			
		}catch(IOException e){
			e.printStackTrace();
		  }
		
	}
	
	System.out.println("how many of all sum: "+sum+".  sum2: "+sum2);
	
/*	for(List<String> sublist:sublists){
	  try{
		  BufferedWriter writer;
		  for(File newtxt:newtxts){
			writer = new BufferedWriter(new FileWriter(newtxt));		
				for(String oneline : sublist){
					oneline=oneline+System.getProperty("line.separator");
					writer.write(oneline);
				}
				writer.close();
				System.out.println(newtxt);
		  }	
		
	  }catch(IOException e){
		e.printStackTrace();
	  }
	}*/
}

}
