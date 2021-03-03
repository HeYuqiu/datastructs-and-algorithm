import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuqiu.He
 * @date 2021/3/3
 */
public class SplitList {
    public List<List<Integer>> split(List<Integer> list) {
        int temp = 0;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            tempList.add(list.get(i));
            temp += list.get(i);
            if (temp > 4) {
                temp = 0;
                result.add(tempList);
                tempList = new ArrayList<>();
            }
        }
        if (tempList.size() > 0) {
            result.add(tempList);
        }
        return result;
    }
}
