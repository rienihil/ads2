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
        arr.sort();
        arr.print();
        System.out.println(arr.toArray()[0]+"\n");

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
        linked.add(4,3);
        linked.print();
        linked.remove(1);
        linked.print();
        System.out.println(linked.indexOf(4) + " " + linked.lastIndexOf(4));
        System.out.println(linked.exists(1) + " " + linked.exists(12));
        System.out.println(linked.toArray()[0]+"\n");

        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.size());
        System.out.println(queue.peek());
    }
}