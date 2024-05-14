import java.util.InputMismatchException;
import java.util.Scanner;

public class Priest extends People { //Priest is a subclass of People and uses the same methods
    public Priest(String name) {
        super(name); //calls to the original method in People
    }

    @Override
    public void giveRequest(Meters health, Meters money, Meters religion, Meters happy) { //Request method decidec which request will be given randomly
        int randomRequest = (int) (Math.random() * 3); //generates number from 0-2
        if (randomRequest == 0) {
            request1(health, money, religion, happy); //runs first request
        } else if (randomRequest == 1) {
            request2(health, money, religion, happy); // runs second request
        } else if (randomRequest == 2) {
            request3(health, money, religion, happy); //runs third request
        }
    }

    private void request1(Meters health, Meters money, Meters religion, Meters happy) { //A question followed by a prompt, increasing or decreasing ceratin values,
        Scanner scan = new Scanner(System.in);
        System.out.println("The priest, " + getName() + ", asks if you would donate to help build a temple. Do you help?\n");
        System.out.println("1. Yes \n2. No\n");
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

    private void request2(Meters health, Meters money, Meters religion, Meters happy) {
        Scanner scan = new Scanner(System.in);
        System.out.println("The priest, " + getName() + ", wants everyone to make an offering to god with something valuable, you will of course get a share of the money.\n");
        System.out.println("1. Agree \n2. Do not \n");
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

    private void request3(Meters health, Meters money, Meters religion, Meters happy) {
        Scanner scan = new Scanner(System.in);
        System.out.println("The priest, " + getName() + ", says that their religion needs to be taught to children at a younger age.\n");
        System.out.println("1. You Agree \n2. You Do Not\n");
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
