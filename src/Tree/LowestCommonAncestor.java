package src.Tree;

import src.DataStructureUtils;

public class LowestCommonAncestor {

    private BinaryTreeNode findLCAForBST(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }

        if ((root.getValue() >= node1.getValue() && root.getValue() <= node2.getValue())
                || (root.getValue() <= node1.getValue() && root.getValue() >= node2.getValue())) {
            return root;
        }

        if (root.getValue() < node1.getValue()) {
            return findLCAForBST(root.getRight(), node1, node2);
        } else {
            return findLCAForBST(root.getLeft(), node1, node2);
        }
    }

    private BinaryTreeNode findLCAForBinaryTree(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
        if(root == null || node1 == null || node2 == null) {
            return null;
        }

        if(root.getValue() == node1.getValue() || root.getValue() == node2.getValue()) {
            return root;
        }

        BinaryTreeNode leftNode = findLCAForBinaryTree(root.getLeft(), node1, node2);
        BinaryTreeNode rightNode = findLCAForBinaryTree(root.getRight(), node1, node2);

         if(leftNode != null && rightNode != null) {
            return root;
        }

        return leftNode != null? leftNode: rightNode;
    }

    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        BinarySearchTree binarySearchTree = DataStructureUtils.createBinarySearchTree();

        BinaryTreeNode lca = lowestCommonAncestor.findLCAForBST(binarySearchTree.getRoot(),
                new BinaryTreeNode(6), new BinaryTreeNode(11));

        if(lca == null) {
            System.out.println("Lowest Common Ancestor not found");
        } else {
            System.out.println("LCA for 6 & 11: " + lca.getValue());
        }

        lca = lowestCommonAncestor.findLCAForBST(binarySearchTree.getRoot(),
                new BinaryTreeNode(6), new BinaryTreeNode(5));

        if(lca == null) {
            System.out.println("Lowest Common Ancestor not found");
        } else {
            System.out.println("LCA for 6 & 5: " + lca.getValue());
        }

        lca = lowestCommonAncestor.findLCAForBST(binarySearchTree.getRoot(),
                new BinaryTreeNode(21), new BinaryTreeNode(11));

        if(lca == null) {
            System.out.println("Lowest Common Ancestor not found");
        } else {
            System.out.println("LCA for 11 & 21: " + lca.getValue());
        }

        BinaryTree binaryTree = DataStructureUtils.createBinaryTree();

        lca = lowestCommonAncestor.findLCAForBinaryTree(binaryTree.getRoot(),
                new BinaryTreeNode(6), new BinaryTreeNode(3));

        if(lca == null) {
            System.out.println("Lowest Common Ancestor not found");
        } else {
            System.out.println("LCA for 6 & 3: " + lca.getValue());
        }
    }
}
