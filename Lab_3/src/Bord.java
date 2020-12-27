import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bord {

    public static void main(String[] args) {

        String input = Util.readFile("part3.txt");

        System.out.println(input);

        System.out.println(bord(input));

    }

    public static String bord(String input) {
        StringBuilder sbResult = new StringBuilder();
        Pattern pattern = Pattern.compile(".+");
        Matcher matcher = pattern.matcher(input);

        String[][] values = new String[5][4];
        int pointer = 0;

        String temp;

        while (matcher.find()) {
            temp = matcher.group();
            values[pointer] = temp.split(",");
            pointer++;
        }

        int totalA = 0;
        int totalB = 0;
        int totalC = 0;

        Element[] elValues = new Element[5];

        for (int i = 0; i < 5; i++) {
            elValues[i] = new Element();
            elValues[i].value = Integer.valueOf(values[i][0]);
            for (int j = 0; j < values[i].length; j++) {
                int tp = j;
                if (values[i][j].contains("A")) {
                    elValues[i].index_A = (tp - 3) * -1;
                } else if (values[i][j].contains("B")) {
                    elValues[i].index_B = (tp - 3) * -1;
                } else if (values[i][j].contains("C")) {
                    elValues[i].index_C = (tp - 3) * -1;
                }
            }
        }


        for (int i = 0; i < elValues.length; i++) {
            totalA = totalA + elValues[i].index_A * elValues[i].value;
            totalB = totalB + elValues[i].index_B * elValues[i].value;
            totalC = totalC + elValues[i].index_C * elValues[i].value;
        }

        sbResult.append("A = " + totalA + " B = " + totalB + " C = " + totalC + " Winner: ");

        if (totalA > totalB && totalA > totalC) {
            sbResult.append("A");
        }
        if (totalB > totalA && totalB > totalC) {
            sbResult.append("B");
        }
        if (totalC > totalB && totalC > totalA) {
            sbResult.append("C");
        }

        return sbResult.toString();
    }

    public static class Element extends Object {

        Element() {

        }
        int value;
        int index_A;
        int index_B;
        int index_C;

    }

}
