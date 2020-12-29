package MatrixGames;

public class MatrixActions {

    public int findLowestIn1D(int[] matrix) {
        int minValue = matrix[0];
        for (int i = 0; i < matrix.length; i++) {
            if (minValue > matrix[i]) {
                minValue = matrix[i];
            }
        }
        return minValue;
    }

    public int findHighestIn1D(int[] matrix) {
        int maxValue = matrix[0];
        for (int i = 0; i < matrix.length; i++) {
            if (maxValue < matrix[i]) {
                maxValue = matrix[i];
            }
        }
        return maxValue;
    }

    public double findHighestIn1D(double[] matrix) {
        double maxValue = matrix[0];
        for (int i = 0; i < matrix.length; i++) {
            if (maxValue < matrix[i]) {
                maxValue = matrix[i];
            }
        }
        return maxValue;
    }

    public int getIndex1D(int value, int matrix[]) {
        for (int i = 0; i < matrix.length; i++)
            if (matrix[i] == value) {
                return i;
            }
        return -1;
    }

    public int getIndex1D(double value, double matrix[]) {
        for (int i = 0; i < matrix.length; i++)
            if (matrix[i] == value) {
                return i;
            }
        return -1;
    }

    public int getIndexOfRow2D(int value, int matrix[][]) {
        for (int i = 0; i < matrix[0].length; i++)
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == value) {
                    return i;
                }
            }
        return -1;
    }

    public void print(int[] matrix) {
        for (int el : matrix) {
            System.out.print(el + "  ");
        }
        System.out.println();
    }

    public void print(double[] matrix) {
        for (double el : matrix) {
            System.out.print(el + "  ");
        }
        System.out.println();
    }

    public void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void print(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[][] deleteMatrixRow(int[][] arr, int rowNum) {
        int[][] resultArr = new int[arr.length - 1][arr[0].length];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i < rowNum) {
                    resultArr[i][j] = arr[i][j];
                } else {
                    resultArr[i][j] = arr[i + 1][j];
                }
            }
        }
        return resultArr;
    }

    public int[][] deleteMatrixCol(int[][] arr, int colNum) {
        int[][] resultArr = new int[arr.length][arr[0].length - 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) {
                if (j < colNum) {
                    resultArr[i][j] = arr[i][j];
                } else {
                    resultArr[i][j] = arr[i][j + 1];
                }
            }
        }
        return resultArr;
    }
}
