package src;

import src.List.CustomLinkedList;
import src.Tree.BinarySearchTree;
import src.Tree.BinaryTree;
import src.Tree.BinaryTreeNode;

public class DataStructureUtils {
    /**
     * Prints array values between the start and end index including start and end
     * @param input - Array to be printed
     * @param begin - Start index
     * @param end - End index
     */
     public static void printArrayBetweenStartAndEnd(int[] input, int begin, int end) {
        for(int i=begin; i<=end; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println("");
    }

    /**
     * Prints the entire array
     * @param input - Array to be printed
     */
    public static void printArray(int[] input) {
        printArrayBetweenStartAndEnd(input, 0, input.length - 1);
    }

    /**
     * Utility method to swap values
     * @param input - Input array in which values should be swapped
     * @param indexA - First index
     * @param indexB - Second index
     */
    public static void swapValuesInArray(int[] input, int indexA, int indexB) {
        int temp = input[indexA];
        input[indexA] = input[indexB];
        input[indexB] = temp;
    }

    public static void printList(CustomLinkedList head) {
        if(head != null) {
            CustomLinkedList headCopy = head;

            while (headCopy != null) {
                System.out.println(headCopy.getNodeValue() + " ");
                headCopy = headCopy.getNextNode();
            }
            System.out.println("");
        } else {
            // do nothing
            System.out.println("Empty List");
        }
    }

    public static CustomLinkedList createLinkedList() {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.add(1);
        customLinkedList.add(2);
        customLinkedList.add(3);
        customLinkedList.add(4);
        customLinkedList.add(5);
        customLinkedList.add(6);
        customLinkedList.add(7);

        return customLinkedList;
    }

    public static String printNodeValue(CustomLinkedList node) {
        if(node == null) {
            return "Node is empty";
        } else {
            return node.getNodeValue() + "";
        }
    }

    public static BinaryTree createBinaryTree() {

        //                  1
        //               /     \
        //              2       3
        //             / \     / \
        //            6   5   10  8

        BinaryTreeNode root = new BinaryTreeNode(1);
        root.updateLeft(new BinaryTreeNode(2));
        root.updateRight(new BinaryTreeNode(3));
        root.getLeft().updateLeft(new BinaryTreeNode(6));
        root.getLeft().updateRight(new BinaryTreeNode(5));
        root.getRight().updateLeft(new BinaryTreeNode(10));
        root.getRight().updateRight(new BinaryTreeNode(8));

        return new BinaryTree(root);
    }

    public static BinarySearchTree createBinarySearchTree() {

        //                  10
        //               /     \
        //              5      12
        //             / \    /  \
        //            2   6  11  21

        BinaryTreeNode root = new BinaryTreeNode(10);
        root.updateLeft(new BinaryTreeNode(5));
        root.updateRight(new BinaryTreeNode(12));
        root.getLeft().updateLeft(new BinaryTreeNode(2));
        root.getLeft().updateRight(new BinaryTreeNode(6));
        root.getRight().updateLeft(new BinaryTreeNode(11));
        root.getRight().updateRight(new BinaryTreeNode(21));

        return new BinarySearchTree(root);
    }

    public static void printInOrderWalkOfBinaryTree(BinaryTreeNode root) {
        if(root == null) {
            return;
        }

        printInOrderWalkOfBinaryTree(root.getLeft());
        System.out.print(root.getValue() + " ");
        printInOrderWalkOfBinaryTree(root.getRight());
    }

    public static void printPreOrderWalkOfBinaryTree(BinaryTreeNode root) {
        if(root == null) {
            return;
        }

        System.out.print(root.getValue() + " ");
        printPreOrderWalkOfBinaryTree(root.getLeft());
        printPreOrderWalkOfBinaryTree(root.getRight());
    }

    public static void printPostOrderWalkOfBinaryTree(BinaryTreeNode root) {
        if(root == null) {
            return;
        }

        printPostOrderWalkOfBinaryTree(root.getLeft());
        printPostOrderWalkOfBinaryTree(root.getRight());
        System.out.print(root.getValue() + " ");

    }

    public static BinaryTreeNode findNode(int value, BinaryTreeNode root) {
        if(root == null) {
             return null;
        }

        if(root.getValue() == value) {
            return root;
        }

        BinaryTreeNode leftNode = findNode(value, root.getLeft());
        BinaryTreeNode rightNode = findNode(value, root.getLeft());
        return (leftNode != null)? leftNode: rightNode;
    }

    public static BinaryTreeNode findNodeInBST(int value, BinaryTreeNode root) {
        if(root == null) {
            return null;
        } else if(root.getValue() == value) {
            return root;
        } else if(root.getValue() > value) {
            return findNodeInBST(value, root.getLeft());
        } else {
            return findNodeInBST(value, root.getRight());
        }
    }

    public static BinaryTreeNode findDeepestRightMostNode(BinaryTreeNode root) {
        if(root.getRight() != null) {
            return findDeepestRightMostNode(root.getRight());
        }

        if(root.getLeft() != null) {
            return findDeepestRightMostNode(root.getLeft());
        }

        return root;
    }

    public static BinaryTreeNode findLeastValueInRightSubtree(BinaryTreeNode root) {
        if(root == null) {
            return null;
        }

        while(root.getLeft() != null) {
            root = root.getLeft();
        }

        return root;
    }

    public static BinaryTreeNode findRightMostNode(BinaryTreeNode root) {
        if(root == null) {
            return null;
        }

        while(root.getRight() != null) {
            root = root.getRight();
        }

        return root;
    }

    public static void deleteLeafNode(BinaryTreeNode root, BinaryTreeNode nodeToBeDeleted) {

        if(root == null) {
            return;
        } else if(root.getLeft() != null && root.getLeft().getValue() == nodeToBeDeleted.getValue()) {
            root.updateLeft(null);
            return;
        } else if(root.getRight() != null && root.getRight().getValue() == nodeToBeDeleted.getValue()) {
            root.updateRight(null);
            return;
        }

        deleteLeafNode(root.getRight(), nodeToBeDeleted);
        deleteLeafNode(root.getLeft(), nodeToBeDeleted);
    }

}
