package ExceptionHandling;

import java.util.Scanner;
public class Reciprocal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try{
            System.out.println("enther an integer");
            int num = input.nextInt();
            if(num==0){
                throw new ArithmeticException("divide by zero");
            }
            double reciprocal = 1.0/num;
            System.out.println("the reciprocal of " + num + " is " + reciprocal);
        }catch(ArithmeticException e) {
            System.out.println("cannot divide by zero");
        }catch(Exception e){
            System.out.println("invalid input");
        }
    }
}
