public class Level1 {
    public static String PatternUnlock(int n, int[] hits) {
        final double hypotenuse = Math.sqrt(2);
        final int t = 3;

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

        double sum = 0;
        for (int i = 0; i < n - 1; i++) {
            if ((hitsNormal[i] + hitsNormal[i + 1]) % 2 == 0) {
                sum += hypotenuse;
            } else {
                sum += 1;
            }
        }


        if (sum > (int) sum) {
            sum = Math.round(sum * 100_000);
        }
        String str = String.valueOf((int)sum);

        if (!str.contains("0")) return str;

        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                str2 += str.charAt(i);
            }
        }

        return str2;
    }

    public static void main(String[] args) {
        int[] hits = {1, 2, 3, 4, 5, 6, 2, 7, 8, 9};
        int n = 10;
        System.out.println(PatternUnlock(n, hits));
    }
}