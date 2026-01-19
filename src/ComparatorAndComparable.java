import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/***
 *                      Comparator and Comparable Interfaces in Java
 *                      ---------------------------------------------
 * Comparator and Comparable are two interfaces in Java that are used for sorting objects.
 * Comparable interface is used to define the natural ordering of objects,
 * while Comparator interface is used to define custom ordering of objects.
 * Comparable interface has a method compareTo() which is used to compare the CURRENT object with another object.
 * Comparable interface is implemented by the class whose objects need to be compared.
 * Comparable interface allows only one sorting criteria to be defined.
 * Comparable interface modifies the original class to implement the comparison logic.
 * Comparable interface is not a functional interface, which means it cannot be implemented using lambda expressions.
 *
 *
 * Comparator interface has a method compare() which is used to compare two different objects.
 * Comparator interface can be implemented using a separate class, an anonymous class, or a lambda expression.
 * Comparator interface is more flexible than Comparable interface as it allows multiple sorting criteria to be defined.
 * Comparator interface can be used to sort objects in different ways without modifying the original class.
 * Comparator interface is a functional interface, which means it can be implemented using lambda expressions.
 * Faster and more efficient sorting can be achieved using Comparator interface with custom logic.
 *
 * ***/


class Student implements Comparable<Student> {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.age, other.age); // Compare by age
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + '}';
    }
}

public class ComparatorAndComparable {


    public static void main (String[] args){
        // Comparable interface is used to define the natural ordering of objects
        // It has a method compareTo() which is used to compare the current object with another object
        // The class that implements Comparable must override the compareTo() method

        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 22));
        students.add(new Student("Bob", 20));
        students.add(new Student("Charlie", 23));

        System.out.println("Before Sorting: " + students);
        Collections.sort(students); // Sort using natural ordering (by age)
        System.out.println("After Sorting by Age: " + students);


        List<Integer> numbers = new ArrayList<>();
        numbers.add(34);
        numbers.add(12);
        numbers.add(15);
        numbers.add(78);
        numbers.add(23);
        System.out.println("Before Sorting: " + numbers);
        Collections.sort(numbers);
        System.out.println("After Sorting: " + numbers);
        Comparator<Student> nameComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.name.compareTo(s2.name); // Compare by name
            }
        };
        students.sort(nameComparator); // Sort using custom comparator (by name)
        System.out.println("After Sorting by Name: " + students);
        Comparator<Student> ageComparator=(Student o1, Student o2) ->{
                if (o1.age < o2.age) return -1;
                else if (o1.age > o2.age) return 1;
                else return 0;
            };


        Collections.sort(students, ageComparator);
        System.out.println("After Sorting by Age using Collections.sort(): " + students);
        Collections.sort(students, nameComparator);
        System.out.println("After Sorting by Name using Collections.sort(): " + students);
    }
}
