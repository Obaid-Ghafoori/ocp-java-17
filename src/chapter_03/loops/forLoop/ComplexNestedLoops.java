package chapter_03.loops.forLoop;

/**
 * This class showcases the different loops in the java ecosystem and the usage of optional labels and keyword such as break and continue
 */
public class ComplexNestedLoops {
}

class FindInMatrix {
    final static int[][] complexArray = {{1, 13}, {5, 2}, {2, 2}};
    final static int searchValue = 2;
    static int positionX = -1;
    static int positionY = -1;

    public static void main(String[] args) {
        /*
          j0    j1
         -----------
         | 1    13 | --> i0
         | 5    2  | --> i1
         | 2    2  | --> i2
         ___________
         */

        findFirstMatchingValueInEntireLoop();

        //performCleaningForOtherThanStablesBOrLeopard2();

        for (char stables = 'a'; stables <= 'd'; stables++) {
            for (int leopard = 1; leopard < 4; leopard++) {
                if (stables == 'b' || leopard == 2) {
                    continue;
                }
                System.out.println("Cleaning: " + stables + "," + leopard);
            }
        }

    }

    private static void performCleaningForOtherThanStablesBOrLeopard2() {
        CLEANING:
        for (char stables = 'a'; stables <= 'd'; stables++) {
            for (int leopard = 1; leopard < 4; leopard++) {
                if (stables == 'b' || leopard == 2) {
                    continue CLEANING;
                }
                System.out.println("Cleaning: " + stables + "," + leopard);
            }
        }
    }

    private static void findFirstMatchingValueInEntireLoop() {
        PARENT_LOOP:
        for (int i = 0; i < complexArray.length; i++) {
            for (int j = 0; j < complexArray[i].length; j++) {
                System.out.print(complexArray[i][j] + ", ");
                if (complexArray[i][j] == searchValue) {
                    positionX = i;
                    positionY = j;
                    break PARENT_LOOP;
                }
            }
        }

        if (positionX == -1 || positionY == -1) {
            System.out.println("Value " + searchValue + "not found");
        } else {
            System.out.println("\nValue " + searchValue + " found at: " + "(" + positionX + ", " + positionY + ")");
        }
    }

    private static void findFirstMatchingValueOfLastInnerLoop() {
        for (int i = 0; i < complexArray.length; i++) {
            for (int j = 0; j < complexArray[i].length; j++) {
                System.out.print(complexArray[i][j] + ", ");
                if (complexArray[i][j] == searchValue) {
                    positionX = i;
                    positionY = j;
                    break;
                }
            }
        }

        if (positionX == -1 || positionY == -1) {
            System.out.println("Value " + searchValue + "not found");
        } else {
            System.out.println("\nValue " + searchValue + " found at: " + "(" + positionX + ", " + positionY + ")");
        }
    }

    private static void findLastMatchingValueInEntireLoop() {
        for (int i = 0; i < complexArray.length; i++) {
            for (int j = 0; j < complexArray[i].length; j++) {
                System.out.print(complexArray[i][j] + ", ");
                if (complexArray[i][j] == searchValue) {
                    positionX = i;
                    positionY = j;
                }
            }
        }

        if (positionX == -1 || positionY == -1) {
            System.out.println("Value " + searchValue + "not found");
        } else {
            System.out.println("\nValue " + searchValue + " found at: " + "(" + positionX + ", " + positionY + ")");
        }
    }


}
