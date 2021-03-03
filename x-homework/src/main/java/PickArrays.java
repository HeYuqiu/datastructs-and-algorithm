
import lombok.var;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PickArrays {

    public static void main(String[] args) {

        double[] input = {2421.8, 2391, 3630.3, 6626.2, 5041.8, 2283.8, 2755.4, 2770.55, 5985.8, 4365, 6108, 6047.3,
                2304.7, 6057.42, 4842, 2889.4, 1956.5, 3614, 3926.89, 5499.6, 1284.7};
        double[] sums = {19280, 22172, 38929.31};
//        double[] input = {201, 90,100, 110, 190, 300, 301, 400};
//        double[] sums = {100, 200, 300};
        Arrays.sort(input);
        Arrays.sort(sums);

        List<Result> result = new ArrayList<>();
        Path path = new Path();

        search(result, path, input, sums, sums[0], 0, 3, 0);

        checkResult(sums, result);

        printResult(result);
    }

    private static void printResult(List<Result> result) {
        int c = 0;
        for (Result result1 : result) {
            System.out.println(++c + "\t" + result1);
        }
    }

    private static void checkResult(double[] sums, List<Result> result) {
        for (Result r : result) {
            for (int i = 0; i < 3; i++) {
                var sum = r.pick(i).stream().mapToDouble(v->v).sum();
                if (Math.abs(sum - sums[i]) > 20F) {
                    throw new IllegalStateException("invalid result");
                }
            }
        }
    }

    private static void search(List<Result> result, Path path, double[] input, double[] sums,
                               double target, int currentLayer, int endLayer, int bound) {
        int len = input.length;
        if (!path.isEmpty()) {
            if (target < -20F) {
                return;
            } else if (-20F <= target && target <= 20F) {
                if (currentLayer + 1 < endLayer) {
                    currentLayer++;
                    search(result, path, input, sums, sums[currentLayer], currentLayer, endLayer, 0);
                } else {
                    addToResult(result, input, path);
                }
            }
        }

        for (int i = bound; i < len; i++) {
            if (path.contains(i)) {
                continue;
            }
            path.pick(currentLayer).addLast(i);
            search(result, path, input, sums, target - input[i], currentLayer, endLayer, i + 1);
            path.pick(currentLayer).removeLast();
        }
    }

    private static void addToResult(List<Result> result, double[] input, Path path) {
        Result g = new Result();
        for (int i = 0; i < 3; i++) {
            List<Double> values = path.pick(i).stream().map(v -> input[v]).collect(Collectors.toList());
            g.pick(i).addAll(values);
        }
        result.add(g);
    }

    static class Group<E extends Number, T extends Collection<E>> {
        T s1;
        T s2;
        T s3;

        public boolean contains(E e) {
            return s1.contains(e) || s2.contains(e) || s3.contains(e);
        }

        public boolean isEmpty() {
            return s1.isEmpty() && s2.isEmpty() && s3.isEmpty();
        }

        public Group(Supplier<T> supplier) {
            s1 = supplier.get();
            s2 = supplier.get();
            s3 = supplier.get();
        }

        public T pick(int i) {
            switch (i) {
                case 0:
                    return s1;
                case 1:
                    return s2;
                case 2:
                    return s3;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    static class Path extends Group<Integer, Deque<Integer>> {
        public Path() {
            super(LinkedList::new);
        }
    }

    static class Result extends Group<Double, List<Double>> {
        public Result() {
            super(ArrayList::new);
        }
        @Override
        public String toString() {
            return "Group1 " + s1 + "  Group2 " + s2 + "   Group3 " + s3 + "  ";
        }
    }
}
