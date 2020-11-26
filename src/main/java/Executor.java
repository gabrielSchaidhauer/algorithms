import search.BinarySearch;

public class Executor {
  public static void main(String... args) {
    binarySearch();
  }

  public static void binarySearch() {
    int size = 10000000;
    int[] items = new int[size];
    for (int i = 0; i < size; i++) {
      items[i] = i + 1;
    }

    System.out.println("--------------------------");
    Integer index = BinarySearch.search(items, 150);
    System.out.printf("The item is in index %s", index);
    System.out.println("\n--------------------------");
  }
}
