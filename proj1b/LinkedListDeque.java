public class LinkedListDeque<T> implements Deque<T> {
    private class Node {
        private T value;
        private Node prev;
        private Node next;
        public Node() {
            value = null;
            prev = null;
            next = null;
        }
        public Node(T val) {
            value = val;
            prev = null;
            next = null;
        }
        public Node(T val, Node p, Node n) {
            value = val;
            prev = p;
            next = n;
        }
    }
    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    // deep copy
//    public LinkedListDeque(LinkedListDeque other) {
//        sentinel = new Node();
//        sentinel.prev = sentinel;
//        sentinel.next = sentinel;
//        size = 0;
//        for (int i = 0; i < other.size(); i += 1) {
//            addLast((T) other.get(i)); // type-casting
////            addLast(other.get(i)); // if LinkedListDeque<T> other is used in argument
//        }
//    }
    @Override
    public void addFirst(T item) {
        size++;
        Node first = new Node(item);
        first.prev = sentinel;
        first.next = sentinel.next;
        sentinel.next.prev = first;
        sentinel.next = first;
    }
    @Override
    public void addLast(T item) {
        if (size == 0) {
            addFirst(item);
            return;
        }
        size++;
        Node last = new Node(item);
        last.prev = sentinel.prev;
        last.next = sentinel;
        sentinel.prev.next = last;
        sentinel.prev = last;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        Node p = sentinel;
        while (p.next != sentinel) {
            p = p.next;
            System.out.print(p.value + " ");
        }
        System.out.println();
    }
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node toBeRemoved = sentinel.next;
        T res = toBeRemoved.value;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        toBeRemoved.prev = null;
        toBeRemoved.next = null;
        size--;
        return res;
    }
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node toBeRemoved = sentinel.prev;
        T res = toBeRemoved.value;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        toBeRemoved.prev = null;
        toBeRemoved.next = null;
        size--;
        return res;
    }
    @Override
    public T get(int index) {
        Node res = sentinel.next;
        for (int i = 0; i < index; i += 1) {
            res = res.next;
        }
        return res.value;
    }

    public T getRecursive(int index) {
        if (size < index) {
            return null;
        }
        return getRecursive(sentinel.next, index);
    }

    private T getRecursive(Node node, int i) {
        if (i == 0) {
            return node.value;
        }
        return getRecursive(node.next, i - 1);
    }

}
