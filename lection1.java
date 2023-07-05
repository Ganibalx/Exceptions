public class lection1 {
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int min_length = 4;
        System.out.println(checkAL(arr, min_length));
    }
    
    public static int checkAL(int[] arr, int min_length){
        if (arr.length < min_length){
            return -1;
        } else {
            return arr.length;
        }    
    }
}
