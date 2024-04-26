import java.util.Iterator;

public class MyStack<T> implements Iterable<T>{
    private MyList<T> list;

    public boolean empty(){
        return list.size()==0;
    }

    public T peek(){
        return list.getLast();
    }

    public T push(T item){
        list.add(item);
        return item;
    }

    public T pop(){
        T last = list.getLast();
        list.removeLast();
        return last;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
