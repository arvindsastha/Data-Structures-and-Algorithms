package src.Tree;

import src.DataStructureUtils;

public class MirrorOfATree {

    private void mirrorTree(BinaryTreeNode root) {
        if(root == null) {
            return;
        }

        BinaryTreeNode temp = root.getLeft();
        root.updateLeft(root.getRight());
        root.updateRight(temp);

        mirrorTree(root.getLeft());
        mirrorTree(root.getRight());
    }

    boolean checkIfTreesAreMirrorTrees(BinaryTreeNode root1, BinaryTreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        } else if(root1 == null) {
            return false;
        } else if(root2 == null) {
            return false;
        }

        boolean leftSubTree = checkIfTreesAreMirrorTrees(root1.getLeft(), root2.getRight());
        boolean rightSubTree = checkIfTreesAreMirrorTrees(root1.getRight(), root2.getLeft());

        return root1.getValue() == root2.getValue() && leftSubTree && rightSubTree;
    }

    public static void main(String[] args) {
        MirrorOfATree mirrorOfATree = new MirrorOfATree();
        BinaryTree binaryTree = DataStructureUtils.createBinaryTree();
        BinaryTree orgBinaryTree = DataStructureUtils.createBinaryTree();

        DataStructureUtils.printInOrderWalkOfBinaryTree(binaryTree.getRoot());
        System.out.println("");

        System.out.println("After mirroring..");
        mirrorOfATree.mirrorTree(binaryTree.getRoot());
        DataStructureUtils.printInOrderWalkOfBinaryTree(binaryTree.getRoot());
        System.out.println("");

        System.out.println("Are they mirror: " + mirrorOfATree
                .checkIfTreesAreMirrorTrees(orgBinaryTree.getRoot(), binaryTree.getRoot()));

        orgBinaryTree.insert(22);
        System.out.println("After inserting 22...");
        System.out.println("Are they mirror: " + mirrorOfATree
                .checkIfTreesAreMirrorTrees(orgBinaryTree.getRoot(), binaryTree.getRoot()));
    }
}
