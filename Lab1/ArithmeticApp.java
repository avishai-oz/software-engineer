package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArithmeticApp {
    public static String evalExpression(String expr, int base){

        List<String> list = new ArrayList<>();
        expr = expr.toUpperCase();
        String charset = "0123456789ABCDEF";

        int j=0;
        for(int i=0; i<expr.length(); i++){
            char temp = expr.charAt(i);
            if (temp == '+' || temp == '-' || temp == '*' || temp == '/'){
//                System.out.println(list);
                if(i == j){
                    System.out.println("Error: invalid expression: \"\"");
                    return "-1";
                }
                String tempStr = expr.substring(j,i).trim();
                try{
                    Integer.parseInt(tempStr, base);
                }catch (NumberFormatException e) {
                    String baseCharset = charset.substring(0,base);
                    for(int index=0; index<tempStr.length(); index++){
                        if(baseCharset.indexOf(tempStr.charAt(index)) == -1){
                            System.out.println("Error: invalid expression: \"" + tempStr.charAt(index) + "\"");
                            return "-1";
                        }
                    }
                    System.out.println("Error: invalid expression: \"\"");
                    return "-1";
                }
                j = i+1;
                list.add(tempStr);
                list.add(temp + "");
            }
        }
        String tempStr = expr.substring(j).trim();
        try{
            Integer.parseInt(tempStr, base);
        }catch (NumberFormatException e) {
            String baseCharset = charset.substring(0,base);
            for(int index=0; index<tempStr.length(); index++){
                if(baseCharset.indexOf(tempStr.charAt(index)) == -1){
                    System.out.println("Error: invalid expression: \"" + tempStr.charAt(index) + "\"");
                    return "-1";
                }
            }
            System.out.println("Error: invalid expression: \"\"");
            return "-1";
        }
        list.add(tempStr);

//        System.out.println(list);

        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals("*")){
                int a = Integer.parseInt(list.get(i - 1), base);
                int b = Integer.parseInt(list.get(i + 1), base);
                int res = a * b;
                list.set(i+1, Integer.toString(res, base));
                list.set(i, "X");
                list.set(i-1, "X");
            }
            else if(list.get(i).equals("/")) {
                int a = Integer.parseInt(list.get(i - 1), base);
                int b = Integer.parseInt(list.get(i + 1), base);
                if(b == 0){
                    System.out.println("Error: trying to divide by 0 (evaluated: \"0\")");
                    return "-1";
                }
                int res = a / b;
                list.set(i+1, Integer.toString(res, base));
                list.set(i, "X");
                list.set(i-1, "X");
            }
        }
//      System.out.println(list);

        int index = 0;
        while(list.get(index).equals("X")){
            index++;
        }
        int res = Integer.parseInt(list.get(index), base);

        for(int i=index+1; i<list.size(); i++) {
            if(list.get(i).equals("+")){
                i++;
                while(list.get(i).equals("X")){ i++; }
                res += Integer.parseInt(list.get(i), base);
            }
            else if(list.get(i).equals("-")){
                i++;
                while(list.get(i).equals("X")){ i++; }
                res -= Integer.parseInt(list.get(i), base);
            }else{
                System.out.println("Error: invalid expression: \"\"");
                return "-1";
            }
        }

        return Integer.toString(res, base).toUpperCase();
    }
    public static void main(String[] Args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter base (2/8/10/16):");
        while(true){
            int base = input.nextInt();

            // flush
            input.nextLine();

            if(base == 2 || base == 8 || base == 10 || base == 16){
                System.out.println("Enter expression:");
                String expression = input.nextLine();
                String res = evalExpression(expression, base);
                if(!res.equals("-1")){
                    System.out.println("The value of expression " + expression + " is : " + res);
                }
                return;
            }
            System.out.print("Error - this base isn't supported. Please enter a base (2/8/10/16):\n");
        }
    }
}
