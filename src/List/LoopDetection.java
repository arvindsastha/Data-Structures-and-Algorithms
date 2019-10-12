package src.List;

import src.DataStructureUtils;

import java.util.HashSet;
import java.util.Set;

public class LoopDetection {

    private boolean detectCycleUsingVisitedStatus(CustomLinkedList head) {

        if(head == null) {
            return false;
        }

        Set<CustomLinkedList> visited = new HashSet<>();
        while(head != null) {
            if(visited.contains(head)) {
                return true;
            }

            visited.add(head);
            head = head.getNextNode();
        }
        return false;
    }

    private boolean detectCycleUsingSlowAndFastPointers(CustomLinkedList head) {

        if(head == null) {
            return false;
        }

        CustomLinkedList slow = head;
        CustomLinkedList fast = head;

        slow = slow.getNextNode();
        fast = fast.getNextNode().getNextNode();

        while(slow != fast && slow != null && fast.getNextNode() != null) {
            slow = slow.getNextNode();
            fast = fast.getNextNode().getNextNode();
        }

        return slow == fast && slow != null;
    }

    public static void main(String[] args) {
        LoopDetection loopDetection = new LoopDetection();

        CustomLinkedList customLinkedList = DataStructureUtils.createLinkedList();
        customLinkedList.getHeadNode().getNextNode()
                .getNextNode().getNextNode().getNextNode()
                .getNextNode().getNextNode().updateNextNode(customLinkedList.getHeadNode());

        System.out.println("Cycle: " + loopDetection.detectCycleUsingVisitedStatus(customLinkedList.getHeadNode()));
        System.out.println("Cycle: " + loopDetection.detectCycleUsingSlowAndFastPointers(customLinkedList.getHeadNode()));

        System.out.println("Cycle: " + loopDetection.detectCycleUsingVisitedStatus(null));
        System.out.println("Cycle: " + loopDetection.detectCycleUsingSlowAndFastPointers(null));

        System.out.println("Cycle: " + loopDetection
                .detectCycleUsingVisitedStatus(DataStructureUtils.createLinkedList().getHeadNode()));
        System.out.println("Cycle: " + loopDetection
                .detectCycleUsingSlowAndFastPointers(DataStructureUtils.createLinkedList().getHeadNode()));
    }
}
