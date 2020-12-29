package MatrixGames;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    private Util() {

    }

    private static final String ENCODING = "UTF-8"; //you can change it to UTF-8

    public static String readFile(String path) {

        String res = null;

        try {

            byte[] bytes = Files.readAllBytes(Paths.get(path));
            res = new String(bytes, ENCODING);

        } catch (IOException ex) {
            //Logger imitation
        }

        return res;

    }

    public static int[][] convertFileToArr(String input, int col, int rows) {
        int[][] result = new int[col][rows];
        Pattern patternForInt = Pattern.compile("(?<=\\s|^)\\d+(?=\\s|$)");
        Matcher matcherForInt = patternForInt.matcher(input);
        StringBuilder sbTemp = new StringBuilder();

        while (matcherForInt.find()) {
            sbTemp.append(matcherForInt.group())
                    .append(" ");
        }

        String[] strArr = sbTemp.toString().trim().split(" ");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = Integer.parseInt(strArr[i * col + j].trim());
            }
        }

        return result;
    }
}