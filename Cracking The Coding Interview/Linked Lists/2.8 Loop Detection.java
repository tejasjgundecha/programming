/**
 * 2.8 Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the beginning of
 * the loop. DEFINITION Circular linked list: A (corrupt) linked list in which a node's next pointer points to an
 * earlier node, so as to make a loop in the linked list.
 */

class LoopDetectionAndRemoval {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node.insertData(head, 2);
        Node c = new Node(3);
        Node.insertNode(head, c);
        Node.insertData(head, 4);
        Node.insertData(head, 5);
        Node.insertNode(head, c);

        Node loop = detectLoop(head);
        if (loop != null) {
            System.out.println("Common Node: " + loop.data);
            removeLoop(head, loop);
            Node.printLinkedList(head);
        }

    }

    static Node detectLoop(Node head) {

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow != null && slow.equals(fast)) {
                return slow;
            }
        }

        return null;
    }

    // moving both pointers with same speed and finding intersection
    static void removeLoop(Node head, Node ptr2) {
        if (head != ptr2) {
            while (head.next != ptr2.next) {
                head = head.next;
                ptr2 = ptr2.next;
            }
            System.out.println("Loop found at node: " + ptr2.next.data);
            ptr2.next = null;
        } else {
            System.out.println("Loop found at node: " + head.data);
            while (ptr2.next != head) {
                ptr2 = ptr2.next;
            }
            ptr2.next = null;
        }
    }
}
//Solution 2: Find the length of loop. Keep 1 ptr at head and 2nd at kth pos from head. Move both with same speed and find intersection
/**
 * 1 - 2 - 3 - 4 \   / 5
 */