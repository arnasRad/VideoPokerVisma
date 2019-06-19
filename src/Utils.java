import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Utility functions for the project
 */
public class Utils {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * requests user integer input
     * loops until user inputs an integer
     * @return integer value user has entered
     */
    public static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Enter an integer");
            scanner.nextLine();
        }

        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    /**
     * requests user integer input at bounds [start, end]
     * loops until user inputs an integer that satisfies bounds
     * @param start start of bounds
     * @param end end of bounds
     * @return
     */
    public static int getOption(int start, int end) {
        while(true) {
            System.out.println("Enter option: ");
            int option = Utils.getIntInput();
            if (option < start || option > end)
                System.out.println("Enter a number between " + start + " and " + end);
            else
                return option;
        }

    }

    /**
     * Utility function used to get character-filled strings of required length
     * @param n length of the String to return
     * @param character characters that fill the returned String
     * @return String of length n filled with passed character values
     */
    @NotNull
    public static String getFilledString(int n, char character) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; ++i) {
            sb.append(character);
        }

        return sb.toString();
    }

    /**
     * Get a cards' rank by index
     * @param card a card to get rank from
     * @return cards' rank index representation
     */
    public static int getCardRankIndex(Card card) {
        return Rank.valueOf(card.getRank().toString()).ordinal();
    }
}
