public class FindMinInRotatedSortedArray{
    public int find(int[] num){
        return binarySearch(num, 0, num.length-1); 
    }

    public int binarySearch(int[] num, int start, int end){
        if(start == end){ 
            if(num[start]<num[0])
                return start;
            else
                return -1;
        }
        int mid = (start + end) / 2;
        // We have to compare the mid with the first element in the array
        // If mid is larger than first element, 
        // then the left side does not contain the reset point
        if(num[mid]>num[0]){
            return binarySearch(num, mid+1, end);
        } else{
            return binarySearch(num, start, mid);
        }
    }

    public static void main(String args[]){
        int[] test1 = {3,4,5,6,7};
        int[] test2 = {7,8,9,10,11,1,2,3,4,5};
        FindMinInRotatedSortedArray testObj = new FindMinInRotatedSortedArray();
        System.out.println(testObj.find(test1));         
        System.out.println(testObj.find(test2));
    }
}
