import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Base {
    boolean type;
    String s;

    public Base(boolean type) {
        this.type = type;
    }

    ArrayList<String> textControl = new ArrayList<>();
    ArrayList<String> a = new ArrayList<>();
    ArrayList<String> check = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    /**
     * method dummyArray() purpose is to fill and arraylist "a" for further modifications
     * in this class it also makes another arraylist called textControl, and it's used for checking if a user uses the correct formatting
     */
    public void dummyArray() {
        for (int i = 0; i < 9; i++) {
            a.add(" ");
        }
        for (int i = 0; i < 3; i++) {
            for (int in = 1; in < 4; in++) {
                if (i == 0) {
                    textControl.add("a" + in);
                }
                if (i == 1) {
                    textControl.add("b" + in);
                }
                if (i == 2) {
                    textControl.add("c" + in);
                }
            }
        }
    }

    /**
     * a simple method to print a grid
     */
    public void grid() {
        System.out.println("    1   2   3");
        System.out.println("  +---+---+---+");
        System.out.println("A " + "| " + a.get(0) + " | " + a.get(1) + " | " + a.get(2) + " |");
        System.out.println("  +---+---+---+");
        System.out.println("B " + "| " + a.get(3) + " | " + a.get(4) + " | " + a.get(5) + " |");
        System.out.println("  +---+---+---+");
        System.out.println("C " + "| " + a.get(6) + " | " + a.get(7) + " | " + a.get(8) + " |");
        System.out.println("  +---+---+---+");
    }

    /**
     * a method which takes users input to make a coordination on the grid
     */
    public void coordination() {
        boolean b = true;
        grid();
        while (b) {
            try {
                System.out.println("select a position in the following format (a1, b2 etc.)");
                s = sc.next();
                if (textControl.contains(s) && !(check.contains(s))) {
                    b = false;
                    check.add(s);
                } else {
                    System.out.println("a formating error");
                }
            } catch (Exception e) {
                System.out.println("error has occured");
            }

        }
    }

    /**
     * method addToGrid() is in a way a converter from the string to an index for the arraylist that represents the grid
     */
    public void addToGrid() {
        if (type) {
            switch (String.valueOf(s.charAt(0))) {
                case "c" -> a.set(Integer.parseInt(String.valueOf(s.charAt(1))) + 5, "X");
                case "b" -> a.set(Integer.parseInt(String.valueOf(s.charAt(1))) + 2, "X");
                case "a" -> a.set(Integer.parseInt(String.valueOf(s.charAt(1))) - 1, "X");
            }

            type = false;

        } else if (!type) {
            switch (String.valueOf(s.charAt(0))) {
                case "c" -> a.set(Integer.parseInt(String.valueOf(s.charAt(1))) + 5, "O");
                case "b" -> a.set(Integer.parseInt(String.valueOf(s.charAt(1))) + 2, "O");
                case "a" -> a.set(Integer.parseInt(String.valueOf(s.charAt(1))) - 1, "O");
            }
            type = true;
        }


    }

    /**
     * this method is for when a player finishes a round they can play again
     *
     * @return true if they want to play again  input: (Y)
     * @return false if the input is N           input: (N)
     */
    public boolean playAgain() {
            System.out.println("play again? [Y/N]");
            boolean b = true;
            String choice = "";
            while (b) {
                Scanner sc = new Scanner(System.in);
                try {
                    choice = sc.next();
                    if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")) {
                        b = false;
                    } else {
                        System.out.println("there was a formating error");
                    }
                } catch (Exception e) {
                    System.out.println("error has been found");
                }

            }
            if (choice.equalsIgnoreCase("y")) {
                Collections.fill(a, " ");
                check.clear();
                return true;
            }
        return false;
        }


    /**
     * check if there is victory
     * @return true if there isn't a win
     * @return false is there is a win
     */
    public boolean win() {
        for (int i = 0; i < a.size() - 1; i++) {
            if (i == 0 || i == 1 || i == 2) {
                if (a.get(i).equals(a.get(i + 3)) && !a.get(i).equals(" ")) {
                    if (a.get(i).equals(a.get(i + 3 + 3))) {
                        if (a.get(i).equals("X")) {
                            System.out.println("player X won");
                        } else if (a.get(i).equals("O")) {
                            System.out.println("player O won");
                        }
                        return false;


                    }
                }
            }
            if (i % 3 == 0) {
                if (a.get(i).equals(a.get(i + 1)) && !a.get(i).equals(" ")) {
                    if (a.get(i).equals(a.get(i + 2))) {
                        if (a.get(i).equals("X")) {
                            System.out.println("player X won");
                        } else if (a.get(i).equals("O")) {
                            System.out.println("player O won");
                        }
                        return false;
                    }
                }
            }

            if (i == 0 && !a.get(i).equals(" ")) {
                if (a.get(i).equals(a.get(i + 3 + 1))) {
                    if (a.get(i).equals(a.get(i + 3 + 3 + 2))) {
                        if (a.get(i).equals("X")) {
                            System.out.println("player X won");
                        } else if (a.get(i).equals("O")) {
                            System.out.println("player O won");
                        }
                        return false;
                    }
                }
            }

            if (i == 2 && !a.get(i).equals(" ")) {
                if (a.get(i).equals(a.get(i + 3 - 1))) {
                    if (a.get(i).equals(a.get(i + 3 + 3 - 2))) {
                        if (a.get(i).equals("X")) {
                            System.out.println("player X won");
                        } else if (a.get(i).equals("O")) {
                            System.out.println("player O won");
                        }
                        return false;

                    }
                }
            } else if (check.size() == 9) {
                System.out.println("tie");
                return false;
            }
        }
        return true;
    }

    /**
     * this method will connect all the method previously created
     */

    public void start() {
        boolean win = true;
        dummyArray();
        while (win) {
            coordination();
            addToGrid();
            win = win();
            if (!win) {
                System.out.println("before" + win);
                win = playAgain();
                System.out.println("after" + win);
            }
        }
    }
}
