public class IteratorPatternDemo {

    public static void main(String[] args) {

        // Create repository object (collection)
        NameRepository namesRepository = new NameRepository();

        // Get iterator from repository
        for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){

            // Get next element
            String name = (String)iter.next();

            // Print the name
            System.out.println("Name : " + name);
        }
    }
}