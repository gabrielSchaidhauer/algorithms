package structures;

import java.util.function.Consumer;
import java.util.function.Function;

/*
 * This is the implementation of a linked list, this data structure
 * is a list that is that is best suited when the access pattern is
 * more suited for insertions on the list than readings.
 *
 * It does not need contiguous memory allocation and can increase as long as we have
 * enough memory to allocate.
 *
 * We have different complexities for each operation with this structure:
 *
 * Insertion is O(1) always inserting on the end;
 * Deleting is O(1) always removing from the end;
 * Finding items is O(n) it needs to iterate over each element because
 * only the element keep the reference to the next.
 */
public class LinkedList<T> {

  private Node<T> first = null;
  private Node<T> last = null;
  private long size = 0;

  public void add(T content) {
    Node<T> node = new Node<>(content);

    if (first == null) {
      first = node;
    }

    if (last != null) {
      node.setPrevious(last);
      last.setNext(node);
    }

    last = node;
    size++;
  }

  public void remove() {
    if (last != null) {
      Node<T> toBeRemoved = last;
      last = toBeRemoved.getPrevious();

      if (last != null) {
        last.setNext(null);
      }

      if (toBeRemoved == first) {
        first = null;
      }
      size--;
    }
  }

  public void forEach(Consumer<T> action) {
    if (first != null) {
      Node<T> current = first;
      do {
        action.accept(current.getItem());
        current = current.getNext();
      } while (current != null);
    }
  }

  public void forEachReverse(Consumer<T> action) {
    if (first != null) {
      Node<T> current = last;
      do {
        action.accept(current.getItem());
        current = current.getPrevious();
      } while (current != null);
    }
  }

  public boolean exists(Function<T, Boolean> check) {
    if (first != null) {
      Node<T> current = first;
      do {
        if (check.apply(current.getItem())) {
          return true;
        }
        current = current.getNext();
      } while (current != null);
    }

    return false;
  }

  public T findFirst(Function<T, Boolean> check) {
    if (first != null) {
      Node<T> current = first;
      do {
        if (check.apply(current.getItem())) {
          return current.getItem();
        }
        current = current.getNext();
      } while (current != null);
    }

    return null;
  }

  public long size() {
    return size;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("LinkedList {");

    forEach((item) -> {
      builder.append(item);
      builder.append(",");
    });

    if (builder.charAt(builder.length() - 1) == ',') {
      builder.deleteCharAt(builder.length() - 1);
    }

    builder.append("}");
    return builder.toString();
  }

  private static class Node<G> {
    private G item;
    private Node<G> previous;
    private Node<G> next;

    public Node(G item, Node<G> next) {
      this.item = item;
      this.next = next;
    }

    public Node(G item, Node<G> previous, Node<G> next) {
      this.item = item;
      this.previous = previous;
      this.next = next;
    }

    public Node(G item) {
      this.item = item;
      this.next = null;
    }

    public G getItem() {
      return item;
    }

    public void setItem(G item) {
      this.item = item;
    }

    public Node<G> getNext() {
      return next;
    }

    public void setNext(Node<G> next) {
      this.next = next;
    }

    public Node<G> getPrevious() {
      return previous;
    }

    public void setPrevious(Node<G> previous) {
      this.previous = previous;
    }

    @Override
    public String toString() {
      return "Node{" +
          "item=" + item +
          ", previous=" + previous +
          ", next=" + next +
          '}';
    }
  }
}
