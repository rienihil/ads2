import java.util.Iterator;

public class MyQueue<T> implements Iterable<T>{
    private MyLinkedList<T> list;

    public boolean empty(){
        return list.size() == 0;
    }

    public T enqueue(T item){
        list.add(item);
        return item;
    }

    public T dequeue(){
        T first = list.getFirst();
        list.removeFirst();
        return first;
    }

    public T peek(){
        return list.getFirst();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
