/*
public class SeqList {
     // 打印顺序表
     public void display() {   }
     // 在 pos 位置新增元素
     public void add(int pos, int data) { }
     // 判定是否包含某个元素
     public boolean contains(int toFind) { return true; }
     // 查找某个元素对应的位置
     public int search(int toFind) { return -1; }
     // 获取 pos 位置的元素
     public int getPos(int pos) { return -1; }
     // 给 pos 位置的元素设为 value
     public void setPos(int pos, int value) {   }
     //删除第一次出现的关键字key
     public void remove(int toRemove) {   }
     // 获取顺序表长度
     public int size() { return 0; }
     // 清空顺序表
     public void clear() {   }
 }
 */
 class MyArrayList {
    public int[] elem;
    public int usedSize;
    public final int CAPACITY=10;
    public MyArrayList(){
        this.usedSize=0;
        this.elem=new int[CAPACITY];
    }
    //判断顺序表是否满了
    private boolean isFull(){
        if (this.usedSize==this.elem.length){
            return true;
        }
        return false;
    }
    //在 pos 位置新增元素
    public void add(int pos, int data){
       if (isFull()){
           this.elem=Arrays.copyOf(this.elem,this.elem.length*2);
       }
       //pos位置是否合法
        if (pos<0||pos>this.usedSize){
            System.out.println("pos位置不合法");
            return;
        }
        //挪数据
        for (int i=this.usedSize-1;i>=pos;i--){
           this.elem[i+1]=this.elem[i];
        }
        //插入数据
        this.elem[pos]=data;
       //usedSize++
        this.usedSize++;
    }
    //判定是否包含某个元素
    public boolean contains(int toFind){
        for (int i=0;i<this.usedSize;i++){
            if (this.elem[i]==toFind){
                return true;
            }
        }
        return false;
    }
    //查找某个元素对应的位置
    public int search(int toFind){
        for (int i=0;i<this.usedSize;i++){
            if (this.elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }
    //获取 pos 位置的元素
    public int getPos(int pos){
        if (pos<0||pos>this.usedSize){
            return -1;
        }
        return this.elem[pos];
    }
    //获取顺序表长度
    public int size(){
        return this.usedSize;
    }
    //清空顺序表
    public void clear(){
        this.usedSize=0;
    }
    //判断顺序表是否为空
    private boolean isEmpty(){
        return this.usedSize==0;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove){
        //顺序表是否为空；
        if (isEmpty()){
            System.out.println("顺序表为空");
            return;
        }
        //查找toRemove的下标；
        int index=search(toRemove);
        if (index==-1){
            System.out.println("没有你要删除的数字！");
            return;
        }
        //删除
        for (int i=index;i<this.usedSize;i++){
            this.elem[i]=this.elem[i+1];
        }
        this.usedSize--;
    }
    //打印顺序表
    public void display(){
        for (int i=0;i<this.usedSize;i++){
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
}
public class Test4 {
    public static void main(String[] args) {
        MyArrayList myArrayList=new MyArrayList();
        myArrayList.add(0,1);
        myArrayList.add(0,2);
        myArrayList.add(0,3);
        myArrayList.add(1,4);
        myArrayList.add(0,5);
        myArrayList.display();
        myArrayList.remove(4);
        myArrayList.display();
    }
}