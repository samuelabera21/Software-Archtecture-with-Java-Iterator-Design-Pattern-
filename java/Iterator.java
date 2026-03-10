// Iterator interface defines traversal methods
public interface Iterator {

    // Checks if more elements exist in the collection
    public boolean hasNext();

    // Returns the next element in the collection
    public Object next();
}