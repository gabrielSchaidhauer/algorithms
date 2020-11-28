import algorithms.search.BinarySearch;
import structures.LinkedList;

public class Executor {
  public static void main(String... args) {
    //binarySearch();
    linkedList();
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
