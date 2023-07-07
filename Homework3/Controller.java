package Homework3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private List<String> data;
    private boolean flag = true;

    public Controller(){
        Scanner sc = new Scanner(System.in);
        while(this.flag){
            try {
                createValidList(sc);
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }            
        }
        parse();
        People people = new People(this.data, sc);
        write(people.toString(), people.getSurname());
        sc.close();
    }

    private void write(String string, String surname){
        try (FileWriter fw = new FileWriter(surname+".txt", true)) { 
            fw.write(string);
            fw.append('\n');            
        } catch (IOException ex) { 
            System.out.println(ex.getMessage()); 
        }
    }

    private void parse(){
        String per;
        boolean flag = false;
        for(int i = 0; i<this.data.size(); i++){
            if(flag){
                i--;
            }   
            flag = false;            
            if(this.data.get(i).equals("f")||this.data.get(i).equals("m")){
                if(i!=5 && !((this.data.get(5).equals("f")||this.data.get(5).equals("m")))){
                    per = this.data.get(i);
                    this.data.set(i, this.data.get(5));
                    this.data.set(5, per);
                    flag = true;                    
                }
            }
            if(checkNumber(this.data.get(i))){
                if(i!=4 && !(checkNumber(this.data.get(4)))){
                    per = this.data.get(i);
                    this.data.set(i, this.data.get(4));
                    this.data.set(4, per);
                    flag = true;                                             
                }
            }
            if(this.data.get(i).split("[.]").length==3){
                if(i!=3 && !(this.data.get(3).split("[.]").length==3)){
                    per = this.data.get(i);
                    this.data.set(i, this.data.get(3));
                    this.data.set(3, per);
                    flag = true;                                                 
                }
            }                         
        }
    }
    
    private boolean checkNumber(String string){
        try {
            Long.parseLong(string);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private void createValidList(Scanner sc) throws MyException{
        System.out.println("Введите: Фамилию, имя, отчество, дату рождения, номер телефона, пол. Разделяя их пробелами.");
        String[] result = sc.nextLine().split(" ");
        if (result.length!=6){
            throw new MyException("Размерность данных не верна! Повторите ввод:)");
        }else{
            this.data = Arrays.asList(result);
            this.flag = false;
        }
    }    
}
