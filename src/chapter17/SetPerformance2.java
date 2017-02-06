package chapter17;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import chapter15.Generator;
import chapter16.CountingGenerator;

public class SetPerformance2 {
	static List<Test<Set<String>>> tests = new ArrayList<Test<Set<String>>>();
	static{
		tests.add(new Test<Set<String>>("add") {
			
			@Override
			int test(Set<String> container, TestParam tp) {
				// TODO Auto-generated method stub
				Generator<String> gen;
				int loops=tp.loops;
				int size=tp.size;
				for(int i=0;i<loops;i++){
					container.clear();
					gen=new CountingGenerator.String();
					for(int j=0;j<size;j++)
						container.add(gen.next());
				}
				return loops*size;
			}
		});
		tests.add(new Test<Set<String>>("iterate") {
			
			@Override
			int test(Set<String> container, TestParam tp) {
				// TODO Auto-generated method stub
				int loops=tp.loops*10;
				for(int i=0;i<loops;i++){
					Iterator<String> it=container.iterator();
					while(it.hasNext())
						it.next();
				}
				return loops*container.size();
			}
		});
		tests.add(new Test<Set<String>>("contains") {
			
			@Override
			int test(Set<String> container, TestParam tp) {
				// TODO Auto-generated method stub
				Generator<String> gen=new CountingGenerator.String(5);
				int loops=tp.loops;
				int span=tp.size*2;
				for(int i=0;i<loops;i++)
					for(int j=0;j<span;j++)
						container.contains(gen.next());
				return loops*span;
				
			}
		});
	}
	public static void main(String[] args) {
		if(args.length>0)
			Tester.defaultParams = TestParam.array(args);
		Tester.fieldWidth=10;
		Tester.run(new TreeSet<String>(), tests);
		Tester.run(new HashSet<String>(), tests);
		Tester.run(new LinkedHashSet<String>(), tests);
	}
}
