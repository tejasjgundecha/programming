import java.util.HashSet;
import java.util.Set;

/**
 * Remove Dups! Write code to remove duplicates from an unsorted linked list. FOLLOW UP How would you solve this problem
 * if a temporary buffer is not allowed?
 */

class RemoveDups {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node.insertData(head, 2);
        Node.insertData(head, 3);
        Node.insertData(head, 2);
        Node.insertData(head, 3);
        Node.insertData(head, 3);
        Node.printLinkedList(head);
        removeDups(head);
        Node.printLinkedList(head);
    }

    // Solution 1: Using @java.util.HashSet to check duplicates >>>>> Takes extra buffer.
        static void removeDups(Node head){
            if(head==null || head.next==null) return;

            Set<Integer> unique = new HashSet<>();
            Node prev = null, curr = head;
            while(curr!=null){
                if(unique.contains(curr.data)){
                    prev.next = curr.next;
                }
                else{
                    unique.add(curr.data);
                    prev = curr;
                }
                curr = curr.next;
            }
        }

    /**
     * Solution 2: Using 2 pointers >> No extra buffer but takes O(N^2) time
     */
//    static void removeDups(Node head) {
//        if (head == null || head.next == null) {
//            return;
//        }
//        Node curr = head;
//        while (curr != null) {
//            Node runner = curr;
//            while (runner.next != null) {
//                if (runner.next.data == curr.data) {
//                    runner.next = runner.next.next;
//                } else {
//                    runner = runner.next;
//                }
//            }
//            curr = curr.next;
//        }
//    }


}