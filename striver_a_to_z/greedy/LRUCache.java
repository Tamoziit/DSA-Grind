
import java.util.HashMap;

public class LRUCache {

    private class Node {

        int key, val;
        Node prev, next;

        Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> cache = new HashMap<>();
    private final Node head = new Node(0, 0); // sentinel
    private final Node tail = new Node(0, 0); // sentinel

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtTail(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        remove(node);
        insertAtTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        } else if (cache.size() == capacity) {
            cache.remove(head.next.key);
            remove(head.next);
        }
        Node node = new Node(key, value);
        insertAtTail(node);
        cache.put(key, node);
    }
}
