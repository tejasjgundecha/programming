/**
 * 2.5 Sum Lists: You have two numbers represented by a linked list,where each node contains a single digit. The digits
 * are stored in reverse order,such that the 1's digit is at the head of the list. Write a function that adds the two
 * numbers and returns the sum as a linked list. EXAMPLE Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295. Output:2
 * -> 1 -> 9.Thatis,912. FOLLOW UP Suppose the digits are stored in forward order. Repeat the above problem. Input: (6
 * -> 1 -> 7) + (2 -> 9 -> 5).Thatis,617 + 295. Output:9 ->1 ->2.Thatis,912.
 */

class SumList {

    public static void main(String[] args) {
        Node reverse1 = new Node(7);
        Node.insertData(reverse1, 1);
        Node.insertData(reverse1, 6);
        Node.insertData(reverse1, 3);

        Node reverse2 = new Node(5);
        Node.insertData(reverse2, 9);
        Node.insertData(reverse2, 2);

        System.out.println("\nReverse List addition:");
        Node.printLinkedList(addReverseLists(reverse1, reverse2));

        System.out.println("\nReverse List addition Recursive:");
        Node.printLinkedList(addReverseListsRecursive(reverse1, reverse2, 0, null));
        System.out.println("\nForward List addition:");
        Node.printLinkedList(addForwardLists(reverse1, reverse2));
    }

    static Node addReverseLists(Node l1, Node l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        Node sum = null, temp = null;
        int c, carry = 0;
        while (l1 != null && l2 != null) {

            c = l1.data + l2.data + carry;
            carry = c / 10;
            c = c % 10;
            if (sum == null) {
                temp = new Node(c);
                sum = temp;
            } else {
                temp.next = new Node(c);
                temp = temp.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null || l2 != null) {
            //add remaining list
            Node rem = l1 == null ? l2 : l1;
            while (rem != null) {
                c = rem.data + carry;
                carry = c / 10;
                c = c % 10;
                temp.next = new Node(c);
                temp = temp.next;
                rem = rem.next;
            }
            if (carry != 0) {
                temp.next = new Node(carry);
            }
        }

        return sum;
    }

    static Node addReverseListsRecursive(Node l1, Node l2, int carry, Node sum) {
        if (l1 == null && l2 == null && carry == 0) {
            return sum;
        }

        int data = carry;
        if (l1 != null) {
            data += l1.data;
        }
        if (l2 != null) {
            data += l2.data;
        }

        carry = data / 10;
        data = data % 10;
        sum = Node.insertData(sum, data);
        return addReverseListsRecursive(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry, sum);
    }

    static Node addForwardLists(Node l1, Node l2) {
        int len1 = Node.len(l1);
        int len2 = Node.len(l2);
        if (len1 < len2) {
            l1 = Node.padList(l1, len2 - len1, 0);
        } else {
            l2 = Node.padList(l2, len1 - len2, 0);
        }

        PartialNode sum = addForwardListsRecursive(l1, l2);
        if (sum.carry != 0) {
            Node.inserBefore(sum.node, sum.carry);
        }
        return sum.node;
    }

    private static PartialNode addForwardListsRecursive(Node l1, Node l2) {
        if (l1 == null && l2 == null) {
            return new PartialNode();
        }

        PartialNode sum = addForwardListsRecursive(l1.next, l2.next);

        int data = l1.data + l2.data + sum.carry;
        sum.carry = data / 10;
        sum.node = Node.inserBefore(sum.node, data % 10);
        return sum;
    }

    static class PartialNode {

        Node node;
        int carry = 0;
    }
}