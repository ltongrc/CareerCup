import java.util.ArrayList;
public class MyHashTable<Key, Value>{
    private static final int INIT_CAPACITY = 4;
    private int N;  // number of key-value pairs
    private int M;  // hash table size
    private MySequentialSearch<Key,Value>[] st; // array of linked-list symbol tables
    
    public MyHashTable(){
        this(INIT_CAPACITY);
    }
    
    public MyHashTable(int M){
        this.M = M;
        st = (MySequentialSearch<Key, Value>[])new MySequentialSearch[M];
        for(int i = 0; i < M; i++){
            st[i] = new MySequentialSearch<Key,Value>(); 
        }
    }

    private void resize(int chains) {
        MyHashTable<Key, Value> temp = new MyHashTable<Key, Value>(chains);
        for(int i = 0; i < M; i++){
            for(Key key : st[i].keys()){
                temp.put(key, st[i].get(key));
            }
        }
        this.M = temp.M;
        this.N = temp.N;
        this.st = temp.st;
    }

    // 0x7fffffff is all 1 except the sign bit
    // hash & 0x7fffffff will force the sign bit to 0, 
    // result in a positive integer
    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public Value get(Key key){
        int i = hash(key);
        return st[i].get(key);
    }

    public void put(Key key, Value val){
        if(val == null ) { delete(key); return; }

        //** double table size if average length of list >= 10
        if( N >= 10*M) resize(2*M);

        int i = hash(key);
        if(!st[i].contains(key)) N++;
        st[i].put(key,val);
    }

    public void delete(Key key){
        int i = hash(key);
        if (st[i].contains(key)) N--;
        st[i].delete(key);

        //** halve table size if average length of list <= 2
        if(M > INIT_CAPACITY && N <= 2*M ) resize(M/2);
    }

    public Iterable<Key> keys(){
        ArrayList<Key> queue = new ArrayList<Key>();
        for(int i = 0; i < M; i++){
            for(Key key: st[i].keys()){
                queue.add(key);
            }
        }
        return queue;
    }

    public static void main(String args[]){
        MyHashTable<String, Integer> ht = new MyHashTable<String,Integer>();
        String[] string = {"cup","bag","no","work","hard","yes","what?","hash","yes"};
        int[] integer = { 33, 8, 90, 20, 4, 21, 9, 22, 0};
        for(int i = 0; i < string.length; i++){
            ht.put(string[i],integer[i]);
        }

        for(String s: ht.keys()){
            System.out.println( s + " " + ht.get(s));
        }
    }
}
    
