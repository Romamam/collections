import java.util.Objects;

public class LinkedList<T> implements MyCollection<T> {

    static class Node<T>{
        T element;
        Node<T> next;

        public Node(T element){
            this.element = element;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    @Override
    public void add(T element) {

    }

    @Override
    public void add(T element, int index) {
        Node<T> newNode = new Node<>(element);
        if(size == 0){
            first = last = newNode;
        }
        else{
            Node<T> prev = getNodeByIndex(index-1);
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    private Node<T> getNodeByIndex(int index){
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void set(int index, T element){
        Objects.checkIndex(index, size);
        Node<T> node = getNodeByIndex(index);
        node.element = element;
    }
    @Override
    public void add(int index, T element){
        Node<T> newNode = new Node<>(element);
        if(first == null){
            first = last = newNode;
        } else if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else if (index == size) {
            last.next = newNode;
            last = newNode;
        }else {
            Node<T> current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedElement = null;
        if(index == 0){
            removedElement = first.element;
            first = first.next;
            if(first == null){
                last = null;
            }
        }else {
            Node<T> prev = getNodeByIndex(index - 1);
            T element = prev.element;
            prev.next = prev.next.next;
            if(index == size -1){
                last = prev;
            }
        }
        size--;
        return removedElement;
    }

    @Override
    public boolean contains(T element) {
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            if(current.element.equals(element)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T get(int index) {
        return getNodeByIndex(index).element;
    }
}
