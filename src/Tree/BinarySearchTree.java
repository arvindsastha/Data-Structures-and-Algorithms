package src.Tree;

import src.DataStructureUtils;

public class BinarySearchTree {

    private BinaryTreeNode root;

    public BinarySearchTree(BinaryTreeNode root) {
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

        insertRecursively(root, node);
    }

    private void insertRecursively(BinaryTreeNode root, BinaryTreeNode node) {
        if(root.getLeft() == null && root.getRight() == null) {
            if(root.getValue() < node.getValue()) {
                root.updateRight(node);
            } else if(root.getValue() > node.getValue()) {
                root.updateLeft(node);
            } else {
                System.out.println("Duplicate found..");
            }
        } else if(root.getValue() > node.getValue()) {
            insertRecursively(root.getLeft(), node);
        } else if(root.getValue() < node.getValue()) {
            insertRecursively(root.getRight(), node);
        } else {
            System.out.println("Duplicate found..");
        }
    }

    private void deleteNodeWithOneChild(BinaryTreeNode root, BinaryTreeNode node) {
        if(root == null) {
            return;
        }

        if(root.getLeft() != null && root.getLeft().getValue() == node.getValue() && node.getLeft() == null) {
            root.updateLeft(node.getRight());
        } else if(root.getLeft() != null && root.getLeft().getValue() == node.getValue() && node.getRight() == null) {
            root.updateLeft(node.getLeft());
        } else if(root.getRight() != null && root.getRight().getValue() == node.getValue() && node.getLeft() == null) {
            root.updateRight(node.getRight());
        } else if(root.getRight() != null && root.getRight().getValue() == node.getValue() && node.getRight() == null) {
            root.updateRight(node.getLeft());
        } else if(root.getValue() > node.getValue()) {
            deleteNodeWithOneChild(root.getLeft(), node);
        } else if(root.getValue() < node.getValue()) {
            deleteNodeWithOneChild(root.getRight(), node);
        }
    }

    public void delete(int value) {
        BinaryTreeNode nodeToBeDeleted = DataStructureUtils.findNodeInBST(value, root);

        if(nodeToBeDeleted.getLeft() == null && nodeToBeDeleted.getRight() == null) {
            DataStructureUtils.deleteLeafNode(root, nodeToBeDeleted);
        } else if(nodeToBeDeleted.getLeft() == null || nodeToBeDeleted.getRight() == null) {
            deleteNodeWithOneChild(root, nodeToBeDeleted);
        } else {
            BinaryTreeNode rightMostNode = DataStructureUtils.findLeastValueInRightSubtree(root.getRight());
            if(rightMostNode == null) {
                root = root.getLeft();
            } else {
                int temp = nodeToBeDeleted.getValue();
                nodeToBeDeleted.updateValue(rightMostNode.getValue());
                rightMostNode.updateValue(temp);
                DataStructureUtils.deleteLeafNode(root, rightMostNode);
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binaryTree = DataStructureUtils.createBinarySearchTree();
        DataStructureUtils.printInOrderWalkOfBinaryTree(binaryTree.root);
        System.out.println("");
        DataStructureUtils.printPreOrderWalkOfBinaryTree(binaryTree.root);
        System.out.println("");
        DataStructureUtils.printPostOrderWalkOfBinaryTree(binaryTree.root);
        System.out.println("");

        binaryTree.insert(21);
        System.out.println("After inserting 21...");
        DataStructureUtils.printInOrderWalkOfBinaryTree(binaryTree.root);
        System.out.println("");

        binaryTree.insert(7);
        System.out.println("After inserting 7...");
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
