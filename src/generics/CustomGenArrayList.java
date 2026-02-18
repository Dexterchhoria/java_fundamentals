//package generics;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class CustomGenArrayList<T> {
////    private T[] data;
////    private static int DEFAULT_SIZE = 10;
////    private int size = 0; //also working as index value
////
////    public CustomGenArrayList() {
////        this.data = new T[DEFAULT_SIZE];
////    }
////    public void add(T num){
////        if(isFull()){
////            resize();
////        }
////        data[size++] = num;
////    }
////
////    private void resize(){
////        int[] temp = new int[data.length *2];
////
////        //copy the current items into the temp
////        for(int i=0 ;i<data.length;i++){
////            temp[i]= data[i];
////        }
////        data = temp;
////    }
////
////    private boolean isFull(){
////        return size==data.length;
////    }
////
////    public int remove(){
////        int removed= data[--size];
////        return removed;
////    }
////
////    public int get(int index){
////        return data[index];
////    }
////    public int size(){
////        return size;
////    }
////    public void set(int index, int value){
////        data[index] = value;
////    }
////
////
////    @Override
////    public String toString() {
////        return "CustomArrayList{" +
////                "data=" + Arrays.toString(data) +
////                ", size=" + size +
////                '}';
////    }
////
////    public static void main(String[] args) {
//////        ArrayList<Integer> list = new ArrayList<>();
//////        list.add(45);
//////        list.add(5);
//////       list.get(0);
//////        System.out.println(list);
////
//////        Integer y = 5;
//////        Integer x = (Integer)10;  // primitive -> object cast nhi hota ,
//////        // but not error as compile time mei autoboxing hoke rewrite hogya
//////        System.out.println(x);
//////        System.out.println(y);
////        CustomArrayList list = new CustomArrayList();
//////        list.add(3);
//////        list.add(5);
//////        list.add(9);
////        for(int i=0;i<14;i++){
////            list.add(2*i);
////        }
////        System.out.println(list);
////
////        //generics help us to define the type parameter
////        //only classes in generics
////        ArrayList<Integer>list2 = new ArrayList<>();
////        list2.add(5);
//
//    }
//}
//
