import java.util.*;
public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Solution ob = new Solution();
        int T = sc.nextInt();
        if (1 <= T && T <= 100) {
            int answer[] = new int[T];
            for (int t = 1; t <= T; t++) {
                int max = 0, count = 0;
                int a[][] = new int[3][3];
                int temp[] = new int[4];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i == 1 && j == 1)
                            a[i][j] = 0;
                        else
                            a[i][j] = sc.nextInt();
                    }
                }

                temp[0] = ob.returnValue(a, 0, 0, 2, 2);
                temp[1] = ob.returnValue(a, 0, 2, 2, 0);
                temp[2] = ob.returnValue(a, 1, 0, 1, 2);
                temp[3] = ob.returnValue(a, 0, 1, 2, 1);

                for (int i = 0; i < 4; i++) {
                    if (temp[i] == 1000000001)
                        continue;
                    for (int j = 0; j < 4; j++) {
                        if (temp[i] == temp[j])
                            count += 1;
                    }
                    if (count > max)
                        max = count;
                    count = 0;
                }

                count = max;

                for (int i = 0; i < 3; i++) {
                    if (i == 0 || i == 2) {
                        if (a[i][0] - a[i][1] == a[i][1] - a[i][2])
                            count += 1;
                    }

                }


                for (int j = 0; j < 3; j++) {
                    if (j == 0 || j == 2) {
                        if (a[0][j] - a[1][j] == a[1][j] - a[2][j])
                            count += 1;
                    }

                }

                answer[t - 1] = count;

            }

            for (int i = 0; i < T; i++) {
                System.out.println("Case #" + (i + 1) + ": " + answer[i]);
            }
        } 
        else {
            System.out.println("Memory exceeded");
        }
    }

    public int returnValue(int[][] a, int m, int n, int o, int p) {

        int d;
        if (a[m][n] > a[o][p]) {
            d = a[m][n] - a[o][p];
            if (d % 2 == 1) {
                return 1000000001;
            } else {
                return a[m][n] - d / 2;
            }
        } 
        else {
            d = a[o][p] - a[m][n];
            if (d % 2 == 1) {
                return 1000000001;
            } else {
                return a[o][p] - d / 2;
            }
        }
    }

}
