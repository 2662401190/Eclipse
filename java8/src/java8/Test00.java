package java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import java8.java8.Employee;

public class Test00 {
		public static void main(String[] args) {
			
			// 求数组中每个数值的平方根
			
			Integer i[]= {1,4,7,96,2,3};
			
		Optional t=	Arrays.stream(i).map((y) -> y.intValue()).collect(Collectors.maxBy(Integer::compare));
		System.out.println(t);
		Optional<Employee> e=Optional.ofNullable(new Employee());
		
//			Arrays.stream(i).map((y) -> y*y).forEach(System.out::println);
//			
//			Optional<Integer> t=Arrays.stream(i).reduce(Integer::sum);
//			System.out.println(t);
		
			
		}
}
