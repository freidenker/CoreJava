package chapter17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import chapter16.RandomGenerator;

public class SortPerformance {

	static List<Test<List<Integer>>> tests = new ArrayList<Test<List<Integer>>>();
	static {
		tests.add(new Test<List<Integer>>("sort") {
			int test(List<Integer> list, TestParam tp) {
				for(int i = 0; i < tp.loops; i++) {
					list.clear();
					list.addAll(CollectionData.list(
							new RandomGenerator.Integer(), tp.size));
					Collections.sort(list);
				}
				return tp.loops;
			}
		});
	}
	
	static class ListTester extends Tester<List<Integer>> {
		public ListTester(List<Integer> container,List<Test<List<Integer>>> tests) {
		super(container, tests);
		}
		// Fill to the appropriate size before each test:
		@Override protected List<Integer> initialize(int size){
			container.clear();
			container.addAll(CollectionData.list(
					new RandomGenerator.Integer(), size));
			return container;
		}
		// Convenience method:
		public static void run(List<Integer> list,List<Test<List<Integer>>> tests) {
		new ListTester(list, tests).timedTest();
		}
	}
	
	public static void main(String[] args) {
		if(args.length > 0)
		Tester.defaultParams = TestParam.array(args);
		ListTester.run(new ArrayList<Integer>(), tests);
		ListTester.run(new LinkedList<Integer>(), tests);
	}
}
