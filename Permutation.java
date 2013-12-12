import java.util.ArrayList;
public class Permutation{
    ArrayList<ArrayList<Character>> permute(char[] input){
        return permute(input, input.length); 
    }
    ArrayList<ArrayList<Character>> permute(char[] input, int num){
        ArrayList<ArrayList<Character>> result = new ArrayList<ArrayList<Character>> ();
        if(input.length == 0 || input == null)
            return result;
        if( num == 1 ){
            ArrayList<Character> temp = new ArrayList<Character>();
            temp.add(input[0]);
            result.add(temp);
            return result;
        } else {
            ArrayList<ArrayList<Character>> before = permute(input,num-1);
            for(ArrayList<Character> single: before){
                for(int i=0; i<=single.size(); i++){
                    // This line indicate how to copy a arraylist to another
                    ArrayList<Character> temp = new ArrayList<Character>(single);
                    temp.add(i,input[num-1]);
                    result.add(temp);
                }
            }
            return result;  
        }
    }
    public static void main(String args[]){
        char[] test = {'a','b','e','f'};
        Permutation testObj = new Permutation();
        for(ArrayList<Character> temp: testObj.permute(test)){
            for(Character c : temp){
                System.out.print(c);
            }
            System.out.println();
        }
    }

}
