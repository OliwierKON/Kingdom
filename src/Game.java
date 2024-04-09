import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in); //scanner listens to inputs.
      public void Menu() {


          System.out.print("Welcome to the kingdom.");

          boolean prompt = true;
          while(prompt) {
              System.out.print("\n 1. Start \n 2. Explanation \n 3. End \n\nAwaiting input.... "); // \n = New Line

              try {  int choice = scan.nextInt();
                   if(choice == 1) {
                      System.out.println("YA");
                        prompt = false;
                  }else {
                       System.out.println("NO");
                   }
              } catch (InputMismatchException e) {
                  System.out.println("\nTRY AGAIN");
                    scan.nextLine();
              }
          }

      }
      }

