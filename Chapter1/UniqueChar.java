import java.io.*;
 
public class UniqueChar{
    public static boolean judgeUnique(String s){
        // character set in ASCII is 256
        boolean[] test = new boolean[256];
        for(int i = 0; i < s.length(); i++ ){
            int index = (int)s.charAt(i);
            if(test[index])
                return false;
            test[index] = true;
        }
        return true; 
    } 
    public static void main(String args[]) throws IOException{
        System.out.println("Please enter a string:");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=null;
        str=br.readLine();
        br.close();
        System.out.println("This string has unique char: "+judgeUnique(str)); 
  }
}
