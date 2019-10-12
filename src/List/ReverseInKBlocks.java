package src.List;

import src.DataStructureUtils;

public class ReverseInKBlocks {

    private CustomLinkedList reverseInKOrder(CustomLinkedList head, int k) {
        if(head == null || head.getNextNode() == null) {
            return head;
        }

        CustomLinkedList previous ;
        CustomLinkedList next;
        CustomLinkedList currentCopy;
        CustomLinkedList current = head;
        CustomLinkedList tailOfReversedList = null;
        CustomLinkedList updatedHead = null;

        while(current != null) {
            int i = 0;
            previous = null;
            currentCopy = current;

            while(current != null && ++i <= k) {
                next = current.getNextNode();
                current.updateNextNode(previous);
                previous = current;
                current = next;
            }

            if(updatedHead == null) {
                updatedHead = previous;
            }

            if(tailOfReversedList != null) {
                tailOfReversedList.updateNextNode(previous);
            }

            tailOfReversedList = currentCopy;
        }

        return updatedHead;
    }

    public static void main(String[] args) {
        ReverseInKBlocks reverseInKBlocks = new ReverseInKBlocks();
        CustomLinkedList customLinkedList = DataStructureUtils.createLinkedList();
        customLinkedList.add(8);

        DataStructureUtils.printList(customLinkedList.getHeadNode());

        System.out.println("After reversing...");
        DataStructureUtils.printList(reverseInKBlocks.reverseInKOrder(customLinkedList.getHeadNode(), 3));
    }
}
