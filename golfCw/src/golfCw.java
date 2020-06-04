import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

    public class golfCw {
    static Scanner input = new Scanner(System.in);
    public static HashMap<String, Integer> club = new HashMap<String, Integer>();  //calling hashmap

    public static void main(String[] args) {
        process();

    }

    public static void process() {
        System.out.println("\n| -------------------------------------------------|");
        System.out.println("| Welcome to Springfield Golf Club.                |" +
                "\n| Select an Option\t                               |" +
                "\n|\t1)Enter Scores                                 |" +
                "\n|\t2)Find Golfer                                  |" +
                "\n|\t3)Delete Golfer                                |" +
                "\n|\t4)Display Scoreboard                           |" +
                "\n|\t5)Exit Programme                               |");
        System.out.println("| -------------------------------------------------|");
        Integer enterOptionNumber = integerInput();
        do {
            if (enterOptionNumber < 1 || enterOptionNumber > 5) {
                System.out.println("Invalid input please enter a number within range of 1 and 5");
                enterOptionNumber = integerInput();
                continue;
            }
        } while (enterOptionNumber < 1 || enterOptionNumber > 5);

        switch (enterOptionNumber) {
            case 1:
                enterScores();
                break;
            case 2:
                findGolfer();
                break;
            case 3:
                deleteGolfer();
                break;
            case 4:
                displayScoreboard();
                break;
            case 5:
                exitProgramme();
                break;
            default:
                System.out.println("Invalid Option!!! Reenter...");
        }
    }

    //enter scores method
    public static void enterScores() {
        // TODO Auto-generated method stub
        System.out.println("Enter no of Golfers in a Group:");
        int noOfgolfers = integerInput();
        for (int i = 0; noOfgolfers > i; i++) {
            System.out.print("Enter the name of the Golfer:");
            //name validation
            String name = input.next();
            while (!name.matches("[a-zA-Z,]+")) {
                System.out.println("Enter Alphabatical Values");
                name = input.next();
            }
            while (club.containsKey(name) || !name.matches("[a-zA-Z,]+")) {
                System.out.println("Name already exist !!");
                System.out.println("Enter a another name with Alphabatical Values :");
                name = input.next();
            }

            //Scores validation
            System.out.print("Enter the number of stokes taken by the Golfer:");
            int score = integerInput();
            do {
                if (score < 19 || score > 107) {
                    System.out.println("Invalid Stokes !!! It has to be within range of 18 to 108");
                    score = integerInput();
                    continue;
                }
            } while (score < 19 || score > 107);

            club.put(name, score);
        }
        process();
    }

    //Find Golfer method
    public static void findGolfer() {
        //  Auto-generated method stub

        System.out.println("Enter the name of the Golfer :");
        String name = input.next();
        System.out.println("Score of the Golfer " + name + " is " + club.get(name));

        process();
    }

    // Delete golfer method
    public static void deleteGolfer() {
        // TODO Auto-generated method stub
        System.out.println("Enter name of the Golfer to be removed");

        String nameofGolfer = input.next();
        while (!nameofGolfer.matches("[a-zA-Z,]+")) {
            System.out.println("Enter Alphabatical Values ()");
            nameofGolfer = input.next();
        }
        if (club.containsKey(nameofGolfer) || !nameofGolfer.matches("[a-zA-Z,]+")) {
            club.remove(nameofGolfer);
            System.out.println(nameofGolfer + " was deleted successfully");
        }else{
            System.out.println("Incorrect Name!");
        }

        process();

    }

    //Display scoreboard method
    public static void displayScoreboard() {

        System.out.println("---------------------------");
        System.out.printf("%10s %10s", "NAME", "SCORE");
        System.out.println();
        System.out.println("---------------------------");

        HashMap<String, Integer> sorted = club
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                                LinkedHashMap::new));


        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.format("%10s %10s",
                    entry.getKey(), entry.getValue());
            System.out.println();
        }

        process();
    }

    //Exit programme method
    public static void exitProgramme() {
        System.out.println("Thank You !");
    }

    //Integer validation
    private static Integer integerInput() {
        while (!input.hasNextInt()) {
            System.out.println("please check for your input,it is not in proper order make sure you enter a number ");
            input.next();

        }
        Integer inputValue = input.nextInt();
        return inputValue;
    }


}