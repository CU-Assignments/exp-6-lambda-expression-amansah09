import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Aman", 85),
            new Student("Ranjan", 72),
            new Student("Sneha", 90),
            new Student("Sandeep", 65),
            new Student("Vishal", 78)
        );

        List<String> topStudents = students.stream()
                .filter(s -> s.marks > 75) // Filter students above 75%
                .sorted((s1, s2) -> Double.compare(s2.marks, s1.marks))
                .map(s -> s.name)
                .collect(Collectors.toList());

        System.out.println("Students scoring above 75% (sorted by marks):");
        topStudents.forEach(System.out::println);
    }
}
