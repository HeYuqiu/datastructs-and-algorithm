import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yuqiu.He
 * @date 2021/1/3
 */
public class HJ12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        while (sc.hasNext()) {
            arr.add(sc.nextInt());
        }
        int len = arr.size();
        if (len == 1) {
            System.out.println(Math.abs(arr.get(0)));
        } else if (arr.get(0) >= 0) {
            System.out.println(arr.get(0) + arr.get(1));
        } else if (arr.get(len - 1) <= 0) {
            System.out.println(-(arr.get(len - 2) + arr.get(len - 1)));
        } else {
            int result = 65535;
            // 找到第一个正数
            int posIndex = 0;
            for (int i = 0; i < len; i++) {
                if (arr.get(i) > 0) {
                    posIndex = i;
                    break;
                }
            }
            for (int i = 0; i < posIndex; i++) {
                int temp = 65535;
                for (int j = posIndex; j < len; j++) {
                    int abs = Math.abs(arr.get(i) + arr.get(j));
                    if (abs > temp) {
                        break; // 越来越大，后续的正数就没有比较的必要了；
                    }
                    result = abs < result ? abs : result;
                }
            }
            System.out.println(result);
        }
    }
}
