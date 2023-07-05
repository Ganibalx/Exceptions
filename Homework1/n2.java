package Homework1;

public class n2 {
    public static void main(String[] args) {
        String[][] arr = {{"2","1"},{"5","3"}};
        System.out.println(sum2d(arr)); 
    }

    public static int sum2d(String[][] arr){ // послать значение null, послать строку
        int sum = 0;
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<5; j++){  //будем вываливаться за длинну масива, если дилнна массива j меньше 5
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }
}
