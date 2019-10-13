package src.Tree;

import src.DataStructureUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathsWithSums {

    private int countNumberOfPaths(BinaryTreeNode root, int givenSum) {
        if(root == null) {
            return 0;
        }

        int countOfPaths = 0;

        int currentIndexOfQueue = 0;
        List<BinaryTreeNode> levelOrder = new ArrayList<>();
        levelOrder.add(root);

        while(currentIndexOfQueue < levelOrder.size()) {
            BinaryTreeNode temp = levelOrder.get(currentIndexOfQueue);

            if(temp.getLeft() != null) {
                levelOrder.add(temp.getLeft());
            }

            if(temp.getRight() != null) {
                levelOrder.add(temp.getRight());
            }

            currentIndexOfQueue++;
        }

        for(BinaryTreeNode node: levelOrder) {
            countOfPaths += findNumberOfPaths(node, 0, givenSum, 0);
        }

        return countOfPaths;
    }

    private int findNumberOfPaths(BinaryTreeNode root, int currentSum, int givenSum, int count) {
        if(root == null) {
            return 0;
        }

        currentSum += root.getValue();
        if(currentSum == givenSum) {
            return count + 1;
        }

        return findNumberOfPaths(root.getLeft(), currentSum, givenSum, count) +
                findNumberOfPaths(root.getRight(), currentSum, givenSum, count);
    }

    public static void main(String[] args) {
        PathsWithSums pathsWithSums = new PathsWithSums();
        BinaryTree binaryTree = DataStructureUtils.createBinaryTree();
        binaryTree.insert(5);

        System.out.println("Number of paths with sum 14: "
                + pathsWithSums.countNumberOfPaths(binaryTree.getRoot(), 14));

        System.out.println("Number of paths with sum 12: "
                + pathsWithSums.countNumberOfPaths(binaryTree.getRoot(), 12));

        System.out.println("Number of paths with sum 15: "
                + pathsWithSums.countNumberOfPaths(binaryTree.getRoot(), 15));

        System.out.println("Number of paths with sum 8: "
                + pathsWithSums.countNumberOfPaths(binaryTree.getRoot(), 8));

        System.out.println("Number of paths with sum 7: "
                + pathsWithSums.countNumberOfPaths(binaryTree.getRoot(), 7 ));
    }
}
