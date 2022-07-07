public class ArrayDequeTest {
    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static boolean checkEqual(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("Constructor returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static boolean checkGet(int expected, int actual) {
        if (expected != actual) {
            System.out.println("get() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static boolean checkRemove(int expected, int actual) {
        if (expected != actual) {
            System.out.println("remove() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

//    public static boolean checkCapacity(int expected, int actual) {
//        if (expected != actual) {
//            System.out.println("capacity() returned " + actual + ", but expected: " + expected);
//            return false;
//        }
//        return true;
//    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");

        ArrayDeque<String> lld1 = new ArrayDeque<>();

        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst("middle");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addFirst("front");
        passed = checkSize(2, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addLast("back");
        passed = checkSize(3, lld1.size()) && passed;

        System.out.print("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);

    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        lld1.addLast(0);
        lld1.addFirst(10);
        lld1.addFirst(5);
        lld1.addLast(15);
        boolean passed = checkEmpty(true, lld1.get(0) == 5);
        passed = checkEmpty(true, lld1.get(1) == 10) && passed;
        passed = checkEmpty(true, lld1.get(2) == 0) && passed;
        passed = checkEmpty(true, lld1.get(3) == 15) && passed;
        System.out.print("Printing out deque: ");
        lld1.printDeque();

        lld1.removeFirst();
        // should be empty
        passed = checkEmpty(false, lld1.isEmpty()) && passed;
        System.out.print("Printing out deque: ");
        lld1.printDeque();

        lld1.removeLast();
        passed = checkEmpty(false, lld1.isEmpty()) && passed;
        System.out.print("Printing out deque: ");
        lld1.printDeque();

        lld1.removeFirst();
        passed = checkEmpty(false, lld1.isEmpty()) && passed;
        System.out.print("Printing out deque: ");
        lld1.printDeque();

        lld1.removeLast();
        passed = checkEmpty(true, lld1.isEmpty()) && passed;
        System.out.print("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);

    }

//    public static void copyConstructorTest() {
//        System.out.println("Running copy constructor test.");
//        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
//        lld1.addFirst(10);
//        lld1.addFirst(5);
//        lld1.addLast(15);
//
//        LinkedListDeque<Integer> lld2 = new LinkedListDeque<>(lld1);
//        boolean passed = checkEqual(true, lld1.size() == lld2.size());
//        if (passed) {
//            for (int i = 0; i < lld1.size(); i++) {
//                passed = checkEqual(true, lld1.get(i) == lld2.get(i)) && passed;
//            }
//        }
//        System.out.print("Printing out deque: ");
//        lld2.printDeque();
//        printTestStatus(passed);
//    }

    public static void addRemoveTest2() {
        System.out.println("Running add/remove/get test.");

        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(0);
        boolean passed = checkRemove(0, ad1.removeFirst());
        ad1.addFirst(2);
        ad1.addLast(3);
        ad1.addLast(4);
        ad1.addLast(5);
        System.out.print("Printing out deque: ");
        ad1.printDeque();

        passed = checkRemove(5, ad1.removeLast()) && passed;
        passed = checkGet(2, ad1.get(0)) && passed;
        passed = checkGet(4, ad1.get(2)) && passed;
        ad1.addFirst(9);
        ad1.addLast(10);
        System.out.print("Printing out deque: ");
        ad1.printDeque();
        passed = checkGet(3, ad1.get(2)) && passed;
        ad1.addLast(12);
        passed = checkRemove(12, ad1.removeLast()) && passed;
        ad1.addFirst(14);
        passed = checkGet(3, ad1.get(3)) && passed;
        ad1.addFirst(16);
        ad1.addFirst(17);
        ad1.addLast(18);
        System.out.print("Printing out deque: ");
        ad1.printDeque();
        passed  = checkGet(2, ad1.get(4)) && passed;
        passed = checkGet(14, ad1.get(2)) && passed;
        ad1.addLast(21);
        System.out.print("Printing out deque: ");
        ad1.printDeque();
        passed = checkRemove(17, ad1.removeFirst()) && passed;

        printTestStatus(passed);
    }

//    public static void resizeTest() {
//        System.out.println("Running add/remove/size test.");
//
//        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
//        ad1.addFirst(10);
//        ad1.addFirst(9);
//        ad1.addFirst(8);
//        ad1.addFirst(7);
//        ad1.addFirst(6);
//        ad1.addFirst(5);
//        ad1.addFirst(4);
//        ad1.addFirst(3);
//        ad1.addFirst(2);
//        boolean passed = checkCapacity(16, ad1.capacity());
//        ad1.addFirst(1);
//        ad1.addFirst(0);
//        ad1.addFirst(1);
//        ad1.addFirst(2);
//        ad1.addFirst(3);
//        ad1.addFirst(4);
//        ad1.addFirst(5);
//        ad1.addLast(10);
//        passed = checkCapacity(32, ad1.capacity()) && passed;
//        ad1.addFirst(9);
//        ad1.addFirst(8);
//        ad1.addFirst(7);
//        ad1.addFirst(6);
//
//        System.out.print("Printing out deque: ");
//        ad1.printDeque();
//
//        ad1.removeFirst();
//        ad1.removeFirst();
//        ad1.removeFirst();
//        ad1.removeFirst();
//        ad1.removeFirst();
//        ad1.removeFirst();
//        passed = checkCapacity(16, ad1.capacity()) && passed;
//        ad1.removeFirst();
//        ad1.removeFirst();
//        ad1.removeFirst();
//        ad1.removeFirst();
//        ad1.removeFirst();
//        ad1.removeFirst();
//        ad1.removeFirst();
//        ad1.removeLast();
//        passed = checkCapacity(8, ad1.capacity()) && passed;
//        ad1.removeFirst();
//        ad1.removeFirst();
//        System.out.print("Printing out deque: ");
//        ad1.printDeque();
//
//        printTestStatus(passed);
//    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
        addRemoveTest2();
//        copyConstructorTest();
//        resizeTest();
    }
}
