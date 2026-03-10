// // Concrete collection class that stores names
// public class NameRepository implements Container {

//     // Internal data structure (array of names)
//     public String names[] = {"samuel", "Fanos", "Nigus", "Kalkidan"};

//     // Method that returns iterator
//     @Override
//     public Iterator getIterator() {
//         return new NameIterator();
//     }

//     // Inner class implementing Iterator
//     private class NameIterator implements Iterator {

//         int index;

//         // Check if next element exists
//         @Override
//         public boolean hasNext() {

//             if(index < names.length){
//                 return true;
//             }
//             return false;
//         }

//         // Return next element
//         @Override
//         public Object next() {

//             if(this.hasNext()){
//                 return names[index++];
//             }

//             return null;
//         }
//     }
// }


// Concrete collection class that stores names
public class NameRepository implements Container {

    // Internal data structure (array storing names)
    public String names[] = {"Samuel", "Fanos", "Nigus", "Kalkidan"};

    // Method that returns an iterator
    @Override
    public Iterator getIterator() {
        System.out.println("\nRepository: Creating Iterator object...");
        return new NameIterator(); // return iterator instance
    }

    // Inner class implementing Iterator
    private class NameIterator implements Iterator {

        // Index that tracks current position in the array
        int index = 0;

        // Constructor (runs when iterator is created)
        public NameIterator(){
            System.out.println("Iterator created.");
            System.out.println("Initial Index Position = " + index);
        }

        // Method to check if another element exists
        @Override
        public boolean hasNext() {

            System.out.println("\nChecking hasNext()...");
            System.out.println("Current index = " + index);
            System.out.println("Total elements = " + names.length);

            if(index < names.length){
                System.out.println("Result: TRUE → More elements exist");
                return true;
            }

            System.out.println("Result: FALSE → End of collection reached");
            return false;
        }

        // Method that returns next element
        @Override
        public Object next() {

            System.out.println("Calling next()...");

            if(this.hasNext()){

                String currentName = names[index];

                System.out.println("Returning element at index " + index + " : " + currentName);

                index++; // move pointer forward

                System.out.println("Pointer moved to index = " + index);

                return currentName;
            }

            return null;
        }
    }
}