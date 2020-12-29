import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpertEvaluation {
    public static void main(String[] args) {

        String input = Util.readFile("part4.txt");
        System.out.println("Input: \n" + input);
        System.out.println("==================Run==================");
        System.out.println(expertEvaluation(input));

    }

    private static String expertEvaluation(String input) {
        StringBuilder sbResult = new StringBuilder();

        Pattern pattern = Pattern.compile(".+");
        Matcher matcher = pattern.matcher(input);
        int arrSize = 0;

        while (matcher.find()) {
            arrSize++;
        }

        matcher.reset();

        String[][] strArr = new String[arrSize][7];
        for (int i = 0; i < strArr.length; i++) {
            matcher.find();
            strArr[i] = matcher.group().split(", ");
        }

        double sum = 0.;
        double[] sums = new double[5];
        double[][] dublicate = new double[arrSize][5];
        double max = 0;

        for (int i = 0; i < strArr.length; i++) {
            sbResult.append(strArr[i][0] + "    ");
            for (int j = 2; j < strArr[i].length; j++) {
                double calculate = Double.parseDouble(strArr[i][1]) * Double.parseDouble(strArr[i][j]);
                strArr[i][j] = String.valueOf(Math.round(calculate * 100.) / 100.);
                dublicate[i][j - 2] = Double.valueOf(strArr[i][j]);
                sbResult.append(strArr[i][j] + "   ");
            }
            Arrays.sort(dublicate[i]);
            sbResult.append("Max: " + dublicate[i][4]);
            sbResult.append(System.lineSeparator());
        }

        StringBuilder sbSums = new StringBuilder();
        sbSums.append("Sums      ");

        for (int i = 0; i < sums.length; i++) {
            for (int j = 0; j < sums.length; j++) {
                sum = sum + Math.round(Double.valueOf(strArr[j][i + 2]) * 100.);
            }
            sums[i] = sum / 100.;
            sbSums.append(sums[i] + "   ");
            sum = 0;
        }
        Arrays.sort(sums);
        sbSums.append("Max: " + sums[sums.length - 1]);


        return sbResult.append(sbSums).toString();
    }
}
