package src.List;

import src.DataStructureUtils;

public class CustomLinkedList {
    private int value;
    private CustomLinkedList next;
    private CustomLinkedList head;

    public CustomLinkedList() {
        this.next = null;
        this.head = null;
        this.value = 0;
    }

    public CustomLinkedList getNextNode() {
        return this.next;
    }

    CustomLinkedList getHeadNode() {
        return this.head;
    }

    public int getNodeValue() {
        return this.value;
    }

    void updateNextNode(CustomLinkedList node) {
        this.next = node;
    }

    public void add(int value) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.value = value;
        customLinkedList.next = null;

        if(head == null) {
            head = customLinkedList;
        } else {
            CustomLinkedList headCopy = head;
            while(headCopy.next != null) {
                headCopy = headCopy.next;
            }

            headCopy.next = customLinkedList;
        }
    }

    void removeLastElement() {
        if(head != null) {
            CustomLinkedList headCopy = head;
            CustomLinkedList previousNode = head;

            while (headCopy.next != null) {
                previousNode = headCopy;
                headCopy = headCopy.next;
            }

            if(previousNode == headCopy) {
                head = null;
            } else {
                previousNode.next = null;
            }
        } else {
            // do nothing
            System.out.println("Empty List");
        }
    }

    void remove(int x) {
        if(head != null) {
            CustomLinkedList headCopy = head;
            CustomLinkedList previousNode = head;

            while (headCopy.value != x && headCopy.next != null) {
                previousNode = headCopy;
                headCopy = headCopy.next;
            }

            if(headCopy.value == x && headCopy.next == null) {
                previousNode.next = null;
            } else if(headCopy.value == x && headCopy == previousNode) {
                headCopy = headCopy.next;
                head = headCopy;
            } else if(headCopy.value == x) {
                previousNode.next = headCopy.next;
            }
        } else {
            // do nothing
            System.out.println("Empty List");
        }
    }

    public static void main(String[] args) {
        CustomLinkedList customLinkedList =  new CustomLinkedList();
        customLinkedList.add(1);
        customLinkedList.add(2);
        DataStructureUtils.printList(customLinkedList.getHeadNode());
        customLinkedList.removeLastElement();
        DataStructureUtils.printList(customLinkedList.getHeadNode());
        customLinkedList.add(11);
        DataStructureUtils.printList(customLinkedList.getHeadNode());
        customLinkedList.remove(1);
        DataStructureUtils.printList(customLinkedList.getHeadNode());
        customLinkedList.add(12);
        customLinkedList.add(13);
        customLinkedList.add(2);
        DataStructureUtils.printList(customLinkedList.getHeadNode());
        customLinkedList.remove(12);
        DataStructureUtils.printList(customLinkedList.getHeadNode());
        customLinkedList.removeLastElement();
        DataStructureUtils.printList(customLinkedList.getHeadNode());
        customLinkedList.removeLastElement();
        DataStructureUtils.printList(customLinkedList.getHeadNode());
        customLinkedList.removeLastElement();
        customLinkedList.removeLastElement();
    }
}
