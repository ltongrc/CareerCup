/*
Question:
Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, 
write a method to rotate the image by 90 degrees. Can you do this in place?
*/

//test
public class Test{
  public static void main(String args[]) throws IOException{
	Solution s=new Solution();
	//assign a N*N matrix to org[][]
	int[][] org={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	//test and print out the result
	int[][] result=s.rotateMatrix(org);
	for(int i=0;i<result.length;i++){
		for(int j=0;j<result[0].length;j++){
			System.out.print(result[i][j]+"\t");
		}
		System.out.println();
	}
  }
}

//solution
class Solution {
	public int[][] rotateMatrix(int[][] org){
		int len=org.length;
		int[][] result=new int[len][len];
		//90 degree rotate means result[j][N-i-1]=orgin[i][j]
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				result[j][len-i-1]=org[i][j];
			}
		}
		return result;
	}
}