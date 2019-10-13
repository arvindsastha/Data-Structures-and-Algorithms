package src.Tree;

import src.DataStructureUtils;

public class BinaryTreeHeight {

    private int heightOfTheTree = 0;

    private void findHeight(BinaryTreeNode root, int height) {
        if(root == null) {
            if(height > heightOfTheTree) {
                heightOfTheTree = height;
            }
            return;
        }

        findHeight(root.getLeft(), height + 1);
        findHeight(root.getRight(), height + 1);
    }

    private int getHeightOfTheTree() {
        return this.heightOfTheTree;
    }

    public static void main(String[] args) {
        BinaryTreeHeight binaryTreeHeight = new BinaryTreeHeight();
        BinaryTree binaryTree = DataStructureUtils.createBinaryTree();
        binaryTree.insert(21);

        binaryTreeHeight.findHeight(binaryTree.getRoot(), 0);
        System.out.println("Height of the tree: " + binaryTreeHeight.heightOfTheTree);
    }
}
