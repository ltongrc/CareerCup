public class SetZeroes{
    public static void setZero(int[][] m){
        // Use the first row and column to memorize the zeroes
        boolean rowHasZero=false, columnHasZero=false;
        int height = m.length;
        int width = m[0].length;
        for(int i=0; i < height; i++){
            if(m[i][0] == 0){
                columnHasZero = true;
                break;
            }
        }
    
        for(int j=0; j < width; j++){
            if(m[0][j] == 0 ){
                rowHasZero = true;
                break;
            }
        }

        for(int i = 1; i < height; i++){
            for(int j = 1; j < width; j++){
                if(m[i][j] == 0){
                    m[i][0] = 0;
                    m[0][j] = 0;
                }
            }
        }

        // set zeroes
        for(int i = 1; i < height; i++){
            for(int j = 0; j < width; j++){
                if(m[i][0]==0)
                    m[i][j] = 0;
            }
        }

        for(int j = 1; j< width; j++){
            for(int i = 0; i < height; i++){
                if(m[0][j]==0)
                    m[i][j] = 0;
            }
        }

        if(rowHasZero){
            for(int j = 0; j < width; j++)
                m[0][j] = 0;
        }

        if(columnHasZero){
            for(int i = 0; i < height; i++){
                m[i][0] = 0;
            }
        }
    } 
    
    public static void main(String[] args){
        int[][] test = {{3,1,2,5,8},{10,0,60,10,11},{0,90,12,22,12},{2,0,33,90,4}};      
        printMatrix(test);
        setZero(test);
        printMatrix(test);
    }

    public static void printMatrix(int[][] m){
        for(int i=0; i<m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                System.out.print(" "+m[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------");
    }

}
