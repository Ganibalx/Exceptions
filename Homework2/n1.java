package Homework2;

import java.util.InputMismatchException;
import java.util.Scanner; 

public class n1 {
    public static void main(String[] args) {
        System.out.println(getFloat());
    }

    public static float getFloat(){        
        float result = 0;
        boolean flag = true;
        while(flag){
            try{         
            System.out.println("Введите число типа float");
            Scanner sc = new Scanner(System.in);
            result = sc.nextFloat();
            flag = false;
            sc.close();
            }catch (InputMismatchException e){      
                System.out.println("Для кого написано float?");          
            }               
        }        
        return result;
    } 
}