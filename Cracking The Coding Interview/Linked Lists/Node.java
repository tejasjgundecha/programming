import java.util.Objects;

public class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public static Node insertData(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
        return head;
    }

    public static Node insertNode(Node head, Node node) {
        if (head == null) {
            return node;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        return head;
    }

    public static Node inserBefore(Node head, Node node) {
        if (head == null) {
            return node;
        }
        node.next = head;
        return node;
    }

    public static Node padList(Node head, int times, int paddingValue) {
        for (int i = 0; i < times; i++) {
            head = inserBefore(head, paddingValue);
        }
        return head;
    }

    public static int len(Node node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public static Node inserBefore(Node head, int value) {
        Node node = new Node(value);
        if (head == null) {
            return node;
        }
        node.next = head;
        return node;
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node traverse(Node node, int n) {
        while (n != 0) {
            if (node == null) {
                System.out.println("List cannot be traversed fully.");
                return node;
            }
            node = node.next;
            n--;
        }

        return node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return data == node.data && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + ", next=" + next + '}';
    }
}
