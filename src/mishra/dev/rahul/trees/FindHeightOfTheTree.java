package mishra.dev.rahul.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by aleesha on 20/08/17.
 */
public class FindHeightOfTheTree {
    public static void main(String[] args) {
        Tree tree = new FindHeightOfTheTree().new Tree();
        Tree.Node root = tree.createBST(null, 50);
        root = tree.createBST(root, 17);
        root = tree.createBST(root, 72);
        root = tree.createBST(root, 12);
        root = tree.createBST(root, 9);
        root = tree.createBST(root, 23);
        root = tree.createBST(root, 19);
        root = tree.createBST(root, 54);
        root = tree.createBST(root, 67);
        root = tree.createBST(root, 14);
        root = tree.createBST(root, 76);
        root = tree.createBST(root, 66);
        System.out.println(tree.findHeightRecursively(root));
        System.out.println(tree.findHeightIteratively(root));
    }

    class Tree {
        public Node createBST(Node root, int value) {
            if (root == null) {
                return new Node(value);
            }

            if (value <= root.value) {
                root.left = createBST(root.left, value);
            } else {
                root.right = createBST(root.right, value);
            }
            return root;
        }

        public int findHeightRecursively(Node root) {
            if (root == null) {
                return 0;
            }
            return Math.max(findHeightRecursively(root.left) + 1, findHeightRecursively(root.right) + 1);
        }

        public int findHeightIteratively(Node root) {
            if (root == null) {
                return -1;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            int currentLevelCount = 0, height = 0;
            while (!queue.isEmpty()) {
                currentLevelCount = queue.size();
                for (int i = 0; i < currentLevelCount; i++) {
                    Node node = queue.poll();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                height++;
            }
            return height;
        }


        class Node {
            int value;
            Node left;
            Node right;

            Node(int data) {
                this.value = data;
            }

            @Override
            public String toString() {
                return value + "";
            }
        }
    }
}
