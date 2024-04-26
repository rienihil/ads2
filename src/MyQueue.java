public class MyQueue<T> extends MyLinkedList<T>{
    public boolean empty(){
        return size() == 0;
    }

    public T enqueue(T item){
        add(item);
        return item;
    }

    public T dequeue(){
        T first = getFirst();
        removeFirst();
        return first;
    }

    public T peek(){
        return getFirst();
    }
}
