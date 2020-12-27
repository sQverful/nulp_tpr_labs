import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayProcessing {

    public static final Pattern patternForInt = Pattern.compile("(?<=\\s|^)\\d+(?=\\s|$)");
    public static final Pattern patternForDoubles = Pattern.compile("([+-]?\\d+\\.\\d+)|(\\.\\d+)");
    public static final Pattern patternForNum = Pattern.compile("([+-]?\\d+\\.?\\d?)");

    public static double[] getDoubleValuesFromFile(String input) {
        double[] result = new double[3];

        Matcher matcherForDoubles = patternForDoubles.matcher(input);

        for (int i = 0; i < result.length; i++) {
            matcherForDoubles.find();
            result[i] = Double.parseDouble(matcherForDoubles.group());
        }

        return result;
    }

    public static double[][] getIntValuesFromFile(String input) {
        double[][] result = new double[3][3];

        Matcher matcherForInt = patternForInt.matcher(input);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                matcherForInt.find();
                result[i][j] = Integer.parseInt(matcherForInt.group());
            }
        }

        return result;
    }

    public static double[] getAllNumbers(String input) {
        StringBuilder sbResult = new StringBuilder();
        double[] nums = new double[15];

        Matcher matcherForNum = patternForNum.matcher(input);

        for (int i = 0; i < nums.length; i++) {
            matcherForNum.find();
            nums[i] = Double.parseDouble(matcherForNum.group());
        }

        return nums;

    }
}
