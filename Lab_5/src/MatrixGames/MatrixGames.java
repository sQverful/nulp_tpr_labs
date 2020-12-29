/**
 * All rights belongs to A. Shymoniak :)
 */

package MatrixGames;

import java.util.Arrays;

public class MatrixGames {

    public int isSolutionSaddlePoint(int[][] arr) {
        int[] minInRows = new int[arr.length];
        int[] maxInCols = new int[arr[0].length];
        int temp;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i][0];
            for (int j = 0; j < arr[0].length; j++) {
                if (temp > arr[i][j]) {
                    temp = arr[i][j];
                }
            }
            minInRows[i] = temp;
        }
        for (int i = 0; i < arr[0].length; i++) {
            temp = arr[0][i];
            for (int j = 0; j < arr.length; j++) {
                if (temp < arr[j][i]) {
                    temp = arr[j][i];
                }
            }
            maxInCols[i] = temp;
        }
        int maxMin = Arrays.stream(minInRows).max().orElse(0);
        int minMax = Arrays.stream(maxInCols).min().orElse(0);
        System.out.println("Minmax = " + minMax + ", Maxmin = " + maxMin);
        if (minMax == maxMin) {
            return minMax;
        } else {
            return -1;
        }
    }

    public int[][] checkDominationRows(int[][] arr) {
        boolean isDominating;
        boolean tempBoolean;
        for (int i = 0; i < arr.length - 1; i++) {
            isDominating = arr[i][0] > arr[i + 1][0];
            for (int k = 0; i + k < arr.length; k++) {
                for (int j = 0; j < arr[0].length - 1; j++) {
                    if (arr[i][j] > arr[i + k][j]) {  // якщо кожен елемент в рядку більший за елемент іншого рядка
                        tempBoolean = true;
                    } else {
                        tempBoolean = false;
                    }
                    isDominating = isDominating && tempBoolean;
                }
                System.out.println("Is dominating row: " + i + "-" + (i + k) + " " + isDominating);
                if (isDominating) {
                    MatrixActions matrixActions = new MatrixActions();
                    arr = matrixActions.deleteMatrixRow(arr, i);
                    checkDominationRows(arr);
                }
            }
            System.out.println();
        }
        return arr;
    }

    public int[][] checkDominationCols(int[][] arr) {
        boolean isDominating;
        boolean tempBoolean;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j + i < arr[0].length; j++) {
                isDominating = true;
                for (int k = 0; k < arr[0].length; k++) {
                    if (arr[k][i] > arr[k][i + j]) {
                        tempBoolean = true;
                    } else {
                        tempBoolean = false;
                    }
                    isDominating = isDominating && tempBoolean;
                }
                System.out.println("Is dominating col: " + i + "-" + (i + j) + " " + isDominating);
                if (isDominating) {
                    MatrixActions matrixActions = new MatrixActions();
                    arr = matrixActions.deleteMatrixCol(arr, i + j);
                    checkDominationCols(arr);
                }
            }
            System.out.println();
        }
        return arr;
    }
}