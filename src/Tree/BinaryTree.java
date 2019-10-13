package src.Tree;

import src.DataStructureUtils;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTreeNode getRoot() {
        return this.root;
    }

    void insert(int value) {
        BinaryTreeNode node = new BinaryTreeNode(value);

        if (root == null) {
            root = node;
            return;
        }

        Queue<BinaryTreeNode> levelOrderQueue = new LinkedList<>();
        levelOrderQueue.add(root);

        while(!levelOrderQueue.isEmpty()) {
            BinaryTreeNode current = levelOrderQueue.peek();
            levelOrderQueue.remove();

            if(current.getLeft() == null) {
                current.updateLeft(node);
                return;
            } else {
                levelOrderQueue.add(current.getLeft());
            }

            if(current.getRight() == null) {
                current.updateRight(node);
                return;
            } else {
                levelOrderQueue.add(current.getRight());
            }
        }
    }

    public void delete(int value) {
        BinaryTreeNode nodeToBeDeleted = DataStructureUtils.findNode(value, root);

        if(nodeToBeDeleted.getLeft() == null && nodeToBeDeleted.getRight() == null) {
            DataStructureUtils.deleteLeafNode(root, nodeToBeDeleted);
        } else {
            BinaryTreeNode rightMostNode = DataStructureUtils.findDeepestRightMostNode(root);
            int temp = nodeToBeDeleted.getValue();
            nodeToBeDeleted.updateValue(rightMostNode.getValue());
            rightMostNode.updateValue(temp);
            DataStructureUtils.deleteLeafNode(root, rightMostNode);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = DataStructureUtils.createBinaryTree();
        DataStructureUtils.printInOrderWalkOfBinaryTree(binaryTree.root);
        System.out.println("");
        DataStructureUtils.printPreOrderWalkOfBinaryTree(binaryTree.root);
        System.out.println("");
        DataStructureUtils.printPostOrderWalkOfBinaryTree(binaryTree.root);
        System.out.println("");

        binaryTree.insert(21);
        System.out.println("After inserting...");
        DataStructureUtils.printInOrderWalkOfBinaryTree(binaryTree.root);
        System.out.println("");

        binaryTree.delete(2);
        System.out.println("After deleting 2...");
        DataStructureUtils.printInOrderWalkOfBinaryTree(binaryTree.root);
        System.out.println("");

        binaryTree.delete(21);
        System.out.println("After deleting 21...");
        DataStructureUtils.printInOrderWalkOfBinaryTree(binaryTree.root);
    }
}
