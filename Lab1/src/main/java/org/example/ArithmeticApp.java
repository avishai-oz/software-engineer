package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArithmeticApp {
    public static String evalExpression(String expr, int base){
        String[] tokens = expr.split("\\s+");
        List<String> list = Arrays.asList(tokens);

        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals("*")){
                int a = Integer.parseInt(list.get(i - 1), base);
                int b = Integer.parseInt(list.get(i + 1), base);
                int res = a * b;
                list.set(i+1, Integer.toString(res, base));
                list.set(i, "sus");
                list.set(i-1, "sus");
            }
            else if(list.get(i).equals("/")) {
                int a = Integer.parseInt(list.get(i - 1), base);
                int b = Integer.parseInt(list.get(i + 1), base);
                if(b == 0){
                    throw new ArithmeticException();
                }
                int res = a / b;
                list.set(i+1, Integer.toString(res, base));
                list.set(i, "sus");
                list.set(i-1, "sus");
            }
        }
//        System.out.println(list);

        int index = 0;
        while(list.get(index).equals("sus")){
            index++;
        }
        int res = Integer.parseInt(list.get(index), base);

        for(int i=index+1; i<list.size(); i++) {
            if(list.get(i).equals("+")){
                i++;
                while(list.get(i).equals("sus")){ i++; }
                res += Integer.parseInt(list.get(i), base);
            }
            else if(list.get(i).equals("-")){
                i++;
                while(list.get(i).equals("sus")){ i++; }
                res -= Integer.parseInt(list.get(i), base);
            }else{
                throw new IllegalArgumentException();
            }
        }

        return Integer.toString(res, base).toUpperCase();
    }
    public static void main(String[] Args){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Enter base (2/8/10/16):");
            int base = input.nextInt();

            // flush
            input.nextLine();

            if(base == 2 || base == 8 || base == 10 || base == 16){
                System.out.println("Enter expression:");
                String expression = input.nextLine();
                String res = "";
                try{
                    res = evalExpression(expression, base);
                } catch (IllegalArgumentException e){
                    System.out.println("Error: invalid expression: \"\"");
                    return;
                } catch (ArithmeticException e){
                    System.out.println("Error: trying to divide by 0 (evaluated: \"0\")");
                    return;
                }
                System.out.println("The value of expression " + expression + " is : " + res);
                return;
            }
            System.out.print("Error – this base isn’t supported. ");
        }
    }
}
