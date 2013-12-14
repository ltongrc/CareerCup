import java.util.HashMap;
public class RemoveDuplicatesUnsortedLinkedList{
    public static void removeDuplicate(Node n){
        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
        record.put(n.data, 1);
        while(n!=null && n.next!=null){
            if(!record.containsKey(n.next.data)){
                record.put(n.next.data, 1);
                n = n.next;
            } else {
                n.next = n.next.next;
            }
        }
    }

    public static void main(String args[]){
        Node head = Node.testCase();
        System.out.println(head);
        removeDuplicate(head);
        System.out.println(head);
    }      
}
