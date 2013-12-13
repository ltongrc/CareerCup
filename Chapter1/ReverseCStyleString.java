import java.io.*;

public class ReverseCStyleString{
    public static String reverse(String s){
        char[] input = s.toCharArray();
        for(int i=0, j=input.length-1; i<j; i++, j--){
            // in-place swap
            char temp = input[i];
            input[i] = input[j];
            input[j] = temp; 
        }
        return new String(input);
    }

    public static void main(String[] args) throws IOException{
        System.out.println("Please enter a string:");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=null;
        str=br.readLine();
        br.close();
        System.out.println("The reverse string is: " + reverse(str));
    }
}
