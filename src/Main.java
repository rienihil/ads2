public class Main {
    public static void main(String[] args) {
        MyArrayList <Integer> arr = new MyArrayList<>();
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        System.out.println("size: "+ arr.size());
        arr.print();
        arr.addFirst(-1);
        arr.addLast(6);
        arr.set(1,6);
        arr.add(10,1);
        arr.remove(2);
        System.out.println("size: "+ arr.size());
        arr.print();
    }
}