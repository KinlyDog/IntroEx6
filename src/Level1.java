public class Level1 {
    public static String PatternUnlock(int n, int[] hits) {
        final double HYPOTENUSE = Math.sqrt(2);
        final int SQUARE_SIDE = 3;

        int[][] squareEx = new int[t][t];
        int[][] squareNormal = new int[t][t];
        int x = 0;
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                squareNormal[i][j] = x++;

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

        int[] hitsNormal = new int[n];
        int y = 0;
        while (y < n) {

            for (int i = 0; i < t; i++) {
                for (int j = 0; j < t; j++) {
                    if (hits[y] == squareEx[i][j]) {
                        hitsNormal[y] = squareNormal[i][j];
                        break;
                    }
                }
            }

            y++;
        }

        double unlockLineLength = 0;
        for (int i = 0; i < n - 1; i++) {
            if ((hitsNormal[i] + hitsNormal[i + 1]) % 2 == 0) {
                unlockLineLength += hypotenuse;
            } else {
                unlockLineLength += 1;
            }
        }


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