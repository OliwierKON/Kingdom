import java.util.InputMismatchException;
import java.util.Scanner;
public class Soldier extends People { //All notes same as in Priest.java
    public Soldier(String name) {
        super(name);
    }

    @Override
    public void giveRequest(Meters health, Meters money, Meters religion, Meters happy) {
        int randomRequest = (int) (Math.random()*3);
        switch (randomRequest){
            case 0:
                request1(health, money, religion, happy);
            case 1:
                request2(health,money,religion,happy);
            case 3: request3(health,money,religion,happy);

        }
    }
    private void request1(Meters health, Meters money, Meters religion, Meters happy){
        Scanner scan = new Scanner(System.in);
        System.out.println("The soldier, " + getName() + ", says there isn't enough resources for the army. Will you increase the budget?\n");
        System.out.println("1. Yes \n2. No\n");
        try {
            int choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("You up the military budget. \n");
                money.worthDown(10);
                happy.worthUp(5);
                health.worthUp(10);
            } else if (choice == 2) {
                System.out.println("You do not change the budget.\n");
                money.worthUp(5);
                happy.worthDown(5);
                health.worthDown(5);
            }
        } catch (InputMismatchException e) {
            System.out.println("INVALID INPUT , TRY AGAIN");
            scan.nextLine();
        }
    }
    private void request2(Meters health, Meters money, Meters religion, Meters happy){
        Scanner scan = new Scanner(System.in);
        System.out.println("The soldier, " + getName() + ",wants to strengthen the military by drafting people. Will you go through with this? \n");
        System.out.println("1. Yes \n2. No\n");
        try {
            int choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("You draft people into the military unwillingly. \n");
                health.worthUp(15);
                happy.worthDown(15);
                money.worthDown(5);
            } else if (choice == 2) {
                System.out.println("You do not draft people into the military.\n");
                money.worthUp(5);
                happy.worthUp(15);
                health.worthDown(10);
            }
        } catch (InputMismatchException e) {
            System.out.println("INVALID INPUT , TRY AGAIN");
            scan.nextLine();
        }
    }
    private void request3(Meters health, Meters money, Meters religion, Meters happy){
        Scanner scan = new Scanner(System.in);
        System.out.println("The soldier, " + getName() + ", says that criminals are everywhere and you need to watch everyone to be safe. Up the surveillance in the kingdom?\n");
        System.out.println("1. Yes \n2. No\n");
        try {
            int choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("You place a guard around every corner of the kindom.\n");
                money.worthDown(10);
                happy.worthDown(15);
                health.worthUp(25);
            } else if (choice == 2) {
                System.out.println("You do not go through with the surveillance \n");
                happy.worthUp(10);
                health.worthDown(5);
            }
        } catch (InputMismatchException e) {
            System.out.println("INVALID INPUT , TRY AGAIN");
            scan.nextLine();
        }
    }
}
