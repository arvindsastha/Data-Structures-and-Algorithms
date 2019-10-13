package src.Tree;

import src.DataStructureUtils;

import java.util.Stack;

public class PrintTreeInSpiral {

    private void printInSpiralOrder(BinaryTree tree) {
        int stackIndicator = 1;

        Stack<BinaryTreeNode> leftOrderStack = new Stack<>();
        Stack<BinaryTreeNode> rightOrderStack = new Stack<>();

        leftOrderStack.push(tree.getRoot());

        while (!leftOrderStack.isEmpty() || !rightOrderStack.isEmpty()) {

            BinaryTreeNode temp;

            if (stackIndicator == 1) {
                temp = leftOrderStack.pop();
                System.out.print(temp.getValue() + " ");
                if(temp.getLeft() != null) {
                    rightOrderStack.push(temp.getLeft());
                }

                if(temp.getLeft() != null) {
                    rightOrderStack.push(temp.getRight());
                }
            } else {
                temp = rightOrderStack.pop();
                System.out.print(temp.getValue() + " ");

                if(temp.getRight() != null) {
                    leftOrderStack.push(temp.getRight());
                }

                if(temp.getLeft() != null) {
                    leftOrderStack.push(temp.getLeft());
                }
            }

            if (leftOrderStack.isEmpty()) {
                stackIndicator = -1;
            } else if (rightOrderStack.isEmpty()) {
                stackIndicator = 1;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = DataStructureUtils.createBinaryTree();
        binaryTree.insert(65);
        binaryTree.insert(70);

        PrintTreeInSpiral printTreeInSpiral = new PrintTreeInSpiral();
        printTreeInSpiral.printInSpiralOrder(binaryTree);
    }
}
