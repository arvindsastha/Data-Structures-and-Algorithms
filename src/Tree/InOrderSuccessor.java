package src.Tree;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import src.DataStructureUtils;

public class InOrderSuccessor {

    private class BinaryTreeNodeSuccessor {
        private BinaryTreeNode root;
        private BinaryTreeNode successor;

        public BinaryTreeNode getSuccessor() {
            return successor;
        }

        public void setSuccessor(BinaryTreeNode successor) {
            this.successor = successor;
        }

        public BinaryTreeNode getRoot() {
            return root;
        }

        public void setRoot(BinaryTreeNode root) {
            this.root = root;
        }
    }

    // Assuming duplicates are not allowed
    private BinaryTreeNode findSuccessorInBST(BinaryTreeNode root, BinaryTreeNode node) {
        if(root == null || node == null) {
            return null;
        }

        BinaryTreeNode successor = null;

        if(node.getRight() != null) {
            successor = DataStructureUtils.findLeastValueInRightSubtree(node.getRight());
        } else {
            while(root != null) {
                if(root.getValue() > node.getValue()) {
                    successor = root;
                    root = root.getLeft();
                } else if(root.getValue() < node.getValue()) {
                    root = root.getRight();
                } else {
                    break;
                }
            }
        }
        return successor;
    }

    private BinaryTreeNode findSuccessorInBT(BinaryTreeNode root, BinaryTreeNode node) {
        if(root == null || node == null) {
            return null;
        }

        if(node.getRight() != null) {
            return DataStructureUtils.findLeastValueInRightSubtree(root.getRight());
        } else {
            BinaryTreeNode rightMostNode = DataStructureUtils.findRightMostNode(root);

            // No inorder successor for right most node
            if(node == rightMostNode) {
                return null;
            } else {
                BinaryTreeNodeSuccessor binaryTreeNodeSuccessor = new BinaryTreeNodeSuccessor();
                findSuccessorRecursively(root, node, binaryTreeNodeSuccessor);
                return binaryTreeNodeSuccessor.getSuccessor();
            }
        }
    }

    private void findSuccessorRecursively(BinaryTreeNode root, BinaryTreeNode node,
                                                             BinaryTreeNodeSuccessor binaryTreeNodeSuccessor) {
        if (root == null) {
            return;
        }

        if(root.getValue() == node.getValue()) {
            binaryTreeNodeSuccessor.setRoot(root);
            return;
        }

        findSuccessorRecursively(root.getLeft(), node, binaryTreeNodeSuccessor);

        if(binaryTreeNodeSuccessor == null || binaryTreeNodeSuccessor.getRoot() == null) {
            findSuccessorRecursively(root.getRight(), node, binaryTreeNodeSuccessor);
        }

        if(binaryTreeNodeSuccessor != null && binaryTreeNodeSuccessor.getRoot() != null) {
            if (root.getLeft() == binaryTreeNodeSuccessor.getRoot()) {
                binaryTreeNodeSuccessor.setSuccessor(root);
                return;
            }
            binaryTreeNodeSuccessor.setRoot(root);
        }
    }

    public static void main(String[] args) {
        InOrderSuccessor inOrderSuccessor = new InOrderSuccessor();

        BinarySearchTree binarySearchTree = DataStructureUtils.createBinarySearchTree();
        BinaryTreeNode successor = inOrderSuccessor.findSuccessorInBST(binarySearchTree.getRoot(),
                binarySearchTree.getRoot().getLeft().getLeft());
        if(successor == null) {
            System.out.println("Successor not present");
        } else {
            System.out.println("Successor for 2 in BST: " + successor.getValue());
        }

        BinaryTree binaryTree = DataStructureUtils.createBinaryTree();
        successor = inOrderSuccessor.findSuccessorInBT(binaryTree.getRoot(),
                binaryTree.getRoot().getLeft().getLeft());
        if(successor == null) {
            System.out.println("Successor not present");
        } else {
            System.out.println("Successor for 6 in BT: " + successor.getValue());
        }

        binarySearchTree = DataStructureUtils.createBinarySearchTree();
        successor = inOrderSuccessor.findSuccessorInBST(binarySearchTree.getRoot(),
                binarySearchTree.getRoot().getLeft().getRight());
        if(successor == null) {
            System.out.println("Successor not present");
        } else {
            System.out.println("Successor for 6 in BST: " + successor.getValue());
        }

        binaryTree = DataStructureUtils.createBinaryTree();
        successor = inOrderSuccessor.findSuccessorInBT(binaryTree.getRoot(),
                binaryTree.getRoot().getLeft().getRight());
        if(successor == null) {
            System.out.println("Successor not present");
        } else {
            System.out.println("Successor for 5 in BT: " + successor.getValue());
        }
    }
}
