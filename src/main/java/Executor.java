import algorithms.search.BinarySearch;
import algorithms.sort.QuickSort;
import structures.HashMap;
import structures.LinkedList;

import java.util.Arrays;

public class Executor {
  public static void main(String... args) {
    //binarySearch();
    //linkedList();
    //quicksort();
    hashmap();
  }

  public static void hashmap() {
    HashMap<String, String> myMap = new HashMap<>();
    for (int i = 0; i < 250; i++ ) {
      myMap.put(String.valueOf(i), String.valueOf(i));
    }

    System.out.println(myMap.get("50"));
    System.out.println(myMap.toString());
  }

  public static void quicksort() {
    int[] sorted = QuickSort.sort(new int[] {300,37, 350, 1,2, 150, 35, 5, 37, 400, 6, 3, 22, 4, 44, 20, 16, 14});
    System.out.println(Arrays.toString(sorted));
  }

  public static void binarySearch() {
    int size = 100000000;
    int[] items = new int[size];
    for (int i = 0; i < size; i++) {
      items[i] = i + 1;
    }

    System.out.println("--------------------------");
    Integer index = BinarySearch.search(items, 150);
    System.out.printf("The item is in index %s", index);
    System.out.println("\n--------------------------");
  }

  public static void linkedList() {
    LinkedList<String> stringList = new LinkedList<>();
    System.out.println(stringList.toString());
    stringList.add("item");
    stringList.add("item 2");
    stringList.add("item 3");
    System.out.println(stringList.toString());
    stringList.forEachReverse(System.out::println);
    stringList.remove();
    stringList.remove();
    stringList.remove();
    stringList.remove();
    System.out.println(stringList.toString());

  }
}
