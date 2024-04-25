import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>{

    private class MyNode<T> {
        T item;
        MyNode<T> next;
        MyNode<T> prev;

        public MyNode(T item) {
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }

    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(T item) {
        MyNode<T> node= new MyNode<>(item);
        if (head == null){
            head=node;
        }
        else{
            node.prev = tail;
            tail.next=node;
        }
        tail = node;
        size++;
    }

    @Override
    public void set(T item, int index) {
        getNode(index).item=item;
    }

    @Override
    public void add(T item, int index) {
        checkIndex(index);
        MyNode<T> node = new MyNode<>(item);
        if (index==0){
            addFirst(item);
        }
        else if (index==size-1){
            add(item);
        }
        else {
            getNode(index).prev=node;
            node.next=getNode(index);
            getNode(index-1).next=node;
            node.prev=getNode(index-1);
        }
        size++;
    }

    @Override
    public void addFirst(T item) {
        MyNode<T> node = new MyNode<>(item);
        node.next=head;
        head.prev=node;
        head=node;
        size++;
    }

    private void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index not correct");
        }
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        MyNode<T> current = head;
        int i = 0;
        while (current != null) {
            if (i == index) {
                return current.item;
            }
            i++;
            current = current.next;
        }
        return null;
    }

    private MyNode<T> getNode(int index) {
        checkIndex(index);
        MyNode<T> current = head;
        int i = 0;
        while (current != null) {
            if (i == index) {
                return current;
            }
            i++;
            current = current.next;
        }
        return null;
    }

    @Override
    public T getFirst() {
        return head.item;
    }

    @Override
    public T getLast() {
        return tail.item;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if (index==0){
            removeFirst();
        }
        else if (index==size-1){
            removeLast();
        }
        else{
            getNode(index+1).prev=getNode(index-1);
            getNode(index-1).next=getNode(index+1);
        }
        size--;
    }

    @Override
    public void removeFirst() {
        head=head.next;
        size--;
    }

    @Override
    public void removeLast() {
        tail=tail.prev;
        size--;
    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        MyNode<T> current = head;
        int i=0;
        while (current!=null){
            if (current.item==(T)object){
                return i;
            }
            i++;
            current=current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> current = tail;
        int i = size-1;
        while (current!=null){
            if (current.item==object){
                return i;
            }
            i--;
            current=current.prev;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        MyNode<T> current = head;
        while (current!=null){
            if (current.item==object){
                return true;
            }
            current=current.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        T[] arr = (T[]) new Object[size];
        for (int i=0; i<size; i++){
            arr[i]=get(i);
        }
        return arr;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public void print() {
        MyNode<T> current = head;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.print('\n');
    }
    public void printBack() {
        MyNode<T> current = tail;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.prev;
        }
        System.out.print('\n');
    }
}
