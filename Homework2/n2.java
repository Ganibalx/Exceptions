package Homework2;

public class n2 {
    public static void main(String[] args) {
        int [] intArray = {1, 2, 3, 4, 5};
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        }catch (Exception e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
