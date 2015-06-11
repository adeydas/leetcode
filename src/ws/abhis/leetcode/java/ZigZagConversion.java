package ws.abhis.leetcode.java;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversion {
    public String convert (String text, int nRows) {
        //Check for the obvious
        if (text == null || text.length()==0)
            return null;
        if (nRows <= 0)
            return null;

        //Find the number of columns, given rows.
        //This equals 2^nRows -1
        //Initialize 2D array
        int cols = (int) (Math.pow(2,nRows) - 1); //-1 because we want 0-based indexes.
        char[][] twoDArr = new char[nRows][cols];

        int i = 0;
        for (int j=0; j<cols; j++) {
            for (int k=0; k<nRows; k++) {
                if (k % 2 == 0 && j % 2 != 0) {
                    twoDArr[k][j] = '\b';
                } else {
                    if (i < text.length()) {
                        twoDArr[k][j] = text.charAt(i++);
                    }else {
                        twoDArr[k][j] = '\b';
                    }
                }
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int j=0; j<nRows; j++) {
            for (int k=0; k<cols; k++) {
                if (twoDArr[j][k] != '\b') {
                    stringBuffer.append(twoDArr[j][k]);
                }
                System.out.print(twoDArr[j][k] + "\t");
            }
            System.out.println();
        }

        return stringBuffer.toString();
    }

    public static void main(String... args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        System.out.println(zigZagConversion.convert("PAYPALISHIRING", 3));
    }
}
