import java.util.Scanner;

public class MoreSizes extends Base {
    private int size;

    public void setSize(int size) {
        this.size = size;
    }

    public MoreSizes(boolean type) {
        super(type);
    }

    /**
     * method purpose is to fill and arraylist "a" for further modifications and the user will determine the size of the grid
     */
    public void dummyArray() {
        boolean b = true;
        while (b) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("how big should be the the grid range is from 4-10");
                setSize(sc.nextInt());
                if (size < 11) {
                    b = false;
                  }
            }catch(Exception e){
                System.out.println("incorect format");
            }
        }

        for (int i = 0; i < size * size; i++) {
            a.add(" ");
        }
    }

    /**
     * a method that takes users coordination and adds them to the grid (Arraylist a)
     */
    public void addToGrid() {
        boolean b = true;
        while (b) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("write an row number");
                int x = sc.nextInt();
                System.out.println("write an column number");
                int y = sc.nextInt();

                if (a.get((size * x) + y).equals(" ") && x <= size && x >= 0 && y <=size && y >= 0) {
                    if (type) {
                        a.set((size * x) + y, "X");
                        type = false;
                    }
                    else if (!type) {
                        a.set((size * x) + y, "O");
                        type = true;
                    }
                } else {
                    System.out.println("incorect value");
                }
                b = false;
            }catch (Exception e){
                System.out.println("incorect format or value");
            }
        }


    }


    public void grid() {
        int coordination = 0;
        System.out.print(" ");
        for (int it = 0; it < size; it++) {
            System.out.print("   " + it);
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int in = 0; in < size; in++) {
                if (in == 0) {
                    System.out.print("  ");
                }
                System.out.print("+---");
                if (in == size - 1) {
                    System.out.print("+");
                }
            }
            System.out.println();
            for (int in = 0; in < size; in++) {
                    if (in == 0) {
                        System.out.print(i + " | " + a.get(coordination) + " ");
                    } else {
                        System.out.print("| " + a.get(coordination) + " ");
                    }


                if (in == size - 1) {
                    System.out.println("|");
                }
                coordination++;
            }
        }
        for (int in = 0; in < size; in++) {
            if (in == 0) {
                System.out.print("  ");
            }
            System.out.print("+---");
            if (in == size - 1) {
                System.out.println("+");
            }
        }
    }


    public boolean win() {
        for (int i = 0; i < a.size() - 1; i++) {
            if (i % size == 0) {
                if (a.get(i).equals(a.get(i + 1)) && !a.get(i).equals(" ")) {
                    if (a.get(i).equals(a.get(i + 2))) {
                        if (a.get(i).equals(a.get(i + 3))) {
                           if(a.get(i).equals("X")){
                               System.out.println("player X won");
                               grid();
                           } else if(a.get(i).equals("O")){
                               System.out.println("player O won");
                               grid();
                           }
                            return false;
                        }
                    }
                }
            }
            if (i < (size * size) - (3 * size)) {
                if (a.get(i).equals(a.get(i + size)) && !a.get(i).equals(" ")) {
                    if (a.get(i).equals(a.get(i + size + size))) {
                        if (a.get(i).equals(a.get(i + size + size + size))) {
                            if(a.get(i).equals("X")){
                                System.out.println("player X won");
                                grid();
                            } else if(a.get(i).equals("O")){
                                System.out.println("player O won");
                                grid();
                            }
                            return false;

                        }
                    }
                }
            }
            for (int in = 0; in < size - 3; in++) {
                for (int it = 0; it < size - 3; it++) {
                    if (i < (size * size) - (3 * size) - 1 && i == size * in + it && !a.get(i).equals(" ")) {
                        if (a.get(i).equals(a.get(i + size + 1))) {
                            if (a.get(i).equals(a.get(i + size + size + 2))) {
                                if (a.get(i).equals(a.get(i + size + size + size + 3))) {
                                    if(a.get(i).equals("X")){
                                        System.out.println("player X won");
                                        grid();
                                    } else if(a.get(i).equals("O")){
                                        System.out.println("player O won");
                                        grid();
                                    }
                                    return false;
                                }
                            }
                        }
                    }
                    if (i < (size * size) - (3 * size) - 1 && i == size * in + it + 3 && !a.get(i).equals(" ")) {
                        if (a.get(i).equals(a.get(i + size - 1))) {
                            if (a.get(i).equals(a.get(i + size + size - 2))) {
                                if (a.get(i).equals(a.get(i + size + size + size - 3))) {
                                    if(a.get(i).equals("X")){
                                        System.out.println("player X won");
                                        grid();
                                    } else if(a.get(i).equals("O")){
                                        System.out.println("player O won");
                                        grid();
                                    }
                                    return false;
                                }
                            }
                        }
                    }
                    }
                }
            }
        if (!(a.contains(" "))) {
            System.out.println("tie");
            grid();
            return false;
        }
        return true;
    }

    public void start(){
        boolean b = true;
        dummyArray();
        while(b) {
            grid();
            addToGrid();
            b=win();
            if (!b) {
                b = playAgain();
            }
        }
    }
}
