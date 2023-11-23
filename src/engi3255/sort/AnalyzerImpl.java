package engi3255.sort;

public class AnalyzerImpl implements Analyzer {

    private double[] ratios;
    private double error;
    private String bigOh;

    @Override
    public void analyze(int[] sizes, long[] data) {
        String[] bigOhs = {"O(log N)","O(N)","O(N log N)","O(N^2)","O(N^3)","O(2^N)"};
        boolean allEqual = true;
        boolean linear = true;

        for(int i=0; i<sizes.length; i++){
            if (data[i] != data[0]) {
                allEqual = false;
                break;
            }
        }
        for(int i=0; i<sizes.length; i++){
            if (data[i] != (data[0] * (i + 1))) {
                linear = false;
                break;
            }
        }

        if (allEqual) {
            bigOh = "O(1)";
            return;
        }
        if (linear) {
            bigOh = "O(N)";
            return;
        }
        error = 100000000;
        for(String bigO: bigOhs) {
            double calcerror = calculateError(sizes, data, bigO);
            if (error > calcerror) {
                error = calcerror;
                bigOh = bigO;
            }
        }
    }


    private double calculateError(int[] sizes, long[] data, String bigOh) {
        // Implement error calculation based on your analysis
        // This will depend on how you estimate the complexity
        // For example, you can calculate the sum of squared differences
        // between the actual data and the expected data based on BigOh.
        // Return the calculated error.
        double error = 0;
        for (int i = 0; i < sizes.length; i++) {
            error += getSquareError(sizes[i], data[i], bigOh);
        }
        return error / sizes.length;
    }

    private double getSquareError(int size, long data, String bigOh) {
        switch (bigOh) {
            case "O(2^N)" -> {
                return Math.pow(data - Math.pow(2, size), 2);
            }
            case "O(N^3)" -> {
                return Math.pow(data - Math.pow(size, 3), 2);
            }
            case "O(N^2)" -> {
                return Math.pow(data - Math.pow(size, 2), 2);
            }
            case "O(N log N)" -> {
                return Math.pow(data - size * Math.log(size), 2);
            }
            case "O(N)" -> {
                return Math.pow(data - size, 2);
            }
            case "O(log N)" -> {
                return Math.pow(data - Math.log(size), 2);
            }
            default -> {
                return 1000000;
            }
        }
    }

    @Override
    public double[] getRatios() {
        return ratios;
    }

    @Override
    public double getError() {
        return error;
    }

    @Override
    public String getBigOh() {
        return bigOh;
    }
}
