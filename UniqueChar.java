import java.io.*;
 
public class UniqueChar{
  public static void main(String args[]) throws IOException{
  System.out.println("Please enter a string:");
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String str=null;
    if(br!=null){
    	str=br.readLine();
    }
    int flag=0;//flag 0 stands for all characters are unique, and 1 stands for there are repeated characters
    for(int i=0,str_len=str.length();i<str_len;i++){
      char temp=str.charAt(i);
      for(int j=i+1;j<str_len;j++){
        if(temp==str.charAt(j)){
          flag=1;
          break;
        }
      }
      if(flag==1){
        break;
      }
    }
    if(flag==0){
      System.out.println("The characters in string '"+str+"' are all unique");
    }
    else if(flag==1){
      System.out.println("The characters in string '"+str+"' are not unique");
    }
  }
}
