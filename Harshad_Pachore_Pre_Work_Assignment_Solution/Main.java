import java.util.*;
// Check for palindrome number

public class Main {
    
    public static void main(String[] args) {

        Main  main = new Main ();
        int choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter your choice from below list.\n" + "1. Find palindrome of number.\n"
            + "2. Print Pattern for a given no.\n" + "3. Check whether the no is a  prime number.\n"
            + "4. Print Fibonacci series.\n" + "--> Enter 0 to Exit.\n");

            System.out.println();
            choice= sc.nextInt();
            System.out.println();

            switch(choice){

                case 0: choice = 0;
                        break;

                case 1: 
                        System.out.print("Input : ");
                        if(main.checkPalindrome(sc.nextInt())){
                            System.out.println("\nPalindrome number");
                        }else{
                            System.out.println("\nNot a Palindrome number");
                        }
                        System.out.println();
                        break;

                case 2: System.out.print("Input : ");
                        main.printPattern(sc.nextInt());
                        break;

                case 3: System.out.print("Input : ");
                        if(main.checkPrimeNumber(sc.nextInt())){
                            System.out.println("\nPrime number");
                        }else{
                            System.out.println("\nNot a Prime number");
                        }
                        System.out.println();
                        break;
                
                case 4: System.out.print("Input : ");
                        main.printFibonacciSeries(sc.nextInt());
                        break;
            }
            
        }while (choice != 0);

        System.out.println("Exited Successfully!!!");
        sc.close();

    }

     //function to checkPalindrome

    public Boolean checkPalindrome(int num){
    
        int givenNum,temp,reminder;
        givenNum = num;
        temp = 0;

        while(num > 0){
            reminder = num % 10;
            temp = (temp * 10) + reminder;
            num = num/10;
        }

        return temp == givenNum;
    }

    //function to printPattern

    public void printPattern(int num) {
        System.out.println();
        for(int i = num; i>=0; i--) {
            for(int j = 0; j<i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //function to check no is prime or not

    public Boolean checkPrimeNumber(int num) {
        Boolean check = false;
        if(num != 1 || num != 0){
            for(int i = 2; i <= num / 2; i++) {
                if(num % i == 0){
                    check = true;
                    break;
                }
            }
        }
        return !check;
    }

    public void printFibonacciSeries(int num){
        System.out.println();
        
        int temp;
        int prev = 0;
        int currentNum = 1;
        System.out.print(prev+" "+currentNum);
        while(true){
           
           temp = currentNum;
           currentNum = currentNum + prev; 
           prev = temp;
           
           if(currentNum > num){
             break;
           }else{
            System.out.print(" "+currentNum);
           }
        }
        System.out.println();
        System.out.println();
    }
}