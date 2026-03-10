// Concrete collection class that stores names
public class NameRepository implements Container {

    // Internal data structure (array of names)
    public String names[] = {"samuel", "Fanos", "Nigus", "Kalkidan"};

    // Method that returns iterator
    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    // Inner class implementing Iterator
    private class NameIterator implements Iterator {

        int index;

        // Check if next element exists
        @Override
        public boolean hasNext() {

            if(index < names.length){
                return true;
            }
            return false;
        }

        // Return next element
        @Override
        public Object next() {

            if(this.hasNext()){
                return names[index++];
            }

            return null;
        }
    }
}