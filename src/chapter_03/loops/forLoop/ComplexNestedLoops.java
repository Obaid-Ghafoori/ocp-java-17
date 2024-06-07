package chapter_03.loops.forLoop;

public class ComplexNestedLoops {
}

class FindInMatrix {
    final static int[][] complexArray = {{1, 13}, {5, 2}, {2, 2}};
    final static int searchValue = 2;
    static int positionX = -1;
    static int positionY = -1;

    /*
      j0    j1
     -----------
     | 1    13 | --> i0
     | 5    2  | --> i1
     | 2    2  | --> i2
     ___________
     */
    public static void main(String[] args) {

    }

    public void findFirstMatchingValueInEntireLoop(){
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
            System.out.println("Value  " + searchValue + "not found");
        } else {
            System.out.println("\nValue  " + searchValue + " found at: " + "(" + positionX + ", " + positionY + ")");
        }
    }

    public void findFirstMatchingValueOfLastInnerLoop() {
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
            System.out.println("Value  " + searchValue + "not found");
        } else {
            System.out.println("\nValue  " + searchValue + " found at: " + "(" + positionX + ", " + positionY + ")");
        }
    }

    public void findLastMatchingValueInEntireLoop() {
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
            System.out.println("Value  " + searchValue + "not found");
        } else {
            System.out.println("\nValue  " + searchValue + " found at: " + "(" + positionX + ", " + positionY + ")");
        }
    }



}
