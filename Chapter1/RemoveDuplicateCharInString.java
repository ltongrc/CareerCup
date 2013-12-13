import java.util.HashMap;
public class RemoveDuplicateCharInString{
    public static String remove(String s){
       if(s == null || s.length() == 1)
            return s;
        int[] charSet = new int[256];
        for(int i=0; i < s.length(); i++){
            int index = (int)s.charAt(i);
            charSet[index]++;
        }

        String result = "";
        for(int i = 0; i < charSet.length; i++){
            if(charSet[i]!=0){
                result += (char)i;
            }
        }
        return result;
    }   

    public static char[] removeAns(char[] str){
        if(str == null || str.length == 1)
            return str;
        boolean[] hit = new boolean[256];
        hit[str[0]] = true;
        int tail = 1;
        for(int i = 1; i < str.length; i++){
            if(!hit[str[i]]){
                str[tail] = str[i];
                hit[str[tail]] = true;
                tail++;
            }
        }
        if(tail == str.length)
            return str;
        else{
            char res[] = new char[tail]; 
            for( int i = 0 ; i < tail; i++){
                res[i] = str[i];
            }
            return res;
        }
    }
    public static void main(String args[]){
        String[] test = {"aaaa", "ababa", "abcd"};
        for(String s : test){
            System.out.println( s + "  " + remove(s));
        }
        for(String s : test){
            char[] temp = s.toCharArray();
            System.out.println( s + " : " + new String(removeAns(temp)));
        }

    }
}
