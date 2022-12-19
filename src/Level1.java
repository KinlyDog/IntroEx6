public class Level1 {
    public static String PatternUnlock(int n, int[] hits) {
        final int SQUARE_SIDE = 3;

        int[][] squareEx = new int[t][t];
        int[][] squareNormal = new int[t][t];
        int index = 0;

        for (int i = 0; i < SQUARE_SIDE; i++) {
            for (int j = 0; j < SQUARE_SIDE; j++) {
                squareNormal[i][j] = index++;

                if (j == 0) {
                    squareEx[i][j] = 6 - i;
                }
                if (j == 1) {
                    squareEx[i][j] = 1 + i;
                }
                if (j == 2) {
                    squareEx[i][j] = 9 - i;
                }
            }
        }
        index = 0;

        int[] hitsNormal = new int[n];
        while (index < n) {

            for (int i = 0; i < t; i++) {
                for (int j = 0; j < t; j++) {
                    if (hits[index] == squareEx[i][j]) {
                        hitsNormal[index] = squareNormal[i][j];
                        break;
                    }
                }
            }

            index++;
        }
        index = 0;
        squareNormal = null;
        squareEx = null;

        final double HYPOTENUSE = Math.sqrt(2);
        double unlockLineLength = 0;
        for (int i = 0; i < n - 1; i++) {
            if ((hitsNormal[i] + hitsNormal[i + 1]) % 2 == 0) {
                unlockLineLength += HYPOTENUSE;
            } else {
                unlockLineLength += 1;
            }
        }

        hitsNormal = null;

        if (unlockLineLength > (int) unlockLineLength) {
            unlockLineLength = Math.round(unlockLineLength * 100_000);
        }

        String unlockCode = String.valueOf((int) unlockLineLength);

        if (!unlockCode.contains("0")) return unlockCode;

        String unlockCode2 = "";
        for (int i = 0; i < unlockCode.length(); i++) {
            if (unlockCode.charAt(i) != '0') {
                unlockCode2 += unlockCode.charAt(i);
            }
        }

        return unlockCode2;
    }
}