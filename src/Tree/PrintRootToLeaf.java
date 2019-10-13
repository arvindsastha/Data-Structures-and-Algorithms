package src.Tree;

import src.DataStructureUtils;

public class PrintRootToLeaf {

    private void printRootToLeaf(BinaryTreeNode root, String path) {
        if(root.getLeft() == null && root.getRight() == null) {
            System.out.println(path + " " + root.getValue());
            return;
        }

        path = path + " " + root.getValue();
        printRootToLeaf(root.getLeft(), path);
        printRootToLeaf(root.getRight(), path);
    }

    public static void main(String[] args) {
        PrintRootToLeaf printRootToLeaf = new PrintRootToLeaf();
        BinaryTree binaryTree = DataStructureUtils.createBinaryTree();

        printRootToLeaf.printRootToLeaf(binaryTree.getRoot(), "");
    }
}
