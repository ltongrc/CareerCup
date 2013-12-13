public class Anagram{
    public static boolean judge(String s1, String s2){
        if(s1 == null && s2 == null)
            return true;
        else if( s1 == null || s2==null)
            return false;
        if(s1.length() != s2.length())
            return false;
        
        char[] ch1 = countChar(s1);
        char[] ch2 = countChar(s2);
        for(int i = 0; i < ch1.length; i++){
            if(ch1[i]!=ch2[i])
                return false;
        }
        return true;
    }

    public static char[] countChar(String s){
        char[] res = new char[256];
        for(int i = 0; i < s.length(); i++){
            int index = (int) s.charAt(i);
            res[index]++;
        }
        return res;
    }

    public static void main(String args[]){
        String test1 = "one";
        String test2 = "eon";
        String test3 = "hell"; 
        System.out.println(judge(test1,test2));
        System.out.println(judge(test2,test3));
    }
}
