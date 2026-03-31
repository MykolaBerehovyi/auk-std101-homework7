import java.util.*;
import java.text.DecimalFormat;

public class ListPerformanceTest {
    public static void main(String[] args) {
        int numElements = 100000;
        DecimalFormat formatter = new DecimalFormat("#,###");

        System.out.println("Performance Comparison: ArrayList vs LinkedList");
        System.out.println("Number of elements: " + numElements);

        // Test 1: Insertion at beginning
        testInsertionAtBeginning(numElements, formatter);

        // Test 2: Access by index
        testAccessByIndex(numElements, formatter);

        // Test 3: Remove first element
        testRemoveFirst(numElements, formatter);
    }

    private static void testInsertionAtBeginning(int numElements, DecimalFormat formatter) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("\nTest 1: Insertion at beginning (add(0, element))");
        System.out.println("-".repeat(60));

        // ArrayList insertion at beginning
        long startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            arrayList.add(0, i);
        }
        long endTime = System.nanoTime();
        long arrayListTime = endTime - startTime;

        // LinkedList insertion at beginning
        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            linkedList.add(0, i);
        }
        endTime = System.nanoTime();
        long linkedListTime = endTime - startTime;

        System.out.println("ArrayList time:  " + formatter.format(arrayListTime) + " ns");
        System.out.println("LinkedList time: " + formatter.format(linkedListTime) + " ns");
    }

    private static void testAccessByIndex(int numElements, DecimalFormat formatter) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Populate both lists
        for (int i = 0; i < numElements; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        System.out.println("\nTest 2: Access by index (get(index))");
        System.out.println("-".repeat(60));

        // ArrayList access
        long startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            arrayList.get(i);
        }
        long endTime = System.nanoTime();
        long arrayListTime = endTime - startTime;

        // LinkedList access
        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            linkedList.get(i);
        }
        endTime = System.nanoTime();
        long linkedListTime = endTime - startTime;

        System.out.println("ArrayList time:  " + formatter.format(arrayListTime) + " ns");
        System.out.println("LinkedList time: " + formatter.format(linkedListTime) + " ns");
    }

    private static void testRemoveFirst(int numElements, DecimalFormat formatter) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Populate both lists
        for (int i = 0; i < numElements; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        System.out.println("\nTest 3: Remove first element (remove(0))");
        System.out.println("-".repeat(60));

        // ArrayList remove first
        long startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            arrayList.remove(0);
        }
        long endTime = System.nanoTime();
        long arrayListTime = endTime - startTime;

        // LinkedList remove first
        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            linkedList.remove(0);
        }
        endTime = System.nanoTime();
        long linkedListTime = endTime - startTime;

        System.out.println("ArrayList time:  " + formatter.format(arrayListTime) + " ns");
        System.out.println("LinkedList time: " + formatter.format(linkedListTime) + " ns");
    }
}