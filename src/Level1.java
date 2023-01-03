public class Level1 {
    public static String PatternUnlock(int n, int[] hits) {
        final int SQUARE_SIDE = 3;

        int[][] squareSeqNum = new int[t][t];
        int[][] square = new int[t][t];

        int index = 0;

        // нумеруем поля матриц
        // в первой матрице нумерация последовательная (слева направо, снизу вверх)
        // во второй нумерация задана условием задачи
        for (int i = 0; i < SQUARE_SIDE; i++) {
            for (int j = 0; j < SQUARE_SIDE; j++) {
                squareSeqNum[i][j] = index++;

                if (j == 0) {
                    square[i][j] = 6 - i;
                }

                if (j == 1) {
                    square[i][j] = 1 + i;
                }

                if (j == 2) {
                    square[i][j] = 9 - i;
                }
            }
        }
        index = 0;

        // считываем код разблокировки для исходной матрицы
        // на основании этого, переносим код разблокировки на последовательно пронумерованную матрицу
        int[] hitsSeqNum = new int[n];
        while (index < n) {

            for (int i = 0; i < t; i++) {
                for (int j = 0; j < t; j++) {
                    if (hits[index] == square[i][j]) {
                        hitsSeqNum[index] = squareSeqNum[i][j];
                        break;
                    }
                }
            }

            index++;
        }

        // вычисляем длину линии разблокировки
        final double HYPOTENUSE = Math.sqrt(2);
        double unlockLineLength = 0;
        for (int i = 0; i < n - 1; i++) {
            if ((hitsSeqNum[i] + hitsSeqNum[i + 1]) % 2 == 0) {
                unlockLineLength += HYPOTENUSE;
            } else {
                unlockLineLength += 1;
            }
        }

        // получаем длину линии (код разблокировки) с точностью до 5 знаков после запятой
        if (unlockLineLength > (int) unlockLineLength) {
            unlockLineLength = Math.round(unlockLineLength * 100_000);
        }

        String unlockCode = String.valueOf((int) unlockLineLength);

        if (!unlockCode.contains("0")) {
            return unlockCode;
        }

        // исключаем все нули из кода разблокировки
        String unlockCode2 = "";
        for (int i = 0; i < unlockCode.length(); i++) {
            if (unlockCode.charAt(i) != '0') {
                unlockCode2 += unlockCode.charAt(i);
            }
        }

        return unlockCode2;
    }
}