import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class EmployeeFinal {
	public static List<Student> getEmployees() {
		Student emp1 = new Student(1, "Hari Krishna", "Gurram", 26,
				"Bangalore", 40000);
		Student emp2 = new Student(2, "Joel", "Chelli", 27, "Hyderabad",
				50000);
		Student emp3 = new Student(3, "Shanmukh", "Kummary", 28, "Chennai",
				35000);
		Student emp4 = new Student(4, "Harika", "Raghuram", 27, "Chennai",
				76000);
		Student emp5 = new Student(5, "Sudheer", "Ganji", 27, "Bangalore",
				90000);
		Student emp6 = new Student(6, "Rama Krishna", "Gurram", 27,
				"Bangalore", 56700);
		Student emp7 = new Student(7, "PTR", "PTR", 27, "Hyderabad", 123456);
		Student emp8 = new Student(8, "Siva krishna", "Ponnam", 28,
				"Hyderabad", 98765);
		Student emp9 = new Student(9, "Raju", "Antony", 40, "Trivendram",
				198765);
		
		Student emp10 = new Student(10, "Brijesh", "Krishnan", 34,
				"Trivendram", 100000);
		Student emp11 = new Student(9, "Raju", "Antony", 40, "Trivendram",
				198765);
		
		Student emp12 = new Student(10, "Brijesh", "Krishnan", 34,
				"Trivendram", 100000);
		
		List<Student> students = new ArrayList<>();
		
		students.add(emp1);
		students.add(emp2);
		students.add(emp3);
		students.add(emp4);
		students.add(emp5);
		students.add(emp6);
		students.add(emp7);
		students.add(emp8);
		students.add(emp9);
		students.add(emp10);
		students.add(emp11);
		students.add(emp12);
		
		return students;
	}

	public static void main(String[] args) {

		List<Student> students = getEmployees();
		List<Student> temp;
		// Get all employees staying at Chennai
		temp = students.stream().filter((emp) -> emp.getCity().equals("Chennai")).collect(Collectors.toList());
		System.out.println(temp + "\n");

		// Get all employees whose salary > 100000
		temp = students.stream().filter((emp) -> emp.getStudentStifund() > 100000).collect(Collectors.toList());
		System.out.println(temp + "\n");

		// Get all employees whose salary > 100000
		temp = students.stream().filter((emp) -> emp.getStudentStifund() > 100000).distinct().collect(Collectors.toList());
		System.out.println(temp + "\n");

		// Get first 3 employees whose salary is > 50000
		temp = students.stream().filter((emp) -> emp.getStudentStifund() > 50000).distinct().limit(3)
				.collect(Collectors.toList());
		System.out.println(temp + "\n");

		// Sort employees by salary, whose salary is > 80000
		temp = students.stream().filter((emp) -> emp.getStudentStifund() > 80000).distinct()
				.sorted(Comparator.comparing(Student::getStudentStifund)).collect(Collectors.toList());
		System.out.println(temp + "\n");

		/*
		 * * Sort employees by salary, whose salary is > 80000, and skip first 3
		 * employees.
		 */
		temp = students.stream().filter((emp) -> emp.getStudentStifund() > 80000).distinct()
				.sorted(Comparator.comparing(Student::getStudentStifund)).skip(3).collect(Collectors.toList());
		System.out.println(temp + "\n");

		// Get all firstNames from all employees.
		List<String> firstNames = students.stream().map(Student::getFirstName).collect(Collectors.toList());
		System.out.println(firstNames + "\n");

		// Get id, Student from all employees.
		Map<Integer, Student> map = students.stream().distinct()
				.collect(Collectors.toMap(Student::getId, employee -> employee));
		System.out.println(map + "\n");

		// Get id, firstName from all employees.
		Map<Integer, String> map1 = students.stream().distinct()
				.collect(Collectors.toMap(Student::getId, Student::getFirstName));
		System.out.println(map1 + "\n");

		// Get length of all employee first names
		List<Integer> lengths = students.stream().map(Student::getFirstName).map(String::length)
				.collect(Collectors.toList());
		System.out.println(lengths + "\n");

		System.out.println("111111111111111111111111111111111");

		// NUmeric Streams --- IntStream,LongStream, DoubleStream
		// Get sum of all employee salaries
		double totalSalary = students.stream().mapToDouble(Student::getStudentStifund).sum();

		// Minimum salary
		OptionalDouble minSalary = students.stream().mapToDouble(Student::getStudentStifund).min();

		// Maximum salary
		OptionalDouble maxSalary = students.stream().mapToDouble(Student::getStudentStifund).max();

		// Average salary
		OptionalDouble avgSalary = students.stream().mapToDouble(Student::getStudentStifund).average();

		System.out.println("Total Salary : " + totalSalary);
		System.out.println("Minimum Salary : " + minSalary.getAsDouble());
		System.out.println("Maximum Salary : " + maxSalary.getAsDouble());
		System.out.println("Average Salary : " + avgSalary.getAsDouble());
		System.out.println("222222222222222222222222222222222222222222222222222");

		// Streams: Searching and finding ::anyMatch,allMatch,noneMatch,findAny,findFirst
		// Check whether any employee exist in stream, where salary > 100000
		boolean result = students.stream().anyMatch((emp) -> emp.getStudentStifund() > 100000);
		System.out.println(result);

		// Check whether any employee exist in stream, where salary < 10000
		result = students.stream().anyMatch((emp) -> emp.getStudentStifund() < 10000);
		System.out.println(result);

		// Check whether all employees are getting salary > 25000
		result = students.stream().allMatch((emp) -> emp.getStudentStifund() > 25000);
		System.out.println(result);

		/*
		 * Check whether all employees are getting salary > 25000 using
		 * noneMatch function
		 */
		result = students.stream().noneMatch((emp) -> emp.getStudentStifund() <= 25000);
		System.out.println(result);

		// Find any employee whose salary > 100000
		Optional<Student> oneEmp = students.stream().filter((emp) -> emp.getStudentStifund() > 100000).findAny();
		System.out.println(oneEmp.get());

		/*
		 * Find first employee (In ascending order of salary), whose salary >
		 * 100000.
		 */
		oneEmp = students.stream().filter((emp) -> emp.getStudentStifund() > 100000)
				.sorted(Comparator.comparing(Student::getStudentStifund)).findFirst();
		System.out.println(oneEmp.get());

		System.out.println("3333333333333333333333333333333333333333333333333333333333333");
		// Java8: Streams: Reduce operation
		List<Integer> numbers = Arrays.asList(2, 5, 18, 3, 14, 28, 91, 43, 26);

		/* Perform sum of numbers */
		int sum = numbers.stream().reduce(0, (a, b) -> a + b);

		// Perform multiplication of numbers
		int mul = numbers.stream().reduce(1, (a, b) -> a * b);

		// Find maximum number
		int max = numbers.stream().reduce(Integer.MIN_VALUE, (a, b) -> ((a > b) ? a : b));

		// Find minimum number
		int min = numbers.stream().reduce(Integer.MAX_VALUE, (a, b) -> ((a > b) ? b : a));

		System.out.println("Sum of numbers : " + sum);
		System.out.println("Multiplication of numbers : " + mul);
		System.out.println("Maximum of numbers : " + max);
		System.out.println("Minimum of numbers : " + min);
		System.out.println("4444444444444444444444444444444444444444444444444444444444444");
		// Summarizing/Reducing elements according to certain criteria,Grouping
		// elements, Partitioning elements.
		/* Count number of employees who are stying in Chennai */
		long noOfEmployees = students.stream().filter((emp) -> emp.getCity().equals("Chennai"))
				.collect(Collectors.counting());
		System.out.println("Number Of employees in Chennai" + noOfEmployees + "\n");

		/* Find maximum salaried employee */
		Optional<Student> emp = students.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Student::getStudentStifund)));
		System.out.println("Maximum salaried employee" + emp + "\n");

		/* Find maximum salaried employee */
		emp = students.stream().collect(Collectors.minBy(Comparator.comparing(Student::getStudentStifund)));
		System.out.println("Minimum salaried employee" + emp + "\n");

		/* Find total salary of all employees */
		double totalSalary1 = students.stream().collect(Collectors.summingDouble(Student::getStudentStifund));
		System.out.println("Totala salry is " + totalSalary1 + "\n");

		/* Find average salary of all employees */
		double avgSalary1 = students.stream().collect(Collectors.averagingDouble(Student::getStudentStifund));
		System.out.println("Average saary of employees is" + avgSalary1 + "\n");

		/*
		 * Find number of employees, sum of their salaries, maximum, minimum and
		 * average of salaries in single statement.
		 */
		DoubleSummaryStatistics statistics = students.stream()
				.collect(Collectors.summarizingDouble(Student::getStudentStifund));
		System.out.println(statistics + "\n");

		/* Find all employee firstNames separated by ,. */
		String firstNames1 = students.stream().map(Student::getFirstName).collect(Collectors.joining(","));
		System.out.println(firstNames1 + "\n");

		/* Group employees by city */
		Map<String, List<Student>> groupByCity = students.stream().collect(Collectors.groupingBy(Student::getCity));
		System.out.println(groupByCity + "\n");

		/* Group employees by age */
		Map<Integer, List<Student>> groupByAge = students.stream().collect(Collectors.groupingBy(Student::getAge));
		System.out.println(groupByAge + "\n");

		/* Group employees by city and age */
		Map<String, Map<Integer, List<Student>>> groupByCityAndAge = students.stream()
				.collect(Collectors.groupingBy(Student::getCity, Collectors.groupingBy(Student::getAge)));
		System.out.println(groupByCityAndAge + "\n");

		/*
		 * Get all employees who are staying in Chennai and who are not staying
		 * in Chennai
		 */
		Map<Boolean, List<Student>> partitionEmp = (Map) students.stream()
				.collect(Collectors.partitioningBy((emp1) -> emp1.getCity().equals("Chennai")));
		List<Student> chennaiEmp = partitionEmp.get(true);
		List<Student> nonChennaiEmp = partitionEmp.get(false);

		System.out.println(chennaiEmp + "\n");
		System.out.println(nonChennaiEmp);
		System.out.println("55555555555555555555555555555555555555555");
	}
}
