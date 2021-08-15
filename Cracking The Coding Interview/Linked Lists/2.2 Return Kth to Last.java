/**
 * 2.2 Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 */

class KthToLast{
    public static void main(String[] args){
        Node head = new Node(1);
        Node.insertData(head, 2);
        Node.insertData(head, 3);
        Node.insertData(head, 4);
        Node.insertData(head, 5);
        Node.insertData(head, 6);
        Node.printLinkedList(head);
        System.out.println(findKthToLast(head, 6));
    }

    /**
     * Solution: Using 2 pointers with difference of K
     * Assumption: LinkedList should at least have K elements
     */
    static int findKthToLast(Node head, int k){
        Node current = head;
        for(int i=1;i<k;i++){
            if(current.next==null) return -1;
            current = current.next;
        }

        Node kth = head;
        while(current.next!=null){
            current = current.next;
            kth = kth.next;
        }

        return kth.data;
    }
}

/**
 * 1 -> 2 -> 3
 */