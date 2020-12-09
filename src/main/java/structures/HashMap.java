package structures;

import java.util.Objects;

/*
 * The Hashmap is a powerful data structure that allows for quick search of item based on a index.
 * Since it is based on a hash function the index can be anything from integers to objects.
 * It is a great fit when we have a good amount of items and have a index to find them so we don't need to iterate over elements.
 *
 * However, since this structure use arrays to index the items, and trying to reduce the ammount of array copies we may waste resources
 * since each time it is needed we are increasing the array by a factor of 2;
 *
 * The complexity of this algorithm is linear on average and best cases;
 *
 * Best and Average cases:
 * Insert/Fetch = O(1)
 *
 * Worst Cases:
 * Insert/Fetch = O(n)
 */
public class HashMap<K, V> {
  private final static double MAX_LOAD_FACTOR = 0.75;
  private double loadFactor = 0.00;
  private int load = 0;
  private int mapSize = 100;
  private LinkedList<Pair<K, V>>[] map = new LinkedList[mapSize];

  private int hash(K key) {
    int seed = Objects.hashCode(key);
    return seed % mapSize;
  }

  public void put(K key, V value) {
    int position = hash(key);
    LinkedList<Pair<K, V>> item = map[position];

    if (item == null) {
      item = new LinkedList<>();
      item.add(new Pair<>(key, value));
      map[position] = item;
      load++;
    } else {
      if (!item.exists((kvPair -> kvPair.key.equals(key)))) {
        item.add(new Pair<>(key, value));
        load++;
      }
    }

    loadFactor = calculateLoadFactor();

    if (loadFactor >= MAX_LOAD_FACTOR) {
      increaseSpace();
    }
  }

  public V get(K key) {
    LinkedList<Pair<K, V>> list = map[hash(key)];
    if (list != null) {
      return list.findFirst((kvPair -> kvPair.key.equals(key))).value;
    } else {
      return null;
    }
  }

  private void increaseSpace() {
    mapSize = mapSize * 2;
    loadFactor = calculateLoadFactor();
    LinkedList<Pair<K, V>>[] oldMap = this.map;
    this.map = new LinkedList[mapSize];

    load = 0;
    loadFactor = 0.00;

    for (LinkedList<Pair<K, V>> item : oldMap) {
      if (item != null) {
        item.forEach((kvPair -> put(kvPair.key, kvPair.value)));
      }
    }
  }

  private double calculateLoadFactor() {
    return (double) load / (double) mapSize;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("HashMap{");

    for (LinkedList<Pair<K, V>> list : map) {
      if (list != null) {
        list.forEach((kvPair -> {
          builder
              .append(kvPair)
              .append(", ");
        }));
      }
    }

    builder.delete(builder.length() - 2, builder.length());
    builder.append("}");
    return builder.toString();
  }


  private static class Pair<KK, VV> {
    private KK key;
    private VV value;

    public Pair(KK key, VV value) {
      this.key = key;
      this.value = value;
    }

    public KK getKey() {
      return key;
    }

    public void setKey(KK key) {
      this.key = key;
    }

    public VV getValue() {
      return value;
    }

    public void setValue(VV value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "Pair{" +
          "key=" + key +
          ", value=" + value +
          '}';
    }
  }

}
