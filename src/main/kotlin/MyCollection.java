public interface MyCollection<T> {
    void add(T element);


    void add(T element, int index);

    void add(int index, T element);
    boolean remove(T element);

    T remove(int index);

    boolean contains(T element);
    int size();
    boolean isEmpty();
    T get(int index);
}

