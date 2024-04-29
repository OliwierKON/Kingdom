import java.util.InputMismatchException;
import java.util.Scanner;
public class Priest extends People { //Priest is a subclass of People and uses the same methods
    public Priest(String name) {
        super(name); //calls to the original method in People
    }

    @Override //overrides the original method, this makes it so that i dont have to keep making new methods.
    public void giveRequest(Meters health, Meters money, Meters religion, Meters happy) { //The characters request, able to alter all the meters.
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
        System.out.println("The priest, " + getName() + ", asks if you would donate to help build a temple. Do you help?\n");
        System.out.println("1. Yes 2. No\n");
        try {
            int choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("You provide funding, making the priest and followers happier\n");
                money.worthDown(10);
                happy.worthUp(5);
                religion.worthUp(15);
            } else if (choice == 2) {
                System.out.println("You Do Not Fund the temple, saving money.\n");
                money.worthUp(15);
                happy.worthDown(5);
                religion.worthDown(10);
            }
        } catch (InputMismatchException e) {
            System.out.println("INVALID INPUT , TRY AGAIN");
            scan.nextLine();
        }
    }
    private void request2(Meters health, Meters money, Meters religion, Meters happy){
        Scanner scan = new Scanner(System.in);
        System.out.println("The priest, " + getName() + ", wants everyone to make an offering to god with something valuable, you will of course get a share of the money.\n");
        System.out.println("1. Agree 2. Do not \n");
        try {
            int choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("You force everyone to make offerings, making them doubt the real purpose of the temple\n");
                money.worthUp(15);
                happy.worthDown(10);
                religion.worthDown(20);
            } else if (choice == 2) {
                System.out.println("You shame the priest for making such a proposition, pleasing everyone but your bank account\n");
                money.worthDown(5);
                happy.worthUp(10);
                religion.worthUp(15);
            }
        } catch (InputMismatchException e) {
            System.out.println("INVALID INPUT , TRY AGAIN");
            scan.nextLine();
        }
    }
    private void request3(Meters health, Meters money, Meters religion, Meters happy){
        Scanner scan = new Scanner(System.in);
        System.out.println("The priest, " + getName() + ", says that their religion needs to be taught to children at a younger age.\n");
        System.out.println("1. You Agree 2. You Do Not\n");
        try {
            int choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("The schools start teaching about religion earlier, making some feel like they are forced into it.\n");
                happy.worthDown(5);
                religion.worthUp(10);
            } else if (choice == 2) {
                System.out.println("You disagree and keep everything as is.\n");
                religion.worthDown(5);
                happy.worthUp(5);
            }
        } catch (InputMismatchException e) {
            System.out.println("INVALID INPUT , TRY AGAIN");
            scan.nextLine();
        }
    }
}
