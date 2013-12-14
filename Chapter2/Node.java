public class Node{
    int data;
    Node next = null;
        
    public Node(int data){
        this.data = data;
    }

    public String toString(){
        String res = "";
        Node n = this;
        while(n!=null){
            res += n.data+" -> ";
            n = n.next;
        }
        res += "null";
        return res;
    }

    public static Node testCase(){
        int[] test = {44, 23, 12, 23, 0, 29, 12, 20};
        Node head = new Node(test[0]);
        Node it = head;
        for(int i=1; i<test.length; i++){
            it.next = new Node(test[i]);
            it = it.next;
        }
        return head; 
    }
}
