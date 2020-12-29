package MatrixGames;


public class Main {
    public static void main(String[] args) {

        String input = Util.readFile("part5.txt");
        int[][] matrix = Util.convertFileToArr(input, 5, 5);

        System.out.println("======Input=====" + "\n" + input);

        MatrixGames matrixGames = new MatrixGames();
        if (matrixGames.isSolutionSaddlePoint(matrix) != -1) {
            System.out.println("Saddle point" + matrixGames.isSolutionSaddlePoint(matrix));
        } else {
            System.out.println("There is no saddle point");
            System.out.println("Mixed strategy applying:");
            matrix = matrixGames.checkDominationRows(matrix);
            matrix = matrixGames.checkDominationCols(matrix);

            int[][] player1Matrix = matrix;
            int[][] player2Matrix = transposeMatrix(matrix);

            player1Matrix = addAdditionalMatrixRow(player1Matrix);
            player2Matrix = addAdditionalMatrixRow(player2Matrix);
            System.out.println("\nPlayer À strategy");
            launchGaussMethod(player1Matrix);
            System.out.println("\nPlayer B strategy");
            launchGaussMethod(player2Matrix);
        }


    }

    private static void launchGaussMethod(int[][] matrix) {
        LinearSystem<Float, MyEquation> list = generateSystem(matrix);
        printSystem(list);
        int i, j;
        Algorithm<Float, MyEquation> alg = new Algorithm<Float, MyEquation>(list);
        try {
            alg.calculate();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        Float[] x = new Float[matrix.length];
        for (i = list.size() - 1; i >= 0; i--) {
            Float sum = 0.0f;
            for (j = list.size() - 1; j > i; j--) {
                sum += list.itemAt(i, j) * x[j];
            }
            x[i] = (list.itemAt(i, list.size()) - sum) / list.itemAt(i, j);
        }
        printSystem(list);
        printVector(x);
    }

    private static LinearSystem<Float, MyEquation> generateSystem(int[][] arr) {
        LinearSystem<Float, MyEquation> list = new LinearSystem<Float, MyEquation>();
        int i;
        for (i = 0; i < arr.length; i++) {
            MyEquation equation = new MyEquation();
            equation.generate(arr[i]);
            list.push(equation);
        }
        return list;
    }

    private static void printSystem(LinearSystem<Float, MyEquation> system) {
        for (int i = 0; i < system.size(); i++) {
            MyEquation temp = system.get(i);
            String s = "";
            float tempValue = 0;
            for (int j = 0; j < temp.size(); j++) {
                tempValue = system.itemAt(i, j);
                s += String.format("%f; %s", tempValue, "\t");
            }
            System.out.println(s);
        }
        System.out.println("");
    }

    private static void printVector(Float[] x) {
        String s = "";
        for (int i = 0; i < x.length; i++) {
            s += String.format("x%d = %f; ", i, x[i]);
        }
        System.out.println(s);
    }

    private static int[][] addAdditionalMatrixRow(int[][] arr) {
        int[][] newArr = new int[arr.length + 1][arr[0].length + 2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                newArr[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < newArr.length; i++) {
            newArr[i][newArr[0].length - 2] = -1;
            newArr[i][newArr[0].length - 1] = 0;
        }
        for (int i = 0; i < arr[0].length; i++) {
            newArr[newArr.length - 1][i] = 1;
        }
        newArr[newArr.length - 1][newArr.length - 1] = 0;
        newArr[newArr.length - 1][newArr.length] = 1;
        return newArr;
    }

    public static int[][] transposeMatrix(int [][] m){
        int[][] temp = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                temp[j][i] = m[i][j];
        return temp;
    }
}
