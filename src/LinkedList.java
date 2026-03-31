import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    // Nested Node class
    private static class Node<T> {
        T element;
        Node<T> prev;
        Node<T> next;

        Node(Node<T> prev, T element, Node<T> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }

    // Constructor
    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    // Adds to the end
    public void add(T e) {
        add(size, e);
    }

    // Inserts element at position i
    public void add(int i, T e) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }

        if (i == size) {
            // Add at the end
            Node<T> newNode = new Node<>(last, e, null);
            if (last == null) {
                first = newNode;
            } else {
                last.next = newNode;
            }
            last = newNode;
        } else {
            Node<T> nodeAtIndex = getNode(i);
            Node<T> prevNode = nodeAtIndex.prev;
            Node<T> newNode = new Node<>(prevNode, e, nodeAtIndex);

            if (prevNode == null) {
                first = newNode;
            } else {
                prevNode.next = newNode;
            }
            nodeAtIndex.prev = newNode;
        }
        size++;
    }

    // Get element at position i
    public T get(int i) {
        Node<T> node = getNode(i);
        return node.element;
    }

    // Remove first element equal to e
    public boolean remove(T e) {
        Node<T> current = first;
        while (current != null) {
            if (current.element.equals(e)) {
                removeNode(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Remove element at index i
    public T remove(int i) {
        Node<T> nodeToRemove = getNode(i);
        T element = nodeToRemove.element;
        removeNode(nodeToRemove);
        return element;
    }

    // Remove all elements equal to e
    public boolean removeAll(T e) {
        boolean removed = false;
        Node<T> current = first;
        while (current != null) {
            Node<T> next = current.next;
            if (current.element.equals(e)) {
                removeNode(current);
                removed = true;
            }
            current = next;
        }
        return removed;
    }

    // Adds element at the beginning
    public void addFirst(T e) {
        add(0, e);
    }

    // Returns list size
    public int getSize() {
        return size;
    }

    // String representation
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            if (i > 0) sb.append(", ");
            sb.append(current.element);
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // Helper method to find node by index
    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> x;
        // Optimize traversal by choosing direction
        if (index < size / 2) {
            x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
        }
        return x;
    }

    // Helper method to remove a node
    private void removeNode(Node<T> node) {
        Node<T> prevNode = node.prev;
        Node<T> nextNode = node.next;

        if (prevNode == null) {
            first = nextNode;
        } else {
            prevNode.next = nextNode;
        }

        if (nextNode == null) {
            last = prevNode;
        } else {
            nextNode.prev = prevNode;
        }

        size--;
    }

    // Iterator implementation
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node<T> current = first;
        private int index = 0;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T element = current.element;
            current = current.next;
            index++;
            return element;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operation not supported by iterator");
        }
    }
}