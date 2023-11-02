package interfaces;

public interface MyCollection<T> {
    public boolean add(T element);

    public void add(int index, T element);

    public boolean remove(T element);

    public boolean contains(T element);

    public int getSize();

    public boolean isEmpty();

    public T get(int index);
}
