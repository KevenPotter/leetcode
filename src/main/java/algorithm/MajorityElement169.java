/**
 * 来源:力扣(LeetCode)
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
        majorityElement6(nums);
    }

    /**
     * @param nums 整型数组
     * @author KevenPotter
     * @date 2019-12-03 09:53:14
     * @description 给定一个大小为n的数组, 找到其中的多数元素.多数元素是指在数组中出现次数最多的元素
     * 你可以假设数组是非空的,并且给定的数组总是存在多数元素。
     * 示例1:
     * 输入:[3,2,3]
     * 输出:3
     * 示例2:
     * 输入:[2,2,1,1,1,2,2]
     * 输出:2
     * 示例3:
     * 输入:[1,1,2,2,3,3,4,1,2]
     * 输出:1,2
     */
    public static void majorityElement6(Integer[] nums) {
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

    /**
     * @param map 字典
     * @return 返回排序后的列表
     * @date 2019-12-03 09:11:28
     * @author KevenPotter
     * @description 该方法旨在将传入的字典按照值(value)大小进行排序
     * 整体思路是:
     * 1.由于HashMap不属于List子类,所以无法使用Collections.sort方法来进行排序,我已我们将HashMap中的entrySet取出放入一个
     * ArrayList中来对ArrayList中的entrySet进行排序(根据entrySet中value的值),达到我们队HashMap的值进行排序的效果;
     * 2.对ArrayList进行排序,并通过Comparator传入自定义的排序规则.其中<0表示升序,>0表示降序;
     * 3.将排序后的ArrayList返回
     */
    public static List<Map.Entry<Integer, Integer>> sortMap(Map<Integer, Integer> map) {
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return list;
    }

    /**
     * @param map   字典
     * @param value 值
     * @return 返回字典键集合
     * @date 2019-12-03 09:12:49
     * @author KevenPotter
     * @description 该方法旨在依据值(Value)来获取HashMap的键列表
     * 整体思路是:
     * 1.创建一个ArrayList用于接收找到的Key;
     * 2.对传入的map获取其键集合,并对其进行遍历.没遍历一次就获取该键(Key)所对应的值(Value),并且将获取到的值(Value)与传入的值(
     * Value)做比较,如果相同的话,就将此时此刻遍历的键(Key)存入到ArrayList集合中并返回
     */
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
