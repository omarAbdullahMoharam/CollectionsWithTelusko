import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingCollections {
    public static void main(String[] args) {
        List<Integer>list=new ArrayList<>();
        list.add(34);
        list.add(12);
        list.add(15);
        list.add(78);
        list.add(23);
        System.out.println("Before Sorting: " + list);
        list.sort(Integer::compareTo);
//        you can use Collections.sort(list) as well
        Collections.sort(list);
        System.out.println("After Sorting: " + list);
//        what if we need to sort in descending order?
        list.sort(Collections.reverseOrder());
        System.out.println("After Sorting in Descending Order: " + list);
//        what if we need to sort by the last digit of each number?
//        list.sort((a, b) -> {
//            int lastDigitA = a % 10;
//            int lastDigitB = b % 10;
//            return Integer.compare(lastDigitA, lastDigitB);
//        });
//        System.out.println("After Sorting by Last Digit: " + list);
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
//                -- this is the first way to do it --
//                int lastDigitA = a % 10;
//                int lastDigitB = b % 10;
//                return Integer.compare(lastDigitA, lastDigitB);

//                -- this is the second way to do it --
                if (a%10 < b%10) {
                    return -1;
                } else if (a%10 > b%10) {
                    return 1;
                } else {
                    return 0;
                }
            }

        };
//        how to use the comparator to sort the list
        list.sort(com);
        System.out.println("After Sorting by Last Digit: " + list);
//        another way to use comparator is to use Collections.sort() method
        Collections.sort(list, com);
        System.out.println("After Sorting by Last Digit using Collections.sort(): " + list);

    }
}
