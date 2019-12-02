/**
 * 来源:力扣（LeetCode）
 * 链接:https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有.商业转载请联系官方授权,非商业转载请注明出处.
 */
package algorithm;

import java.util.*;

/**
 * @author KevenPotter
 * @company https://github.com/KevenPotter/leecode
 * @date 2019-12-02 14:02:07
 * @description 给定一个大小为n的数组, 找到其中的多数元素.多数元素是指在数组中出现次数大于[n/2]的元素
 * 你可以假设数组是非空的,并且给定的数组总是存在多数元素。
 * 示例1:
 * 输入:[3,2,3]
 * 输出:3
 * 示例2:
 * 输入:[2,2,1,1,1,2,2]
 * 输出:2
 */
public class MajorityElement169 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组:");
        String[] numsStringArray = scanner.nextLine().split(" ");
        Integer[] nums = new Integer[numsStringArray.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(numsStringArray[i]);
        }
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer num : nums) {
            if (null == map.get(num)) {
                map.put(num, 1);
            } else {
                Integer count = map.get(num);
                map.put(num, ++count);
            }
        }
        List<Map.Entry<Integer, Integer>> list = sortMap(map);
        List<Integer> keyList = null;
        for (Map.Entry<Integer, Integer> l : list) {
            keyList = getKey(map, l.getValue());
            break;
        }
        System.out.println(keyList);
    }

    public static List<Map.Entry<Integer, Integer>> sortMap(Map<Integer, Integer> map) {
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return list;
    }

    public static List<Integer> getKey(Map<Integer, Integer> map, Integer value) {
        List<Integer> keyList = new ArrayList<Integer>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == value) {
                keyList.add(key);
            }
        }
        return keyList;
    }

}
