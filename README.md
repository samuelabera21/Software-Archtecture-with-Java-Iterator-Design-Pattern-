# Iterator Pattern Java Demos

This workspace contains two Java demonstrations of the Iterator Design Pattern:

- A Swing-based university course iterator demo.
- A console-based GoF-style iterator demo in the `java/` folder.

## Project Structure

- `UniversityIteratorDemo.java`: Swing application with forward and reverse traversal.
- `java/Container.java`: Aggregate interface.
- `java/Iterator.java`: Iterator interface.
- `java/NameRepository.java`: Concrete collection with inner concrete iterator.
- `java/IteratorPatternDemo.java`: Console client for the custom iterator interfaces.

## Requirements

- JDK 8+ installed.
- `javac` and `java` available in your terminal PATH.

## Run Demo 1: Swing University Iterator

From the project root:

```bash
javac UniversityIteratorDemo.java
java UniversityIteratorDemo
```

What it does:

- Prompts for the number of courses.
- Collects course names.
- Displays traversal output using:
	- Forward iterator (`courses.iterator()`).
	- Reverse custom iterator (`ReverseCourseIterator`).

## Run Demo 2: Console GoF Iterator Example

From the project root:

```bash
cd java
javac *.java
java IteratorPatternDemo
```

What it does:

- Creates a `NameRepository` collection.
- Gets an iterator via `getIterator()`.
- Loops with `hasNext()` and `next()` to print each name.

## Iterator Pattern Mapping

Swing demo (`UniversityIteratorDemo.java`):

- Aggregate: `CourseCollection`
- Iterator type: Java built-in `Iterator<String>`
- Concrete iterators:
	- Forward list iterator
	- Reverse custom iterator `ReverseCourseIterator`
- Client: `UniversityIteratorDemo`

Console demo (`java/`):

- Aggregate interface: `Container`
- Iterator interface: `Iterator`
- Concrete aggregate: `NameRepository`
- Concrete iterator: `NameRepository.NameIterator`
- Client: `IteratorPatternDemo`

## Troubleshooting

- `javac` or `java` not found:
	- Verify JDK installation and PATH configuration.
- Class not found when running console demo:
	- Run `java IteratorPatternDemo` from inside the `java` folder.
- UI does not appear:
	- Ensure you are running `UniversityIteratorDemo` on a desktop session with GUI support.
