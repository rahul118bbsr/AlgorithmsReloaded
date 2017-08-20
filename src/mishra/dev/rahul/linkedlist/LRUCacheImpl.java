package mishra.dev.rahul.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache
 * <p>
 * Created by aleesha on 17/08/17.
 */
public class LRUCacheImpl {


    class LRU<K, V> {
        private final static int DEFAULT_CAPACITY = 10;
        private Map<K, Node> cache;
        private int maxCacheSize = 0;
        private Node head;
        private Node tail;

        public LRU() {
            this(DEFAULT_CAPACITY);
        }

        public LRU(int capacity) {
            cache = new HashMap<>();
            maxCacheSize = capacity;
            init();
        }

        private void init() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public void put(K key, V value) {
            Node node = cache.get(key);
            if (node != null) {
                update(key, value);
                return;
            }
            if (cache.size() == maxCacheSize) {
                removeLeastRecentlyUsedNode();
            }
            add(key, value);
        }

        public V get(K key) {
            Node node = cache.get(key);
            if (node == null) {
                return null;
            }
            breakNodeLinks(node);
            addNodeToTail(node);
            return node.value;
        }

        private void removeLeastRecentlyUsedNode() {
            Node nodeToRemove = head.next;
            breakNodeLinks(nodeToRemove);
            cache.remove(nodeToRemove.key);
        }

        private void add(K key, V value) {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNodeToTail(newNode);
        }

        private void update(K key, V value) {
            Node node = cache.get(key);
            node.value = value;
            cache.put(key, node);
            breakNodeLinks(node);
            addNodeToTail(node);
        }

        private void breakNodeLinks(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        private void addNodeToTail(Node node) {
            Node prevNode = tail.prev;
            prevNode.next = node;
            node.prev = prevNode;
            node.next = tail;
            tail.prev = node;
        }


        class Node {
            private K key;
            private V value;
            private Node prev;
            private Node next;

            Node() {
            }

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

    }

}
