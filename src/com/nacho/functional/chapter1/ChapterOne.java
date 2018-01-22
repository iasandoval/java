package com.nacho.functional.chapter1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class ChapterOne {

	public static void main(String args[]) {

		// Lambda expressions
		Integer arr[] = { 1, 2, 3, 4, 5 };
		List<Integer> list = Arrays.asList(arr);

		list.forEach(x -> System.out.println(x));

		// Function composition
		Function<Integer, Integer> absThenNegate = ((Function<Integer, Integer>) Math::negateExact).compose(Math::abs);

		System.out.println(absThenNegate.apply(-25));
		System.out.println(absThenNegate.apply(25));

		// Fluent interfaces

		// Without method chaining
		LocalDate today = LocalDate.now();
		LocalDate futureDate = today.plusYears(2);
		futureDate = futureDate.minusMonths(1);
		futureDate = futureDate.plusDays(3);

		System.out.println(today);
		System.out.println(futureDate);
		
		// With method chaining
		LocalDate chainFutureDate = LocalDate.now()
				.plusYears(2)
				.minusMonths(1)
				.plusDays(3);

		System.out.println(chainFutureDate);

		// Non-strict evaluation
		Random random = new Random();
		random.ints()	// Returns an IntStream instance
			  .limit(5)
			  .sorted()
			  .forEach(x -> System.out.println(x));
		
		// Recursion
		// Without recursion
		int result = 1;
		for (int i = 5; i >= 1; i--) {
			result = result * i;
		}

		System.out.println(result);

		// With Recursion
		System.out.println(factorial(5));
		
		//Parallelism/Concurrent
		
		
	}
	
	// Recursive Factorial
	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
	
	
	

}
