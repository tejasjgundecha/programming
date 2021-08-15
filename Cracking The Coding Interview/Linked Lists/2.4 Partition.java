import java.util.Objects;

/**
 * 2.4
 * Partition: Write code to partition a linked list around a value x,
 * such that all nodes less than x come before all nodes greater than or equal to x.
 * If x is contained within the list the values of x only need to be after the elements less than x (see below).
 * The partition element x can appear anywhere in the "right partition";
 * it does not need to appear between the left and right partitions.
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1[partition=5]
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */

class Partition{

    public static void main(String[] args){
        Node head = new Node(3);
        Node.insertData(head, 5);
        Node.insertData(head, 8);
        Node.insertData(head, 5);
        Node.insertData(head, 10);
        Node.insertData(head, 2);
        Node.insertData(head, 1);

        Node.printLinkedList(head);
        Node newList = partition(head, 5);
        Node.printLinkedList(newList);
    }

    public  static Node partition(Node head, int partition){

        Node newList=null, temp = null, curr = head;

        while(curr!=null){
            if(curr.data<partition){
                if(Objects.isNull(newList)){
                    temp = new Node(curr.data);
                    newList = temp;
                }
                else{
                    temp.next = new Node(curr.data);
                    temp = temp.next;
                }
                if(curr.next!=null){
                    curr.data = curr.next.data;
                    curr.next = curr.next.next;
                }
                else{
                    curr.data = Integer.MAX_VALUE; //todo Delete last node in the linkedList
                }

            }
            else{
                curr = curr.next;
            }
        }
        Node.insertNode(newList, head);
        return newList;
    }
}