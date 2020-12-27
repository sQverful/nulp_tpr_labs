import java.util.Arrays;

public class TreeDecision {

    public static void main(String[] args) {
        String input = Util.readFile("part2.txt");


        System.out.println(findDecision(input));

    }

    public static String[] getEMV(String input) {
        String[] nodes = new String[6];
        double[] values = ArrayProcessing.getAllNumbers(input);

        TreeNode A = new TreeNode("A", values[0], values[1] * values[14], values[2], values[4], values[3] * values[14]);
        TreeNode B = new TreeNode("B", values[5], values[6] * values[14], values[7], values[9], values[8] * values[14]);
        TreeNode D = new TreeNode("D", values[0], values[1] * (values[14] - 1), values[12], values[13], values[3] * (values[14] - 1));
        TreeNode E = new TreeNode("E", values[5], values[6] * (values[14] - 1), values[12], values[13], values[8] * (values[14] - 1));

        double EMVofA = calculateNode(A);
        double EMVofB = calculateNode(B);
        double EMVofD = calculateNode(D);
        double EMVofE = calculateNode(E);
        double EMVofF = 0;

        TreeNode C;
        if (EMVofD > EMVofE) {
            C = new TreeNode("C",0, EMVofD, 0.7, 0.3, 0);
        } else {
            C = new TreeNode("C",0, EMVofE, 0.7, 0.3, 0);
        }
        double EMVofC = calculateNode(C);

        double[] results = {EMVofA, EMVofB, EMVofC, EMVofD, EMVofE, EMVofF};
        String[] names = {"EMV(A) = ", "EMV(B) = ", "EMV(C) = ", "EMV(D) = ", "EMV(E) = ", "EMV(F) = ",};

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = names[i] + results[i];
        }

        return nodes;

    }

    public static String findDecision(String input) {
        StringBuilder sbResult = new StringBuilder();
        double[] values = ArrayProcessing.getAllNumbers(input);

        TreeNode A = new TreeNode("A", values[0], values[1] * values[14], values[2], values[4], values[3] * values[14]);
        TreeNode B = new TreeNode("B", values[5], values[6] * values[14], values[7], values[9], values[8] * values[14]);
        TreeNode D = new TreeNode("D", values[0], values[1] * (values[14] - 1), values[12], values[13], values[3] * (values[14] - 1));
        TreeNode E = new TreeNode("E", values[5], values[6] * (values[14] - 1), values[12], values[13], values[8] * (values[14] - 1));


        double EMVofA = calculateNode(A);
        double EMVofB = calculateNode(B);
        double EMVofD = calculateNode(D);
        double EMVofE = calculateNode(E);

        TreeNode C;
        if (EMVofD > EMVofE) {
            C = new TreeNode("C",0, EMVofD, 0.7, 0.3, 0);
        } else {
            C = new TreeNode("C",0, EMVofE, 0.7, 0.3, 0);
        }
        double EMVofC = calculateNode(C);

        double[] arrResult = {EMVofA, EMVofB, EMVofC};
        Arrays.sort(arrResult);

        double resultValue = arrResult[2];
        String name = "Err";

        if (resultValue == EMVofA) {
            name = "A";
        } else if (resultValue == EMVofB) {
            name = "B";
        } else if (resultValue == EMVofC) {
            name = "C";
        }
        sbResult.append(name + ": " + arrResult[2]);


        return sbResult.toString();
    }

    public static double calculateNode(TreeNode node) {
        double result = 0;
        double M1 = node.getM1();
        double D1 = node.getD1();
        double P1 = node.getP1();
        double P2 = node.getP2();
        double P3;
        double P4;
        double D2 = node.getD2();

        result = P1 * D1 + P2 * D2 - M1;

        return result;

    }


    public static class TreeNode {
        private String name;
        private double M1;
        private double D1;
        private double P1;
        private double P2;
        private double P3;
        private double P4;
        private double D2;

        public TreeNode() {

        }

        public TreeNode(String name, double m1, double d1, double p1, double p2, double d2) {
            this.name = name;
            M1 = m1;
            D1 = d1;
            P1 = p1;
            P2 = p2;
            D2 = d2;
        }

        public TreeNode(double p1, double p2, double p3, double p4) {
            P1 = p1;
            P2 = p2;
            P3 = p3;
            P4 = p4;
        }

        public double getM1() {
            return M1;
        }

        public double getD1() {
            return D1;
        }

        public double getP1() {
            return P1;
        }

        public double getP2() {
            return P2;
        }

        public double getP3() {
            return P3;
        }

        public double getP4() {
            return P4;
        }

        public double getD2() {
            return D2;
        }

        public String getName() {
            return this.name;
        }
    }
}
