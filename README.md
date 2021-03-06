### 为什么要学习数据结构和算法？
1. 直接好处就是写出性能更优的代码；
2. 算法，是一种解决问题的思路和方法，有机会应用到生活和事业的其他方面；
3. 长期来看，大脑的思考能力是一个人的核心竞争能力，而算法是为数不多的能够有效训练大脑思考能力的途径之一；

### 怎么学
1. 多思考，死记硬背不如不学
2. 一定要敲代码，适当刷题
3. 学习笔记，留言区互动
4. 遇到难点反复迭代

### 结构图谱
![image.png](https://upload-images.jianshu.io/upload_images/15620186-cb2e11f9b7aeff13.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
###### 10个主要数据结构
数组、链表、栈、队列、散列表、二叉树、堆、跳表、图、Trie 树
###### 10个主要算法
递归、排序、二分查找、搜索、哈希算法、贪心算法、分治算法、回溯算法、动态规划、字符串匹配算法

### 效率和资源消耗的度量衡--复杂度分析

###### 时间复杂度
渐进时间复杂度，标识算法的执行时间与数据规模之间的增长关系.
1. 只关注循环执行次数最多的那段代码
2. 加法法则：总复杂度等于量级最大的那段代码的复杂度
3. 乘法法则：嵌套代码的复杂度等于嵌套内外代码复杂度的乘积
4. logn表示以任意数字为底数的时间复杂度，O(log3n) = O(C * log2n) = O(log2n)
![image.png](https://upload-images.jianshu.io/upload_images/15620186-6e6b72a7fb9021a9.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

###### 空间复杂度
渐进空间复杂度，表示算法的存储空间与数据规模之间的增长关系.
注意是因为算法而额外增加的存储空间，不包括数据本身的存储空间；

### 数组 & 链表
![image.png](https://upload-images.jianshu.io/upload_images/15620186-5578f1e4f2cfc2cb.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
###### 对比
1. 数组是内存中连续的一块内存空间，初始化时，必须要有这一块能够满足的内存用以开辟；而链表支持动态扩容
2. 数组访问比链表速度快，数组根据首地址 + 偏移量 * 元素大小 寻址，而链表需要遍历；
3. 链表比数组插入快；
###### 如何用链表实现LRU缓存淘汰算法
1. 指导思想
单向链表，越靠后的越是最早访问
2. 流程
每次获取遍历链表找到节点，找到后，删除原位置数据，在头节点重新插入；没找到时，直接在头节点插入；
如果链表超过容量，则删除最末尾节点
3. 优化方案
此方案每次需要遍历链表，时间复杂度为O(n)，可考虑**散列表**来记录每个数据的位置，将时间复杂度降到O(1);

### 栈
[见代码](https://github.com/HeYuqiu/datastructs-and-algorithm/tree/master/2-stack)
### 队列
[见代码](https://github.com/HeYuqiu/datastructs-and-algorithm/tree/master/3-queue)
### 递归算法
###### 使用条件
1. 问题可以分解为多个子问题
2. 问题和子问题除了数据规模不同，解题思路一样
3. 存在递归终止条件

###### 递归常见问题及解决方案
1. 警惕堆栈溢出：可以声明一个全局变量来控制递归的深度，从而避免堆栈溢出（或者改为迭代循环的非递归写法）。
2. 警惕重复计算：通过某种数据结构来保存已经求解过的值，从而避免重复计算。

###### 如何将递归改写为非递归代码？
笼统的讲，所有的递归代码都可以改写为迭代循环的非递归写法。如何做？抽象出递推公式、初始值和边界条件，然后用迭代循环实现。
### 排序算法
[实现代码](https://github.com/HeYuqiu/datastructs-and-algorithm/tree/master/5-sort)
![image.png](https://upload-images.jianshu.io/upload_images/15620186-ee8d62b9549ed5b0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
>在小规模数据面前，O(n2) 时间复杂度的算法并不一定比 O(nlogn) 的算法执行时间长
### 二分查找
##### O(logn) 惊人的查找速度
##### 局限性
1. 首先，二分查找依赖的是顺序表结构，简单点说就是数组。
2. 其次，二分查找针对的是有序数据。
3. 再次，数据量太小不适合二分查找。（顺序扫即可）
4. 最后，数据量太大也不适合二分查找。（数组-连续内存空间）

### 散列表
##### 散列表由来
1. 散列表来源于数组，利用数组按照下标随机访问的特性；
2. 需要存储在散列表中的数据称为键，将键转化为数组下标的方法叫做散列函数，散列函数计算的结果叫做散列值，数据内容存储在散列值对应的数组下标位置；
##### 散列冲突的解决方案
1. 开放寻址法
2. 链表法（常用）
