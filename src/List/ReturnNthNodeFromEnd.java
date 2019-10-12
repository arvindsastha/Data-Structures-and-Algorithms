package src.List;

import src.DataStructureUtils;

public class ReturnNthNodeFromEnd {

    private CustomLinkedList returnNthNodeUsingTwoPointers(CustomLinkedList head, int n) {
        CustomLinkedList end = head;
        CustomLinkedList nthNode = head;

        int i = 1;
        while(i < n && end != null) {
            end = end.getNextNode();
            i++;
        }

        if(end == null) {
            System.out.println("N is greater than the size of the list");
            return null;
        }

        while(end.getNextNode() != null) {
            end = end.getNextNode();
            nthNode = nthNode.getNextNode();
        }

        return nthNode;
    }

    private CustomLinkedList returnNthNodeUsingLength(CustomLinkedList head, int n) {
        CustomLinkedList headCopy = head;
        CustomLinkedList nthNode = head;

        int length = 0;
        while(headCopy != null) {
            length++;
            headCopy = headCopy.getNextNode();
        }

        if(n > length) {
            System.out.println("N is greater than the size of the list");
            return null;
        }

        int i=1;
        while(i != (length - n + 1) && nthNode != null) {
            nthNode = nthNode.getNextNode();
            i++;
        }

        return nthNode;
    }

    public static void main(String[] args) {
        ReturnNthNodeFromEnd returnNthNodeFromEnd = new ReturnNthNodeFromEnd();
        CustomLinkedList customLinkedList = DataStructureUtils.createLinkedList();

        DataStructureUtils.printList(customLinkedList.getHeadNode());

        System.out.println("4th node from the end: "
                + DataStructureUtils.printNodeValue(returnNthNodeFromEnd
                .returnNthNodeUsingLength(customLinkedList.getHeadNode(), 4)));

        System.out.println("4th node from the end: "
                + DataStructureUtils.printNodeValue(returnNthNodeFromEnd
                .returnNthNodeUsingTwoPointers(customLinkedList.getHeadNode(), 4)));
    }
}
