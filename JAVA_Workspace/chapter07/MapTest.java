package chapter07;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import chapter05.Employee;

public class MapTest {
	public static void main(String[] args) {
		/**
		 *  Map : Key를 이용하여 value에 접근(저장, 추출, 삭제)
		 */
		
		HashMap<Integer, Object> hm = new HashMap<Integer, Object>();
		
		hm.put(1, "Hello");
		hm.put(2, new Employee("1", "ssafy", 20));
		System.out.println(hm);
		System.out.println(hm.get(1));
		
		// keySet() : map에 저장된 key 값만 추출
		Set<Integer> keys = hm.keySet();
		for (Integer key : keys) {
			System.out.println(key);
		}
		
		// values() : map에 저장된 value만 추출
		Collection<Object> values = hm.values();
		for (Object value : values) {
			System.out.println(value);
		}
	}
}
