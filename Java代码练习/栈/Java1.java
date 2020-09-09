/*
删除最外层的括号
https://leetcode-cn.com/problems/remove-outermost-parentheses/
有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
*/
class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        char[] ch = S.toCharArray();
        int count = 0;
        for(int i=0;i<S.length();i++){
            if(ch[i] == ')'){
                count--;
            }
            if(count >= 1){
                sb.append(ch[i]);
            }
            if(ch[i] == '('){
                count++;
            }
        }
        return sb.toString();
    }
}

class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();
        char[] ch = S.toCharArray();
        boolean flag = false;
        int start = 0;
        int end = 0;
        for(int i=0;i<ch.length;i++){
            if(ch[i] == '('){
                s.push(ch[i]);
                if(!flag){
                    start = i;
                    flag = true;
                }
            }
            if(ch[i] == ')'){
                s.pop();
                if(s.empty()){
                    end = i;
                    sb.append(S.substring(start+1,end));
                    flag = false;
                    start = end;
                }
            }
        }
        return sb.toString();
    }
}

/*
用两个栈实现队列
https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
(若队列中没有元素，deleteHead 操作返回 -1 )
*/
class CQueue {
    public Stack<Integer> stack1;
    public Stack<Integer> stack2;
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void appendTail(int value) {
        stack1.push(value);
    }
    
    public int deleteHead() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.empty()){
            return -1;
        }else{
            return stack2.pop();
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

/*
化栈为队
https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci/
实现一个MyQueue类，该类用两个栈来实现一个队列。
示例：
MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // 返回 1
queue.pop();   // 返回 1
queue.empty(); // 返回 false
说明：
你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
*/
class MyQueue {
    public Stack<Integer> stack1;
    public Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.empty()){
            return -1;
        }else{
            return stack2.pop();
        }
    }
    
    /** Get the front element. */
    public int peek() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.empty()){
            return -1;
        }else{
            return stack2.peek();
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack1.empty() && stack2.empty()){
            return true;
        }
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

/*
删除字符串中的所有相邻重复项
https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
在 S 上反复执行重复项删除操作，直到无法继续删除。
在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
*/
class Solution {
    public String removeDuplicates(String S) {
        char[] ch = S.toCharArray();
        Stack<Character> s = new Stack<>();
        for(int i=0;i<ch.length;i++){
            if(s.empty()){
                s.push(ch[i]);
            }else{
                if(s.peek() == ch[i]){
                    s.pop();
                }else {
                    s.push(ch[i]);
                }
            }
        }
        StringBuilder str = new StringBuilder();
        Stack<Character> s2 = new Stack<>();
        if(s2.empty()){
            while(!s.empty()){
                s2.push(s.pop());
            }
        }
        while(!s2.empty()){
            str.append(s2.pop());
        }
        return str.toString();
    }
}

/*
下一个更大元素 I
https://leetcode-cn.com/problems/next-greater-element-i/
给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
*/
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ret = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int j=0;
            for(;j<nums2.length;j++){
                if(nums2[j] == nums1[i]){
                    break;
                }
            }
            while(j<nums2.length){
                if(nums2[j]>nums1[i]){
                    ret[i] = nums2[j];
                    break;
                }else{
                    j++;
                }
            }
            if(j == nums2.length){
                ret[i] = -1;
            }
        }
        return ret;
    }
}

public class Solution {
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack< Integer > stack = new Stack < > ();
        HashMap< Integer, Integer > map = new HashMap < > ();
        int[] res = new int[findNums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] > stack.peek())
                map.put(stack.pop(), nums[i]);
            stack.push(nums[i]);
        }
        while (!stack.empty())
            map.put(stack.pop(), -1);
        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] ret = nextGreaterElement(nums1,nums2);
        System.out.println(Arrays.toString(ret));
    }
}