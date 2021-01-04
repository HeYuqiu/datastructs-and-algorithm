import java.util.Scanner;

/**
 * @author Yuqiu.He
 * @date 2021/1/3
 */
public class HJ11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int digit = sc.nextInt();
        int num = sc.nextInt();
        if (digit < 3 || digit > 7) {
            System.out.println(-1);
        }
        int from = (int) Math.pow(10, digit - 1);
        int to = (int) Math.pow(10, digit);
        int no = -1;
        int last = 0;
        for (int i = from; i < to; i++) {
            int res = 0;
            int temp = i;
            for (int j = digit - 1; j >= 0; j--) {
                int tenN = (int) Math.pow(10, j);
                int dn = temp / tenN;
                if (dn > 0) {
                    temp = temp % (dn * tenN);
                    res += (int) Math.pow(dn, digit);
                }
            }
            if (res == i) {
                last = res;
                no++;
                if (no == num) {
                    System.out.println(res);
                    break;
                }
            }
        }
        if (num > no) {
            System.out.println(last * num);
        }
    }
}
