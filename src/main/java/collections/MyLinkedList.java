package collections;


import interfaces.MyCollection;

import java.util.Objects;

public class MyLinkedList<T> implements MyCollection<T> {

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


    public boolean add(T element) {
        Node<T> newNode = new Node<>(element);
        if(size == 0){
            first = last = newNode;
        }
        else{
            last.next = newNode;
            last = newNode;
        }
        size++;
        return true;
    }

    private Node<T> getNodeByIndex(int index){
        Objects.checkIndex(index, size);
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
            Node<T> prev = getNodeByIndex(index-1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }


    public T removeIndex(int index) {
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

    public boolean remove(T element){
        if(element == null){
            Node<T> current = first;
            Node<T> prev = null;

            while (current != null){
                if(Objects.equals(element, current.element)) {
                    unLink(current, prev);
                    return true;
                }
                prev = current;
                current = current.next;
            }
        }else {
            Node<T> current = first;
            Node<T> prev = null;

            while (current != null) {
                if (element.equals(current.element)) {
                    unLink(current, prev);
                    return true;
                }
                prev = current;
                current = current.next;
            }
        }
        return false;
    }

    private void unLink(Node<T> current, Node<T> prev) {
        if(current.element == null){
            if (prev == null) {
                first = current.next;
            } else {
                prev.next = current.next;
            }

            if (current.next == null) {
                last = prev;
            }
            size--;
        }
    }

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

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).element;
    }
}
