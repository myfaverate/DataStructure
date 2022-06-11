package edu.tyut.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        // 创建广播电台，放入Map
        HashMap<String, HashSet<String>> broadCasts = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        // 加入到map
        broadCasts.put("K1",hashSet1);
        broadCasts.put("K2",hashSet2);
        broadCasts.put("K3",hashSet3);
        broadCasts.put("K4",hashSet4);
        broadCasts.put("K5",hashSet5);

        HashSet<String> allAreas = new HashSet<>();

        hashSet1.forEach((value)->allAreas.add(value));
        hashSet2.forEach((value)->allAreas.add(value));
        hashSet3.forEach((value)->allAreas.add(value));
        hashSet4.forEach((value)->allAreas.add(value));
        hashSet5.forEach((value)->allAreas.add(value));

        allAreas.forEach((value)-> System.out.println(value));

        // 创建ArrayList，存放选择的电台集合
        ArrayList<String> selects = new ArrayList<>();
        String maxKey = null;
        HashSet<String> tmpSet = new HashSet<>();
        while (allAreas.size()!=0){
            maxKey=null;
            // 遍历broadcasts，取出对应的key
            for (String key : broadCasts.keySet()) {
                tmpSet.clear();
                // 当前这个key能够覆盖的地区
                HashSet<String> areas = broadCasts.get(key);
                tmpSet.addAll(areas);
                tmpSet.retainAll(allAreas);
                if (tmpSet.size()>0&&(maxKey==null||tmpSet.size()>broadCasts.get(maxKey).size())){
                    maxKey=key;
                }
            }
            // maxKey!=null，就应该将maxKey加入到selects
            if (maxKey!=null){
                selects.add(maxKey);
                // 将maxKey指向的广播电台覆盖的地区，从allAreas去掉
                allAreas.removeAll(broadCasts.get(maxKey));
            }
        }
        System.out.println("得到的结果是"+selects);
    }
}
