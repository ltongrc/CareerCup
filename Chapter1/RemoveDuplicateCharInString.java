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

    public static void main(String args[]){
        String[] test = {"aaaa", "ababa", "abcd"};
        for(String s : test){
            System.out.println( s + "  " + remove(s));
        }
    }
}
