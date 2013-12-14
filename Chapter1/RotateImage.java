// Rotate the image by 90 degree
public class RotateImage{
    public static void rotate (int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < n/2 ; i++){
            // j < n-i-1 is important, because we only need to change 
            // n-1 items' positions!
            for(int j = i; j < n-i-1; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        } 
    } 
    public static void main(String[] args){
        int[][] test = {{3,1,2,5},{10,34,60,100},{32,90,102,22},{2,0,33,90}};
        printMatrix(test);
        rotate(test);
        printMatrix(test);
    }

    public static void printMatrix(int[][] m){
        int len = m.length;
        for(int i=0; i<len; i++){
            for(int j = 0; j < len; j++){
                System.out.print(" "+m[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------");
    }
}
