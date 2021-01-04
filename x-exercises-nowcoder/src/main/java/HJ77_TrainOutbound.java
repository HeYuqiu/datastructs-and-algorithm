import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.nowcoder.com/practice/97ba57c35e9f4749826dc3befaeae109?tpId=37&&tqId=21300&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 
 * 题目描述 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，火车站只有一个方向进出，同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
 * 要求输出所有火车出站的方案，以字典序排序输出。
 *
 * 输入描述: 有多组测试用例，每一组第一行输入一个正整数N（0
 *
 * 输出描述: 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
 * 
 * @author Yuqiu.He
 * @date 2020/12/31
 */
public class HJ77_TrainOutbound {
    private static int NUM;
    private static String[] trains;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NUM = sc.nextInt();
        trains = new String[NUM];
        for (int i = 0; i < NUM; i++) {
            trains[i] = sc.next();
        }
        outbound(0, new Stack<String>(), "");
    }

    public static void outbound(int n, Stack<String> statck, String result) {
        if (n == NUM && statck.empty()) { // 火车都入栈了 并且栈都出完了
            System.out.println(result);
        } else if (n == NUM) { // 火车都入栈了 但是栈还没出完
            result = "".equals(result) ? statck.pop() : (result + " " + statck.pop());
            outbound(n, statck, result);
        } else if (statck.empty()) { // 火车还没入完栈,但是目前栈已空
            statck.push(trains[n]);
            outbound(n + 1, statck, result);
        } else { // 火车还没入完栈,并且栈也没空
            // 两个选择：入栈、出栈
            Stack<String> push = (Stack<String>) (statck.clone());
            Stack<String> pop = (Stack<String>) (statck.clone());
            push.push(trains[n]);
            outbound(n + 1, push, result);
            result = "".equals(result) ? pop.pop() : (result + " " + pop.pop());
            outbound(n, pop, result);
        }
    }
}
