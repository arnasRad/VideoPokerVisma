public class Main {
    private static int defaultStartCreditAmount = 100; // At the beginning of a game a player gets 100 credits by default

    public static void main(String[] args) {
        int option;
        int credits = defaultStartCreditAmount;
        while(true) {
            MenuUtils.printMenu(credits);
            option = Utils.getOption(0, MenuUtils.menuOptionCount);

            switch (option) {
                case 1:     // start the game
                    int bet;
                    System.out.println("/*******************/");
                    System.out.println("NEW GAME");
                    System.out.println();
                    while(credits > 0) {
                        System.out.println("/*******************/");
                        System.out.println("CREDITS: " + credits);
                        System.out.println();
                        System.out.println("SET A BET");
                        System.out.println("Enter 0 to stop betting");

                        bet = Utils.getIntInput();
                        if (bet == 0) {
                            break;
                        }
                        credits -= bet;

                        System.out.println();

                        System.out.println("Dealing cards...");
                        StandardDeck deck = new StandardDeck();
                        Hand hand = new Hand(deck);

                        while(true) {
                            System.out.println(hand);
                            System.out.println("SELECT CARDS TO HOLD");
                            System.out.println("Cancel hold by selecting a held card");
                            System.out.println("Enter 0 to stop selecting and draw cards");
                            option = Utils.getOption(0, 5);
                            if (option == 0) {
                                break;
                            }

                            hand.toggleCardHold(option - 1);
                        }

                        hand.drawCards();
                        System.out.println(hand);

                        int prize = hand.getHandPrize();
                        int wonAmount = bet * prize;
                        credits += wonAmount;

                        if (prize != 0) {
                            System.out.println("HAND PRIZE: " + prize);
                            System.out.println("PLAYER HAS WON " + wonAmount +
                                    " CREDITS WITH THIS HAND!");
                            System.out.println();
                        } else {
                            System.out.println("NO WIN WITH THIS HAND");
                        }
                        System.out.println("HAND INCOME: " + (wonAmount - bet));

                        if (credits <= 0) {
                            System.out.println("ALL CREDITS LOST. GAME END");
                        }
                        System.out.println();
                    }
                    System.out.println("/*******************/");
                    System.out.println("GAME STOPPED");
                    System.out.println("TOTAL CREDIT AMOUNT: " + credits);
                    System.out.println("/*******************/");
                    break;
                case 2:     // how to play Jacks or Better
                    printTutorial();
                    System.out.println();
                    break;
                case 3:     // about this game (Jacks or Better)
                    printAbout();
                    System.out.println();
                    break;
                case 0:     // return the game
                    System.out.println("Quitting game...");
                    return;
            }
        }
    }

    private static void printTutorial() {
        System.out.println("RULES");
        System.out.println("The rules of the game are very simple.\n" +
                "All you need to be aware of is how many credits you will be " +
                "betting in each hand,\ntry and form a hand that is a pair of " +
                "jacks or better and the machine will take care of the rest for you.\n" +
                "\n" +
                "There are two rounds of cards in jacks or better,\nthe first round " +
                "you can hold cards and the second round is known as a showdown " +
                "round. \nYou can only hold cards after the cards are dealt the first " +
                "time, \nthe second time there is no holding or changing any cards.");
        System.out.println("\nreference: https://igaming.org/casino/learn-how-to-play-jacks-or-better/");

        System.out.println("HOW TO PLAY");
        System.out.println("#1 Start the game by entering 1 to the console");
        System.out.println("#2 Enter you bet. Bet cannot be greater than current total credits");
        System.out.println("#3 Select which cards you want to hold." +
                "\n\tYou can cancel hold mark by selecting the card again");
        System.out.println("#4 When finished selecting - enter 0");
        System.out.println("#5 The game will then calculate the ranking of hand with newly " +
                "\n\tdrawn cards and output the results");
        System.out.println("#6 Play ends when 0 is entered on betting step or " +
                "\n\tif credit amount gets less than 0");

        System.out.println("\nHand ranking | prize");
        System.out.println("NOTE: Payout formula: BET * PRIZE");
        System.out.println();
        System.out.println(
                "     Royal Flush | 800\n" +
                "  Straight Flush | 50\n" +
                 "  Four of a kind | 25\n" +
                 "      Full House | 9\n" +
                 "           Flush | 6\n" +
                 "        Straight | 4\n" +
                 " Three of a kind | 3\n" +
                 "        Two Pair | 2\n" +
                 " Jacks or Better | 1\n" +
                 "       All Other | 0\n"
        );
        System.out.println("Rankings reference: https://en.wikipedia.org/wiki/Video_poker#Jacks_or_Better");
    }

    private static void printAbout() {
        System.out.println("Jacks or Better is a very popular video poker " +
                "game, which many players finds fun because \nof its high payouts " +
                "and its easy game play. To play jacks or better doesn't take a " +
                "whole lot from you, \nno matter if it is in a live casino or if you " +
                "are sitting at home in front of your computer playing it.");
        System.out.println("\nreference: https://igaming.org/casino/learn-how-to-play-jacks-or-better/");
    }
}
