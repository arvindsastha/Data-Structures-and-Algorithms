package src.Tree;

public class BinaryTreeNode {
    private int value;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void updateLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public void updateRight(BinaryTreeNode right) {
        this.right = right;
    }

    public void updateValue(int value) {
        this.value = value;
    }
}
