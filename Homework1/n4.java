package Homework1;

public class n4 {
    public static void main(String[] args) {
        int[] arr1 = {0,3,5};
        int[] arr2 = {2,4,1};
        int[] arr = razn(arr1, arr2);
    }

    public static int[] razn( int[] arr1, int[] arr2){
        if (arr1.length != arr2.length){
            throw new RuntimeException("Длинны массивов не равны");
        }
        int[] rez = new int[arr1.length];
        for (int i = 0; i < rez.length; i++){
            if(arr2[i] == 0){
                throw new RuntimeException("Деление на ноль");
            }
            rez[i] = arr1[i] - arr2[i];
        }
        return rez;
    }
}
