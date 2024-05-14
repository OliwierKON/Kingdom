import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in); //scanner listens to inputs.
    private int Turn = 0; //Turn Count for later
    private Meters health;
    private Meters money;

    private Meters religion;

    private Meters happy;

    public void Menu() {
        System.out.print("Welcome to the kingdom.");
        boolean prompt = true; // a boolean that starts a menu loop
        while (prompt) {
            health = new Meters("Health/Safety", 100, 50); //meters inside prompt in case i want to add a try again screen (this way they reset when prompt = true again)
            money = new Meters("Money", 100, 50);
            religion = new Meters("Religion", 100, 50);
            happy = new Meters("Happiness", 100, 50);

            System.out.print("\n 1. Start \n 2. Explanation \n 3. End \n\nAwaiting input.... "); // \n = New Line

            try {
                int choice = scan.nextInt();
                if (choice == 1) {
                    System.out.println();     // turns off the menu ,
                    prompt = false;
                    playTurn(); //starts the game  turns
                } else if (choice == 2) {
                    System.out.println("\nYou rule over a kingdom, where you have to manage money, religion, happiness and health/safety.\nPeople are going to give you requests, granting or denying their wishes increases or decreases some of the meters.\nReaching 100, or 0 in any of the areas loses you the game.");
                    scan.nextLine(); //Scans again
                } else if (choice == 3) {
                    prompt = false; // turns off the menu without starting the game.
                }

            } catch (InputMismatchException e) { // finds false inputs and listens for new ones, prevents errors
                System.out.println("\n INVALID INPUT , TRY AGAIN");
                scan.nextLine();
            }

        }


    }

    private final ArrayList<String> allNames = new ArrayList<>(); //Array list with names

    {
        allNames.add("Gertrude");
        allNames.add("Martha");
        allNames.add("Martin");
        allNames.add("Klortler");
        allNames.add("HeebieJeebies");
        allNames.add("Geez");
        allNames.add("Louise");
        allNames.add("Mark");
        allNames.add("Jort");
        allNames.add("Kendolph");
        allNames.add("Emineminem");
        allNames.add("Trevor");
        allNames.add("Derreanrer");
    }

    private People generateRandomVisitor() { //Makes a random person give a request, also gives them a random name
        int random = (int) (Math.random() * 3); //generates random number
        int randomnameIndex = (int) (Math.random() * allNames.size()); // a number used to decide the name
        String randomname = allNames.get(randomnameIndex); // using the randomnameIndex, it decides the name
        if (random == 0) {
            return new Farmer(randomname);
        } else if (random == 1) {
            return new Priest(randomname);
        } else return new Soldier(randomname);
    }

    private void playTurn() {
        boolean rungame = true;
        while (rungame) {
            System.out.println(health.getmeterName() + ": " + health.getCurrentworth() + " | " + money.getmeterName() + ": " + money.getCurrentworth() + " | " + religion.getmeterName() + ": " + religion.getCurrentworth() + " | " + happy.getmeterName() + ": " + happy.getCurrentworth());
            Turn++; //Turn count goes up
            People visitor = generateRandomVisitor(); // makes a new visitor each turn
            visitor.giveRequest(health, money, religion, happy); //makes the visitor give a request with access to all the meters
            checkLoss();
        }
    }

    private void checkLoss() {

        if (health.getCurrentworth() == 0) {
            System.out.println("The plague takes the kingdom and everyone dies. You Lose.\n Your kingdom managed for " + Turn + " turns.");
            System.exit(0);
        } else if (health.getCurrentworth() == health.getMaxworth()) {
            System.out.println("The strong military went against the king and you lost all power. You Lose\n Your kingdom managed for " + Turn + " turns.");
            System.exit(0);
        } else if (money.getCurrentworth() == 0) {
            System.out.println("Your people starve as no one can afford to buy food, they start to go against the king.  You Lose.\n Your kingdom managed for " + Turn + " turns.");
            System.exit(0);
        } else if (money.getCurrentworth() == money.getMaxworth()) {
            System.out.println("You had so much money that you bought 100 other kingdoms. You forgot your avanza lösenord though and the stock market crashed and you couldn't sell so you are broke now and have no kingdoms at all, brokie. You Lose.\n Your kingdom managed for " + Turn + " turns.");
            System.exit(0);
        } else if (religion.getCurrentworth() == 0) {
            System.out.println("People start to lose hope and faith. They do not believe in anything anymore, not even their king. You Lose.\n Your kingdom managed for " + Turn + " turns.");
            System.exit(0);
        } else if (religion.getCurrentworth() == religion.getMaxworth()) {
            System.out.println("The people voted for a Pope to lead the kingdom, you have no power. You Lose.\n Your kingdom managed for " + Turn + " turns.");
            System.exit(0);
        } else if (happy.getCurrentworth() == 0) {
            System.out.println("No one is happy, not even you. You die of sadness in your sleep. You Lose.\n Your kingdom managed for " + Turn + " turns.");
            System.exit(0);
        } else if (happy.getCurrentworth() == happy.getMaxworth()) {
            System.out.println("Everyone is too happy, they forget about their problems. An enemy kingdom attacked but your people refused to fight because they wanted to make love not war. You all died. You Lose.\n Your kingdom managed for " + Turn + " turns.");
            System.exit(0);
        } else if (happy.getCurrentworth() == 0 && religion.getCurrentworth() == 0 && money.getCurrentworth() == 0 && health.getCurrentworth() == 0) {
            System.out.println("He was not kidding. You Lose\n");
            System.exit(0);
        }


    }

}
