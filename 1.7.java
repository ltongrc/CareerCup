/*
Question:
Write an algorithm such that if an element in an MxN matrix is 0, 
its entire row and column are set to 0.
*/
import java.util.LinkedList;

//test 
public class Test{
  public static void main(String args[]) throws Exception{
	Solution s=new Solution();
	int[][] org={{1,0,3,4},{5,6,7,8},{1,10,0,12},{13,14,15,16}};
	int[][] result=s.setZero(org);
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
	//set all the zeros in the original matrix
	public int[][] setZero(int[][] org){
		int m=org.length, n=org[0].length;
		int[][] result=new int[m][n];
		//state a linkedlist to store zeros of column
		LinkedList<Integer> col=new LinkedList<Integer>();
		//traverse the whole matrix, 
		//and store the zero information
		for(int i=0;i<m;i++){
			boolean row=false;
			for(int j=0;j<n;j++){
				if(org[i][j]==0){
					col.add(j);
					row=true;
				}
			}
			//if the indicator shows there is a zero in the row
			//set all the element in the row as zero
			if(row){
				for(int j=0;j<n;j++){
					result[i][j]=0;
				}
			}
			//otherwise, store the original matrix row in the result
			else{
				for(int j=0;j<n;j++){
					result[i][j]=org[i][j];
				}
			}
		}

		//read the linkedlist, set all the column who contains zero to zeros
		for(int i=0;i<col.size();i++){
			for(int j=0;j<m;j++){
				int k=col.get(i);
				result[j][k]=0;
			}
		}
		return result;
	}
}