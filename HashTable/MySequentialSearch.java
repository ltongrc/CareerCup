import java.util.ArrayList;
public class MySequentialSearch<Key, Value>{
    private int N;      // number of key-value pairs
    private Node first; // the linked list of key-value pairs

    // a helper linked list data type
    private class Node{
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public MySequentialSearch(){
    }

    public int size(){ 
        return N;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public Value get(Key key){
        for(Node x = first; x!= null; x = x.next){
            if(key.equals(x.key)) return x.val;
        }
        return null;
    }

    public void put(Key key, Value val){
        if (val == null) { delete(key); return;}
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)) { x.val = val; return; }
        first = new Node(key, val, first);
        N++;
    }

    public void delete(Key key) {
        first = delete(first, key);
    }

    public Node delete(Node x, Key key){
        if(x == null) return null;
        if(key.equals(x.key)) { N--; return x.next; }
        x.next = delete(x.next, key);
        return x;
    }

    public Iterable<Key> keys(){
        ArrayList<Key> queue = new ArrayList<Key>();
        for(Node x = first; x != null; x = x.next)
            queue.add(x.key);
        return queue;
    }

    public static void main(String[] args){
        MySequentialSearch<String, Integer> st = new MySequentialSearch<String, Integer>();
        String[] test = {"Hi","CMU","final","test","LU","ok"};
        for(int i = 0; i<test.length; i++ ){
            st.put(test[i], i);
        }
        for(String s: st.keys()){
            System.out.println( s + " " + st.get(s));
        }
    }
} 
