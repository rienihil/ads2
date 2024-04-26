public class MyStack<T> extends MyLinkedList<T>{
    public boolean empty(){
        return size()==0;
    }

    public T peek(){
        return getLast();
    }

    public T push(T item){
        add(item);
        return item;
    }

    public T pop(){
        T last = getLast();
        removeLast();
        return last;
    }
}
