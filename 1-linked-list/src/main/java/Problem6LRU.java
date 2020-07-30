import model.ListNode;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 如何用链表实现LRU缓存淘汰算法
 * 指导思想:
 * 单向链表，越靠后的越是最早访问
 * 流程:
 * 每次获取遍历链表找到节点，找到后，删除原位置数据，在头节点重新插入；没找到时，直接在头节点插入；
 * 如果链表超过容量，则删除最末尾节点
 * 优化方案:
 * 此方案每次需要遍历链表，时间复杂度为O(n)，可考虑散列表来记录每个数据的位置，将时间复杂度降到O(1);
 *
 * @author Yuqiu.He
 * @date 2020-06-28
 */
public class Problem6LRU {
    ListNode listNode;

    public static void main(String[] args) throws InterruptedException {
        Date d = new Date();
        TimeUnit.SECONDS.sleep(1);
        long countdown = new Date().getTime() - d.getTime();

        HashMap<Integer,Integer> hashMap =new HashMap();
        hashMap.put(3,4);
        hashMap.put(2,2);
        hashMap.put(6,1);
        hashMap.put(1,7);
        hashMap.put(11,7);
        hashMap.put(5,7);
        hashMap.put(4,7);
        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println(entry.getKey());
        }

    }
}
