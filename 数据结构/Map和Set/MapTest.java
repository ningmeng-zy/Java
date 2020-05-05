import java.util.*;

/**
 * @ClassName MapTest
 * @Description TODO MapTest
 * @Author 张洋
 * @Date 2020/4/14 19:30
 * @Version 2018.1.5
 **/
public class MapTest {
    public static void testTreeMap() {
        Map<String,String> m1 = new TreeMap<>();
        m1.put("peach","桃子");//插入键值对
        m1.put("orange","橘子");
        System.out.println(m1.put("apple","苹果"));
        System.out.println(m1.size());
        System.out.println(m1);
        //验证key是否可以重复
        //如果key不存在，将该key-value组成的键值对插入
        //如果key存在，使用value替换原key所对应的value
        //在插入key-value期间，Map会保证key是一个有序的序列---延伸期间肯定要对key进行比较----->
        //延伸:如果key是自定义 类型的元素，该类的对象必须要能够比大小--->实现Comparable接口Comparator
        //返回值：如果key不存在，将该键值对插入，返回null
        //        如果key存在，用value覆盖原key的value
        System.out.println(m1.put("orange","橙子"));
        System.out.println(m1.size());
        System.out.println(m1);

        //key是一定不能为空的，如果为空会抛NullPointerException--->原因：key为空无法进行比较
        //m1.put(null,"无名");
        //value可以为空
        m1.put("banana",null);
        System.out.println(m1.size());
        System.out.println(m1);
        // get(key)
        //如果key存在，返回与key所对应的value
        //如果key 不存在，返回null
        //如果key 是null，抛出Nul LPointerException
        System.out.println(m1.get("apple"));
        System.out.println(m1.get("watermelon"));
       // System.out.println(m1.get(null));

        System.out.println(m1.getOrDefault("apple","苹果手机"));
        System.out.println(m1.getOrDefault("watermelon","西瓜"));
        System.out.println(m1.size());
        //remove(key):将Map中key所对应的键值对删除掉。
        //如果key存在，删除该键值对，然后返回该键值对中的value
        //如果key不存在，直接返回null
       System.out.println(m1);
        System.out.println(m1.remove("banananaan"));
        if (m1.containsKey("banana")){
            System.out.println("banana is in map!!!");
        }else {
            System.out.println("banana is not in map!!!");
        }
        System.out.println(m1.remove("banana"));
        System.out.println(m1);
        if (m1.containsValue("苹果")){
            System.out.println("有");
        }else {
            System.out.println("没有");
        }
        if (m1.containsValue("草莓")){
            System.out.println("有");
        }else {
            System.out.println("没有");
        }
        //打印所有的key
        for (String s : m1.keySet()){
            System.out.println(s+" ");
        }
        //打印所有的value
        for (String s : m1.values()){
            System.out.println(s+" ");
        }
        //打印所有的键值对
        for (Map.Entry<String,String> e : m1.entrySet()){
            System.out.println(e.getKey() + "---->" + e.getValue());
        }
    }
    public static void testHashMap() {
        Map<String,String> m1 = new HashMap<>();
        m1.put("peach","桃子");//插入键值对
        m1.put("orange","橘子");
        System.out.println(m1.put("apple","苹果"));
        System.out.println(m1.size());
        System.out.println(m1);
        //验证key是否可以重复
        //如果key不存在，将该key-value组成的键值对插入
        //如果key存在，使用value替换原key所对应的value
        //在插入key-value期间，Map会保证key是一个有序的序列---延伸期间肯定要对key进行比较----->
        //延伸:如果key是自定义 类型的元素，该类的对象必须要能够比大小--->实现Comparable接口Comparator
        //返回值：如果key不存在，将该键值对插入，返回null
        //        如果key存在，用value覆盖原key的value
        System.out.println(m1.put("orange","橙子"));
        System.out.println(m1.size());
        System.out.println(m1);

        //key是一定不能为空的，如果为空会抛NullPointerException--->原因：key为空无法进行比较
        //m1.put(null,"无名");
        //value可以为空
        m1.put("banana",null);
        System.out.println(m1.size());
        System.out.println(m1);
        // get(key)
        //如果key存在，返回与key所对应的value
        //如果key 不存在，返回null
        //如果key 是null，抛出Nul LPointerException
        System.out.println(m1.get("apple"));
        System.out.println(m1.get("watermelon"));
        // System.out.println(m1.get(null));

        System.out.println(m1.getOrDefault("apple","苹果手机"));
        System.out.println(m1.getOrDefault("watermelon","西瓜"));
        System.out.println(m1.size());
        //remove(key):将Map中key所对应的键值对删除掉。
        //如果key存在，删除该键值对，然后返回该键值对中的value
        //如果key不存在，直接返回null
        System.out.println(m1);
        System.out.println(m1.remove("banananaan"));
        if (m1.containsKey("banana")){
            System.out.println("banana is in map!!!");
        }else {
            System.out.println("banana is not in map!!!");
        }
        System.out.println(m1.remove("banana"));
        System.out.println(m1);
        if (m1.containsValue("苹果")){
            System.out.println("有");
        }else {
            System.out.println("没有");
        }
        if (m1.containsValue("草莓")){
            System.out.println("有");
        }else {
            System.out.println("没有");
        }
        //打印所有的key
        for (String s : m1.keySet()){
            System.out.println(s+" ");
        }
        //打印所有的value
        for (String s : m1.values()){
            System.out.println(s+" ");
        }
        //打印所有的键值对
        for (Map.Entry<String,String> e : m1.entrySet()){
            System.out.println(e.getKey() + "---->" + e.getValue());
        }
    }
    public static void testTreeSet(){
        Set<String> s = new TreeSet<>();
        System.out.println(s.add("orange"));
        System.out.println(s.add("peach"));
        System.out.println(s.add("apple"));
        System.out.println(s.size());
        System.out.println(s);
        System.out.println(s.add("apple"));
        System.out.println(s);
        if (s.contains("watermelon")){
            System.out.println("在");
        }else {
            System.out.println("不在");
        }
        if (s.contains("apple")){
            System.out.println("在");
        }else {
            System.out.println("不在");
        }
        //遍历
        Iterator<String> it = s.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(s.remove("watermelon"));
        System.out.println(s.remove("apple"));
        s.clear();
    }
    public static void testHashSet(){
        Set<String> s = new HashSet<>();
        System.out.println(s.add("orange"));
        System.out.println(s.add("peach"));
        System.out.println(s.add("apple"));
        System.out.println(s.size());
        System.out.println(s);
        System.out.println(s.add("apple"));
        System.out.println(s);
        if (s.contains("watermelon")){
            System.out.println("在");
        }else {
            System.out.println("不在");
        }
        if (s.contains("apple")){
            System.out.println("在");
        }else {
            System.out.println("不在");
        }
        //遍历
        Iterator<String> it = s.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(s.remove("watermelon"));
        System.out.println(s.remove("apple"));
        s.clear();
    }
    public static void main(String[] args){
        testHashSet();
    }
}
