public interface Stack<E> {

    public abstract boolean isEmpty();
    public abstract E peek();
    public abstract E pop();
    public void push(E element) throws FullStackException;
    public void clear();
}
