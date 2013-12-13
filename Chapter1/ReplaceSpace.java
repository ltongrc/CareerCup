import java.io.*;
public class ReplaceSpace{
    public static String replace(String s){
        int count = 0;
        int len = s.length();
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == ' ')
                count ++;
        }
        char[] res = new char[len+count*2];
        int index = 0;
        for(int i = 0; i < len; i++){
            char temp = s.charAt(i);
            if(temp != ' '){
                res[index++] = temp;
            } else {
                res[index++] = '%';
                res[index++] = '2';
                res[index++] = '0';
            }
        }
        return new String(res);
    } 
    
    public static void main(String[] args) throws IOException{
        System.out.println("Please enter a string:");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=null;
        str=br.readLine();
        br.close();
        System.out.println("The replaced string is: " + replace(str));
    }
}
