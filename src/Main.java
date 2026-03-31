// Main.java - тестовый клиент
public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        // Test add to end
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("After add: " + list);

        // Test add at position
        list.add(1, "X");
        System.out.println("After add(1, X): " + list);

        // Test addFirst
        list.addFirst("Z");
        System.out.println("After addFirst(Z): " + list);

        // Test get
        System.out.println("Element at index 2: " + list.get(2));

        // Test remove by index
        list.remove(2);
        System.out.println("After remove(2): " + list);

        // Test remove by value
        list.remove("B");
        System.out.println("After remove(B): " + list);

        // Test removeAll
        list.add("C");
        list.add("C");
        System.out.println("Before removeAll: " + list);
        list.removeAll("C");
        System.out.println("After removeAll(C): " + list);

        // Test size
        System.out.println("Size: " + list.getSize());
    }
}