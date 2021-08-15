import javafx.util.Pair;
import javax.naming.OperationNotSupportedException;

/**
 * Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node,
 * not necessarily the exact middle) of a singly linked list, given only access to that node.
 * SOLUTION
 * EXAMPLE
 * lnput:the node c from the linked list a->b->c->d->e->f
 * Result: nothing is returned, but the new linked list looks like a->b->d->e->f
 */

class DeleteMiddleNode{

    public static void main(String[] args) throws OperationNotSupportedException{
        Node head = new Node(1);
        Node toBeDeleted = new Node(4);

        Node.insertData(head, 2);
        Node.insertData(head, 3);
        Node.insertNode(head, toBeDeleted);
        Node.insertData(head, 5);

        Node.printLinkedList(head);
        deleteNode(toBeDeleted);
        Node.printLinkedList(head);
    }

    //As this node is always in the middle, copying next node's data would always work
    static void deleteNode(Node node) throws OperationNotSupportedException{
        if(node.next==null){
            throw new OperationNotSupportedException("Node is not a middle node");
        }

        Node nextNode = node.next;
        node.data = nextNode.data;
        node.next = nextNode.next;
    }
}