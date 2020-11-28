package algorithms.search;

/*
 * Binary algorithms.search is a performant algorithm to algorithms.search for a specific item on ordered lists
 *
 * This algorithm uses the preconception that the list is ordered to prevent
 * the need of checking each item on the list. It works by always cutting the array or list
 * in half based on the comparison of the searched item based on a defined criteria.
 *
 * In the below example we use integers so we compare the integers based on their values and
 * find their index for direct access.
 *
 * In more real world examples we could for instance get a list of ordered objects based on a attribute
 * and then perform a binary algorithms.search using this attribute as criteria reducing the amount of iterations needed.
 *
 * This is a great algorithm to use when we already have ordered lists or we can order our lists with performances below
 * 'n'
 *
 * If our lists are unordered or the cost to order a list is high it is not recommended.
 *
 * This algorithm complexity O(log n);
 */
public class BinarySearch {

  public static Integer search(int[] orderedArray, int searchedItem) {
    int minIndex = 0;
    int maxIndex = orderedArray.length - 1;
    Integer index = null;
    Integer tries = 0;

    while (minIndex <= maxIndex) {
      tries++;
      int searchIndex = (maxIndex + minIndex) / 2;
      int indexValue = orderedArray[searchIndex];

      if (indexValue == searchedItem) {
        index = searchIndex;
        break;
      } else if (indexValue > searchedItem) {
        maxIndex = searchIndex - 1;
      } else {
        minIndex = searchIndex + 1;
      }
    }

    System.out.printf("It took %s tries\n", tries);
    return index;
  }
}
