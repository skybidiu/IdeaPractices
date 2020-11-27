package com.leetcode.dailyexercise;

import java.util.ArrayList;
import java.util.Arrays;

public class Day04 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];

        boolean cover = false;
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] curr : intervals){
            if(curr[0] > right){
                if(!cover){
                    list.add(new int[]{left, right});
                    cover = true;
                }
                list.add(curr);
            } else if(curr[1] < left){
                list.add(curr);
            } else{
                left = Math.min(left, curr[0]);
                right = Math.max(right, curr[1]);

            }
        }
        if(!cover){
            list.add(new int[]{left, right});
        }
        int size = list.size();
        int[][] res = new int[size][2];
        for(int i = 0; i < size; i++){
            res[i] = list.get(i);
        }
        return res;
    }
    public static void main(String[] args) {

        /**
         * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
         *
         * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
         *
         *  
         *
         * 示例 1：
         *
         * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
         * 输出：[[1,5],[6,9]]
         * 示例 2：
         *
         * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
         * 输出：[[1,2],[3,10],[12,16]]
         * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/insert-interval
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        String status = "Accepted";


        int[] test = {1,2,3,4,5,6};
        int[][] multi = new int[3][];
        multi[0] = new int[3];
        multi[1] = new int[4];
        multi[2] = new int[5];

        //Arrays.fill填充一维数组
        //Arrays.fill(multi, 5);//二维数组会报错，不可取
        for(int i = 0; i < multi.length; i++){
            Arrays.fill(multi[i], i);
        }
        for(int i = 0; i < multi.length; i++){
            for (int j = 0; j < multi[i].length; j++){
                System.out.print(multi[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("=============");
        //Array.equals判断两个同类型数组是否相等
        System.out.println("multi[0] == multi[1] ? " + Arrays.equals(multi[0], multi[1]));
        int[] same = {0,0,0};
        System.out.println("multi[0] == same ? " + Arrays.equals(multi[0], same));
        same[2] = 1;
        System.out.println("change same[2] = 1");
        System.out.println("multi[0] == same ? " + Arrays.equals(multi[0], same));
        System.out.println("=============");
        //Arrays.sort默认升序，优化后的快排
        int[] chaos = {5,2,9,3,7,1,8,4,6,0};
        Arrays.sort(chaos);
        System.out.println(Arrays.toString(chaos));
        //尝试降序的方法:无法处理基本数据类型，需要转换成相对应的包装类型
        //暂时想到的方法是先使用Arrays.sort，再自行编写反转函数
        System.out.println("=============");

        //binarySearch二分查找,数组调用前必须是排序好的，如果找到，返回索引，找不到，返回(-(插入点）-1）
        //因此插入点等于 -（return+1）
        System.out.println("查询8的索引下表位置：" + Arrays.binarySearch(chaos, 8));
        System.out.println("查询10的索引下表位置：" + Arrays.binarySearch(chaos, 10));
    }
}
