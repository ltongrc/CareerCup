/*
Write a method to replace all spaces in a string with '%20'.
You may assume that the string has sufficient space at the end of the string to hold 
the additional characters, and that you are given the "true" length of the string. 
(Note: if implementing in Java, please use a character array so you can perform this 
operation in place.)

EXAMPLE
Input : "Mr John Smith    "
Output: "Mr%20John%20Smith"
*/

//test method
public class Test{
  public static void main(String args[]) throws Exception{
	Solution s=new Solution();
	System.out.println(s.replaceSpace("asdewe f e   "));
  }
}

//solution
class Solution {
	public String replaceSpace(String s){
		//firstly, trim the space in the end of the String
		String ntr = ("A" + s).trim().substring(1);
		//build up a char array
		char[] currentArray=ntr.toCharArray();
		char[] newArray;
		int spaceCount=0;
		//count the total amount of internal spaces
		for(int i=0;i<currentArray.length;i++){
			if(currentArray[i]==' '){
				spaceCount++;
			}
		}
		//build the result array based on the spaces amount
		newArray=new char[currentArray.length+spaceCount*2];

		//create the result array character by character 
		//integer i for the original array, and j for the new array
		for(int i=0,j=0;i<currentArray.length;i++,j++){
			//if current character in the original array is not space,
			//just copy
			if(currentArray[i]!=' '){
				newArray[j]=currentArray[i];
			}
			//if current character is space, 
			//then use '%20' replace space 
			else{
				newArray[j]='%';
				newArray[++j]='2';
				newArray[++j]='0';
			}
		}
		return new String(newArray);

	}
}
}