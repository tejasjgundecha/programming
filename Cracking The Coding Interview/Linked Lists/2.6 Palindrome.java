import java.util.Stack;

/**
 * 2.6 Palindrome: Implement a function to check if a linked list is a palindrome.
 */

class Palindrome {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node.insertData(head, 2);
        Node.insertData(head, 3);
        Node.insertData(head, 3);
        Node.insertData(head, 2);
        System.out.println(isPalindromeIterative(head));
        Node.insertData(head, 1);
        System.out.println(isPalindromeIterative(head));
    }

    static boolean isPalindromeIterative(Node node) {
        if (node == null) {
            return true;
        }

        Node slow = node, fast = node;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop();
            if (top != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
//todo
//Solution2 : Reverse a list and compare both
//Solution3 : Find length. Traverse recursively till mid. Compare recursively to the both side.