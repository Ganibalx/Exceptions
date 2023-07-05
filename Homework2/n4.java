package Homework2;

import java.util.Scanner;

public class n4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку для проверки");
        String result = sc.nextLine();
        if(result.isEmpty()){
            throw new RuntimeException("Введена пустая строка");
        }
    }
}
