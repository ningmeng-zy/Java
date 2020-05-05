import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
示例 1:
输入: [2,2,1]
输出: 1
示例 2:
输入: [4,1,2,1,2]
输出: 4
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/single-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/*
方法一：
public class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for(int i=0;i<nums.length;i++){
            ret ^= nums[i];
        }
        return ret;
    }
}
 */
/*
方法二：
public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<nums.length;++i){
            if(!s.add(nums[i])){
                s.remove(nums[i]);
            }
        }
        Object[] o =s.toArray();
        return (int)o[0];
    }
}
 */
/*
给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
要求返回这个链表的 深拷贝。 
我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/*
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Solution {
    public Node copyRandomList(Node head) {
        if(null == head){
            return null;
        }
        Map<Node,Node> m = new HashMap<>();
        Node node = head;
        while(node != null){
            m.put(node,new Node(node.val));
            node = node.next;
        }
        node = head;
        while(node != null){
            m.get(node).next = m.get(node.next);
            m.get(node).random = m.get(node.random);
            node = node.next;
        }
        return m.get(head);
    }
}
 */
/*
给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
示例 1:
输入: J = "aA", S = "aAAbbbb"
输出: 3
示例 2:
输入: J = "z", S = "ZZ"
输出: 0
注意:
S 和 J 最多含有50个字母。
J 中的字符不重复。
 */
/*
public class Solution{
    public int numJewelsInStones(String J, String S) {
        Map<Character,Integer> m = new HashMap<>();
        for(int i=0;i<S.length();++i){
            char ch = S.charAt(i);
            int count = m.getOrDefault(ch, 0);
            m.put(ch,count+1);
        }
        int jewlesCount = 0;
        for(int i=0;i<J.length();++i){
            jewlesCount += m.getOrDefault(J.charAt(i), 0);
        }
        return jewlesCount;
    }
}
 */