public class MenuUtils {
    private static final int MENU_LINE_WIDTH = 25;      // menu width
    private static final String NUMBER_LABEL_TEMPLATE = " [%d]";    // template for menu option number String
    public static int menuOptionCount = -1; // option count in menu

    /**
     * Prints the main menu screen to the console
     * @param credits Shows current player credits
     */
    public static void printMenu(int credits) {
        try {
            drawHorizontalLine();
            drawMenuLine(null);   // null and "" as argument here works the same
                                        // (outputs blank menu line)
            drawMenuLine("VIDEO POKER");
            drawMenuLine("JACKS OR BETTER");
            drawMenuLine(null);
            drawMenuLine(null);
            drawMenuOptionLine("START", 1);
            drawMenuOptionLine("HOW TO PLAY", 2);
            drawMenuOptionLine("ABOUT", 3);
            drawMenuOptionLine("QUIT", 0);
            drawMenuLine(null);
            drawMenuLine("CREDITS: " + credits);
            drawMenuLine(null);
            drawHorizontalLine();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Program terminated");
        }
    }

    /**
     * Draws a horizontal star-line to the console
     * Mainly used for game menu
     */
    private static void drawHorizontalLine() {
        // + 2 characters for vertical lines on each side of the menu
        System.out.println(Utils.getFilledString(MENU_LINE_WIDTH + 2, '*'));
    }

    /**
     * Adds a new line with text to the menu
     * @param text text to print to the menu
     * @throws Exception thrown when text size is greater than width of the menu
     */
    private static void drawMenuLine(String text) throws Exception {
        String textString = "";
        if (text != null) {
            textString = text;
        }

        if (textString.length() > MENU_LINE_WIDTH) {
            System.err.println();
            throw new Exception("ERROR in method drawMenuLine(): " +
                    "text string length is greater than menu line width");
        }

        StringBuilder sb = new StringBuilder();
        sb.append('*');
        int whiteSpaceLen = (MENU_LINE_WIDTH - textString.length()) / 2;

        sb.append(Utils.getFilledString(whiteSpaceLen, ' '));
        sb.append(textString);
        sb.append(Utils.getFilledString(MENU_LINE_WIDTH -
                textString.length() - whiteSpaceLen, ' '));
        sb.append('*');
        System.out.println(sb.toString());
    }

    /**
     * Adds a new option line to the menu
     * Options are numbered
     * @param option option text (label)
     * @param number option number
     * @throws Exception thrown when text size is greater than width of the menu
     */
    private static void drawMenuOptionLine(String option, int number) throws Exception {
        String numberLabel = String.format(NUMBER_LABEL_TEMPLATE, number);

        String optionString = "";
        if (option != null) {
            optionString = option;
        }

        if (optionString.length() > (MENU_LINE_WIDTH - numberLabel.length() - 1)) {
            throw new Exception("ERROR in method drawMenuLine(): " +
                    "option string length is greater than menu line width");
        }

        StringBuilder sb = new StringBuilder();
        sb.append('*');
        sb.append(numberLabel);
        ++menuOptionCount;
        int whiteSpaceLen = (MENU_LINE_WIDTH - optionString.length()) / 2 - numberLabel.length();
        if (whiteSpaceLen < 1) {
            whiteSpaceLen = 1;
        }

        sb.append(Utils.getFilledString(whiteSpaceLen, ' '));
        sb.append(optionString);
        sb.append(Utils.getFilledString(MENU_LINE_WIDTH - optionString.length() -
                whiteSpaceLen - numberLabel.length(), ' '));
        sb.append('*');
        System.out.println(sb.toString());
    }
}
