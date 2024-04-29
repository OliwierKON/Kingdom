import java.util.InputMismatchException;
import java.util.Scanner;
public class Farmer extends People { //All notes same as in Priest.java
    public Farmer(String name) {
        super(name);
    }

    @Override
    public void giveRequest(Meters health, Meters money, Meters religion, Meters happy) {
        int randomRequest = (int) (Math.random()*3);
        if (randomRequest == 0){
            request1(health, money, religion, happy);
        } else if (randomRequest == 1) {
            request2(health, money, religion, happy);
        } else if (randomRequest == 2) {
            request3(health, money, religion, happy);
        }
    }
    private void request1(Meters health, Meters money, Meters religion, Meters happy){
        Scanner scan = new Scanner(System.in);
        System.out.println("The farmer, " + getName() + ", says that the crops are dying and need better fertilizer, will you help?\n");
        System.out.println("1. Yes \n2. No\n");
        try {
            int choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("You fund new fertilizer, helping the crops grow making them sell for higher, you gain a profit. \n");
                money.worthUp(10);
                happy.worthUp(5);
            } else if (choice == 2) {
                System.out.println("You say the fertilizer is fine and we just need to wait it out. The crops do not get better and the farmers buy the new fertilizer themselves. You make no profit.\n");
                happy.worthDown(15);
            }
        } catch (InputMismatchException e) {
            System.out.println("INVALID INPUT , TRY AGAIN");
            scan.nextLine();
        }
    }
    private void request2(Meters health, Meters money, Meters religion, Meters happy){
        Scanner scan = new Scanner(System.in);
        System.out.println("The farmer, " + getName() + ", says that the rich are treated better than the poor, which is unfair. Will you tax the rich more?\n");
        System.out.println("1. Yes \n2.No\n");
        try {
            int choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("Tax the rich and the poor the same, the rich are mad, the poor aren't affected. Now everyone is sad.\n");
                money.worthUp(10);
                happy.worthDown(15);
            } else if (choice == 2) {
                System.out.println("You do not tax the rich, making the poor upset, however the rich are happy and give you presents as a reward for cooperating with them.\n");
                happy.worthDown(10);
                money.worthUp(15);
            }
        } catch (InputMismatchException e) {
            System.out.println("INVALID INPUT , TRY AGAIN");
            scan.nextLine();
        }
    }
    private void request3(Meters health, Meters money, Meters religion, Meters happy){
        Scanner scan = new Scanner(System.in);
        System.out.println("The farmer, " + getName() + ", threatens you saying he will kill everything and everyone. What do you do?\n");
        System.out.println("1. Imprison him to keep everyone safe \n2. Laugh it off, he is poor and stupid. Stupid farmer what will he do\n");
        try {
            int choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("Good.\n");
                money.worthUp(5);
                happy.worthUp(5);
                religion.worthUp(5);
                health.worthUp(5);
            } else if (choice == 2) {
                System.out.println("He was not kidding.\n");
                money.worthDown(100);
                happy.worthDown(100);
                religion.worthDown(100);
                health.worthDown(100);
            }
        } catch (InputMismatchException e) {
            System.out.println("INVALID INPUT , TRY AGAIN");
            scan.nextLine();
        }
    }
}
