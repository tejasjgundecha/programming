/**
 * 2.7 Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting
 * node. Note that the intersection is defined based on reference, not value. That is, if the kth node of the first
 * linked list is the exact same node (by reference) as the jth node of the second linked list, then they are
 * intersecting.
 */

class Intersection {

    public static void main(String[] args) {
        Node list1 = new Node(3);
        Node.insertData(list1, 1);
        Node.insertData(list1, 5);
        Node.insertData(list1, 9);

        Node list2 = new Node(4);
        Node.insertData(list2, 6);

        Node common = new Node(7);
        Node.insertData(common, 2);
        Node.insertData(common, 1);

        Node.insertNode(list1, common);
        Node.insertNode(list2, common);

        System.out.println(findIntersection(list1, list2));

    }

    static Node findIntersection(Node l1, Node l2) {
        int len1 = Node.len(l1);
        int len2 = Node.len(l2);

        if (len1 > len2) {
            l1 = Node.traverse(l1, len1 - len2);
        } else {
            l2 = Node.traverse(l2, len2 - len1);
        }

        while (l1 != null) {
            if (l1.equals(l2)) {
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return null;
    }
}

//Solution 2: Use set to find intersection by traversing list.