import java.util.Scanner;

public class ATMSimulator {

    /**
     * @param args
     */
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        double currentBalance =00.00;
        boolean check= true;

        while (check) {
            System.out.println("\nWelcome to the Simple Console ATM!");
            System.out.println("Please select an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Exit");

            int choice=sc.nextInt();

            switch (choice) {
                case 1:
                System.out.println("Cureent balance is "+currentBalance+"BDT");
                    
                    break;
                case 2:
                System.out.println("Enter amount of deposite:");
                double deposite=sc.nextDouble();
                
                if(deposite<=0)
                {
                    System.out.println("Invalid amount.");
                }
                else
                {
                    currentBalance+=deposite;
                    System.out.println("Succesfully depostite "+deposite+"BDT");
                    System.out.println("Your balance is now: "+currentBalance+"BDT"  );
                }
                
                break;

                case 3:
                System.out.println("Enter the ammount of withdraw:");
                double withdraw=sc.nextDouble();

                if (withdraw<0) {
                    System.out.println("Withdraw must be greater then zero BDT");
                    }
                else if(withdraw>100)
                {
                    System.out.println("you can not withdraw greater then 100 BDT.");
                }    
                else if(withdraw>currentBalance)
                {
                    System.out.println("Insiuffient Balance.Your Current Balance is: "+currentBalance +"BDT");
                }
                else
                {
                    currentBalance-=withdraw;
                    System.out.println("Succesfully withdraw: "+withdraw+"BDT");
                }

                break;

                case 4:
                System.out.println("Thank you for using the ATM! Goodbye");
                check=false;

                break;

                default:
                System.out.println("Invalid option! Please select a valid choice.");
                    break;
            }

        }
    
    }
}