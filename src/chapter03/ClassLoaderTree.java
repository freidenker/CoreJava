package chapter03;

import java.util.Arrays;
import java.util.List;


public class ClassLoaderTree {
	 List<Integer> list=null ;
		
	public void test(){
		list=Arrays.asList(1,2,3,4,5);
		System.out.println(list);
	}
    public static void main(String[] args) { 
/*        ClassLoader loader = ClassLoaderTree.class.getClassLoader(); 
        while (loader != null) { 
            System.out.println(loader.toString()); 
            loader = loader.getParent(); 
        } */
        
        ClassLoaderTree tes=new ClassLoaderTree();
        tes.test();
    }
}
