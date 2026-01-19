import java.util.*;

public class Main {
    public static void main(String[] args) {
//        taking a reference of Collection interface to hold an ArrayList object
//        <Generics> annotations are used to specify the type of elements that the collection can hold
//        and ensure type safety at compile time to avoid runtime exceptions.

//        Collection itself is an interface and cannot be instantiated directly, and it's not iterable by indexing like arrays or lists.
        Collection<Integer> nums = new ArrayList<>();
        nums.add(6);
        nums.add(5);
//        nums.add("9"); // This line will cause a compile-time error
        System.out.println(nums);

//        to use iteration, we can use for-each loop without indexing by using iterable feature of Collection interface inherited from Iterable interface
        for (Integer num : nums) {
            System.out.println(num);
        }

//        to be able to use indexing, we can use List interface
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
//        System.out.println("index of a orange in List:" + fruits.indexOf("Orange")); // 2
//        System.out.println(fruits.get(1)+"\n"); // Banana
//        for indexing, we can use traditional for loop
//        for (int i = 0; i < fruits.size(); i++) {
//            System.out.println(fruits.get(i));
//        }
//      Set Interface extends Collection Interface and it's implemented by HashSet, LinkedHashSet, TreeSet classes
//      Map Interface is not a sub-interface of Collection Interface and it's implemented by HashMap, LinkedHashMap, TreeMap classes
//      Both Set and Map interfaces are part of Java  Collections Framework along with
//      List Interface which also extends Collection Interface:
        Collection <Integer> numbers = new HashSet<>();
        numbers.add(6);
        numbers.add(5);
        numbers.add(20);
        numbers.add(10);
        numbers.add(4);
        numbers.add(6); // duplicate element, will be ignored in HashSet
        System.out.println("HashSet elements: " + numbers); // Output may vary in order (Not guaranteed order)
//        to enable ordered elements, we can use TreeSet or LinkedHashSet instead of HashSet
        Collection<Integer> elements = new TreeSet<>();
        elements.add(6);
        elements.add(5);
        elements.add(6);// duplicate element, will be ignored in TreeSet
        elements.add(20);
        elements.add(10);
        elements.add(4);

        System.out.println("TreeSet elements (sorted): " + elements); // Output will be sorted order

        Iterator<Integer> iterateValues = elements.iterator();
        Iterator<Integer> printFirstElement = elements.iterator();

        System.out.println("Iterating through TreeSet elements:");
        System.out.println("to print first element: " + printFirstElement.next()); // 4
        System.out.println("to print second element: " + printFirstElement.next()); // 5
        System.out.println("to print all elements using iterator in while loop:");
        while(iterateValues.hasNext()) {
            System.out.println(iterateValues.next());
        }

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Apple");
        map.put(2,"Banana");
        map.put(3,"Orange");
        map.put(1,"Grapes"); // duplicate key, will update the value for key 1
        System.out.println("HashMap elements: " + map); // Output: {1=Grapes, 2=Banana, 3=Orange}
//        to access values in Map, we can use key
        System.out.println("Value for key 2: " + map.get(2)); // Output: Banana
//        to get the keys of the map
        Set<Integer> keys = map.keySet();
        System.out.println("Keys in the map: " + keys); // Output: [1, 2, 3]
//        to get the values of the map
        Collection<String> values = map.values();
        System.out.println("Values in the map: " + values); // Output: [Grapes, Banana, Orange]
//        map is an unordered collection ( HashMap ) of key-value pairs
//        map is not a sub-interface of Collection interface
//        map does not support indexing
//        map allows duplicate values but not duplicate keys
//        map is a combination of Set for Keys and Collection interfaces like list or linkedList etc. for Values
//        ==== Sorted Map like TreeMap ====
        Map<String, Integer> students = new TreeMap<>();
        students.put("John", 12);
        students.put("Alice", 11);
        students.put("Bob", 13);
        System.out.println("TreeMap elements (sorted by keys): " + students); // Output: {Alice=11, Bob=13, John=12}
        System.out.println("Value for key 'Bob': " + students.get("Bob")); // Output: 13


    }
}