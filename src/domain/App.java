package domain;

import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        App app=new App();

        ArrayList<String> arr=new ArrayList<>();
        ArrayList<String> arr2=new ArrayList<>();
        Random random=new Random();
        int number=random.nextInt(100);
        System.out.println("Случайное число переводиться в двоичную систему, " +
                "затем последний элемент становится первым,а все число сдвигается вправо,\n" +
                "так до тех пор пока последний элемент вновь не станет последним. Затем найти максимальное число,получившееся во время сдвигов");
        System.out.println("number:" +number);
        String str="";
        str=app.perevodDv(number);
        for(int i=0;i<=str.length();i++){
            arr.add(app.perevodDes(str)+" : "+ str);
            arr2.add(app.perevodDes(str));
            str=app.zamena(str);
        }
        for(String i:arr){
            System.out.println(i);
        }
        int max=-1;
        for(String i:arr2){
            if(Integer.parseInt(i)>max)
                max=Integer.parseInt(i);
        }
        System.out.println("max: "+ max);
    }
    public String perevodDv(int a){
        int count=2;
        String dvn="";
        while(a>=1){
            dvn=dvn+""+(a-a/count*count);
            a=a/count;
        }
        String reversedString = new StringBuffer(dvn).reverse().toString();
        return reversedString;
    }

    public String perevodDes(String s){
        int size=s.length()-1;
        int n=0;
        String[] str=s.split("");
        for(int j=0;j<str.length;j++){
            if(size>=0){
                n=n+Integer.parseInt(str[j])*(int)Math.pow(2,size);
                size--;
            }
        }

        return Integer.toString(n);
    }
    public String zamena(String s){
        String[] str=s.split("");
        int z=str.length;
        String newS="";
        newS=newS+str[z-1];
        for(int i=0;i<z-1;i++){
            newS=newS+str[i];
        }
        return newS;
    }


}

