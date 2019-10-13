package src.Tree;

public class PrintPossibleArraysForBST {

    private void printAllPossibleArrays(BinaryTreeNode root) {
        if(root == null) {
            return;
        }

        System.out.println("Possible Arrays..");

        if(root.getLeft() == null && root.getRight() == null) {
            System.out.println(root.getValue());
            return;
        }

        printAllArrays(root);
    }

    private void printAllArrays(BinaryTreeNode root) {
        if(root == null) {
            return;
        }


    }
}
