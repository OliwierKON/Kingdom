import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in); //scanner listens to inputs.
      public void Menu() {


          System.out.print("Welcome to the kingdom.");
            boolean rungame = false;
          boolean prompt = true;
          while(prompt) {
              System.out.print("\n 1. Start \n 2. Explanation \n 3. End \n\nAwaiting input.... "); // \n = New Line

              try {  int choice = scan.nextInt();
                   if(choice == 1) {
                      System.out.println();
                        prompt = false;
                        rungame = true;
                  } else if (choice==2) {
                       System.out.println("\nYou rule over a kingdom, where you have to manage money, religion, happiness and health/safety.\nPeople are going to give you requests, granting or denying their wishes increases or decreases some of the meters.\nReaching 100, or 0 in any of the areas loses you the game.");
                       scan.nextLine();
                   } else if (choice==3) {
                        prompt=false;
                   }

              } catch (InputMismatchException e) { // finds false inputs and listens for new ones, prevents errors
                  System.out.println("\n INVALID INPUT , TRY AGAIN");
                    scan.nextLine();
              }
          }
            while(rungame = true) {
                Meters health = new Meters("Health/Safety", 100, 50);
                Meters money = new Meters("Money", 100, 50);
                Meters religion = new Meters("Religion", 100, 50);
                Meters happy = new Meters("Happiness", 100, 50);
                System.out.println(health.getmeterName()+": "+health.getCurrentworth()+" | "+money.getmeterName()+": "+money.getCurrentworth()+" | "+religion.getmeterName()+": "+religion.getCurrentworth()+" | "+happy.getmeterName()+": "+happy.getCurrentworth());
                int choice = scan.nextInt();
                if (choice == 1){rungame=false;}

            }
      }
      }

