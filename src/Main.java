public class Main {
    public static void main(String[] args) {
        MyArrayList <Integer> arr = new MyArrayList<>();
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.print();
        arr.addFirst(-1);
        arr.set(1,6);
        arr.add(10,1);
        arr.remove(2);
        arr.print();

        MyLinkedList<Integer> linked = new MyLinkedList<>();
        linked.add(0);
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.add(5);
        linked.print();
        System.out.println(linked.getLast());
        System.out.println(linked.get(2));
        linked.addFirst(-1);
        linked.add(10,3);
        linked.print();
    }
}