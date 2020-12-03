package algorithms.sort;

import java.util.Arrays;

public class QuickSort {

  /*
   * Quick sort is an optimized sorting algorithm.
   *
   * This algorithm works by applying the divide and conquer technique that involves dividing the
   * problem into smaller problems and then solving it recursively.
   *
   * On this algorithm we have an array as input and define 3 situations.
   *
   * 1. We can work with arrays with 1 or 0 elements by just returning them
   * 2. We can work with arrays with 2  elements by ordering them by changing positions where needed [3, 1]  -> [1, 3]
   * 3 We can work with arrays bigger than 2 elements by taking one element as a pivot and dividing the other elements
   * into two arrays one containing the elements that are higher than the pivot and other with lower items, and them repeating
   * this process until we can have arrays that can be ordered by the first two hypothesis.
   *
   * The algorithm work like the following example:
   *
   * [2, 1, 7, 10, 5]
   *        ˆ
   *      Pivot
   *
   * [2, 1, 5] 7 [10]
   *     ˆ
   *   Pivot
   *
   * [] 1 [2, 5]
   *
   * [1, 2, 5] 7 [10]
   *
   * [1, 2, 5, 7, 10]
   *
   * This algorithm complexity is not constant it can vary depending on
   * the data.
   *
   * Best and average case: O(n log n)
   * Worst case: O(nˆ2)
   */
  public static int[] sort(int[] unsorted) {
    if (unsorted.length <= 1) {
      return unsorted;
    } else if (unsorted.length == 2) {
      if (unsorted[0] > unsorted[1]) {
        return new int[]{unsorted[1], unsorted[0]};
      } else {
        return unsorted;
      }
    } else {
      int midItem = unsorted[(unsorted.length - 1) / 2];
      int midIndex = (unsorted.length - 1) / 2;
      int lesserIndex = 0;
      int biggerIndex = 0;
      int[] lesser = new int[unsorted.length];
      int[] bigger = new int[unsorted.length];
      int[] ordered = new int[unsorted.length];

      for (int i = 0; i < unsorted.length; i++) {
        if (i != midIndex) {
          int item = unsorted[i];
          if (item <= midItem) {
            lesser[lesserIndex] = item;
            lesserIndex++;
          } else {
            bigger[biggerIndex] = item;
            biggerIndex++;
          }
        }
      }

      lesser = sort(Arrays.copyOf(lesser, lesserIndex));
      bigger = sort(Arrays.copyOf(bigger, biggerIndex));
      System.arraycopy(lesser, 0, ordered, 0, lesser.length);
      ordered[lesser.length] = midItem;
      System.arraycopy(bigger, 0, ordered, lesser.length + 1, bigger.length);

      return ordered;
    }
  }
}
