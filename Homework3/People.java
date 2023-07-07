package Homework3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class People {
    private String surname = null;
    private String name = null;
    private String patronymic = null;
    private String date = null;
    private char sex = 'q';
    private Long number = 0L;
    private boolean flag = true;
        
    public People(List<String> list, Scanner sc){
        this.surname = list.get(0);
        this.name = list.get(1);
        this.patronymic = list.get(2);          
        for(int i = 3; i<6; i++){
            while(this.flag){
                try {
                    switch (i) {
                        case 3:
                            checkData(list.get(i));
                            break;                    
                        case 4:
                            checkNumber(list.get(i));
                            break;
                        case 5:
                            checkSex(list.get(i));
                    }                                    
                } catch (MyException e) {
                    System.out.println(e.getMessage());
                    list.set(i, sc.nextLine());
                }            
            }
            this.flag = true;
        }
        System.out.println(this.toString());
    }

    public String getSurname(){
        return this.surname;
    }

    private void checkSex(String data) throws MyException{        
        if (data.length()==1){        
            if (data.equals("f") || data.equals("F") || data.equals("m") || data.equals("M")){
                this.sex = data.charAt(0);
            }else{
                throw new MyException("Введите в формате 'f' или 'm'");
            }
        }else{
            throw new MyException("Введите в формате 'f' или 'm'");
        }
        this.flag = false;        
        }                        

    private void checkData (String data) throws MyException{        
        String[] prov = data.split("[.]");
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        try{
            df.parse(data);
        }catch(Exception e){            
            throw new MyException("Введите в формате 'dd.mm.yyyy'");
        }
        if (prov.length==3){        
            if (Integer.parseInt(prov[0])>0 && Integer.parseInt(prov[0])<32 && Integer.parseInt(prov[1])>0 &&
             Integer.parseInt(prov[1])<13 && Integer.parseInt(prov[2])>1920 && Integer.parseInt(prov[0])<2024){
                this.date = data;
            }else{
                throw new MyException("Введите в формате 'dd.mm.yyyy'");
            }
        }else{
            throw new MyException("Введите в формате 'dd.mm.yyyy'");
        }
        this.flag = false;        
        }
        
    private void checkNumber(String data) throws MyException{        
        try {
            if (data.length()==11){
                this.number = Long.parseLong(data);
            }else{
                throw new MyException("Введите в формате 79112345678");
            }
        }catch (Exception e) {
            throw new MyException("Введите в формате 79112345678");
        }
        this.flag=false;
    }        

    public String toString(){
        return "<"+this.surname+"><"+
        this.name+"><"+this.patronymic+
        "><"+this.date+"><"+this.number+
        "><"+this.sex+">";
    }
}
