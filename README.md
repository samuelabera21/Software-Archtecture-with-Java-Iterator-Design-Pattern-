# Iterator Design Pattern Demo (Java Swing)

**Project Name:** Iterator Design Pattern  
**Presenter:** Samuel Abera Mekonn

This project demonstrates the **Iterator Design Pattern** using a simple Java Swing UI.
You enter course names, then the app shows traversal output in:
- **Forward order** using Java built-in iterator
- **Reverse order** using a custom iterator

---

## 1) Project Files

- `UniversityIteratorDemo.java` – main app (UI + demo logic)
- `CourseCollection.class` – compiled aggregate class
- `ReverseCourseIterator.class` – compiled custom iterator
- `UniversityIteratorDemo.class` – compiled main class

---

## 2) Requirements

- Java JDK installed (you already have Eclipse Adoptium JDK)
- Terminal opened in project folder:
  - `C:/Users/hp/Desktop/javaarchtecture`

---

## 3) How to Run

Run these commands in terminal:

```bash
javac UniversityIteratorDemo.java
java UniversityIteratorDemo
```

Or one line:

```bash
javac UniversityIteratorDemo.java && java UniversityIteratorDemo
```

---

## 4) What the UI Shows

### Input Dialogs
Large, clear dialogs display:
- Project title: **Iterator Design Pattern**
- Presenter name: **Samuel Abera Mekonn**
- Course input prompt

### Output Window
A large window shows:
- Project name
- Presenter name
- Forward traversal steps (`hasNext()`, `next()`)
- Reverse traversal steps (`hasNext()`, `next()`)

---

## 5) Iterator Pattern Mapping (for presentation)

- **Aggregate:** `CourseCollection`
  - Stores internal list of courses
  - Provides iterator creation methods
- **Iterator Interface:** Java `Iterator<String>`
- **Concrete Iterators:**
  - Forward: built-in list iterator (`courses.iterator()`)
  - Reverse: custom `ReverseCourseIterator`
- **Client:** `UniversityIteratorDemo`
  - Uses iterators without exposing list internals

---

## 6) Short Presentation Script (1–2 minutes)

1. “This project demonstrates the Iterator Design Pattern in Java.”
2. “`CourseCollection` is the aggregate that stores courses.”
3. “For forward traversal, I use Java’s built-in iterator.”
4. “For reverse traversal, I implemented `ReverseCourseIterator`.”
5. “The client code does not access list internals directly; it only uses iterator methods (`hasNext`, `next`).”
6. “The Swing UI makes input and traversal output clean and easy to present.”

---

## 7) Sample Demo Data

- Software Architecture
- Artificial Intelligence
- Machine Learning

---

## 8) Troubleshooting

### Error: command not found (`javac` or `java`)
- Ensure JDK is installed and added to PATH.

### Old output appears
- Recompile before run:
  - `javac UniversityIteratorDemo.java`

### UI not opening
- Check if another Java process is still running and close it, then run again.

---

## 9) Exit

- Click **Cancel** in input dialog to stop.
- Close the output window to finish the app.
