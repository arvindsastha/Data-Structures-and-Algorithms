package src.Tree;

import src.DataStructureUtils;

public class CountLeafNodes {

    private int numberOfLeafNodes = 0;

    private void countLeafNodes(BinaryTreeNode root) {
        if(root.getLeft() == null && root.getRight() == null) {
            numberOfLeafNodes++;
            return;
        }

        countLeafNodes(root.getLeft());
        countLeafNodes(root.getRight());
    }

    public int getNumberOfLeafNodes() {
        return this.numberOfLeafNodes;
    }

    public static void main(String[] args) {
        CountLeafNodes countLeafNodes = new CountLeafNodes();
        BinaryTree binaryTree = DataStructureUtils.createBinaryTree();
        binaryTree.insert(22);
        binaryTree.insert(23);

        countLeafNodes.countLeafNodes(binaryTree.getRoot());
        System.out.println("Leaf node count: " + countLeafNodes.numberOfLeafNodes);
    }
}
