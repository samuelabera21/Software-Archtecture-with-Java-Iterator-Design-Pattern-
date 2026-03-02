import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;

// -------------------- Aggregate Class --------------------
class CourseCollection {

    // Internal data structure (hidden from client)
    private List<String> courses = new ArrayList<>();

    // Method to add a course into collection
    public void addCourse(String course) {
        courses.add(course);
    }

    // Method to return built-in forward iterator
    public Iterator<String> createForwardIterator() {
        return courses.iterator();  // Java built-in iterator
    }

    // Method to return custom reverse iterator
    public Iterator<String> createReverseIterator() {
        return new ReverseCourseIterator(courses);
    }
}

// -------------------- Custom Reverse Iterator --------------------
class ReverseCourseIterator implements Iterator<String> {

    private List<String> courses;   // Reference to collection
    private int position;           // Current index position

    // Constructor initializes starting position (last element)
    public ReverseCourseIterator(List<String> courses) {
        this.courses = courses;
        this.position = courses.size() - 1;
    }

    // Checks if more elements exist
    @Override
    public boolean hasNext() {
        return position >= 0;
    }

    // Returns current element and moves backward
    @Override
    public String next() {
        return courses.get(position--);
    }
}

// -------------------- Main Class --------------------
public class UniversityIteratorDemo {

    private static final String PROJECT_NAME = "Iterator Design Pattern";
    private static final String PRESENTER_NAME = "Samuel Abera Mekonn";

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try {
                showIteratorDemoUI();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(
                        null,
                        "Something went wrong: " + exception.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }

    private static void showIteratorDemoUI() {

        CourseCollection collection = new CourseCollection();

        Integer numberOfCourses = askCourseCount();
        if (numberOfCourses == null) {
            return;
        }

        for (int i = 1; i <= numberOfCourses; i++) {
            String course = askCourseName(i);
            if (course == null) {
                return;
            }
            collection.addCourse(course);
        }

        String output = buildTraversalOutput(collection);
        showOutputWindow(output);
    }

    private static Integer askCourseCount() {

        while (true) {
            String input = showLargeInputDialog(
                    "Course Setup",
                    "How many courses do you want to enter?"
            );

            if (input == null) {
                return null;
            }

            input = input.trim();
            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a number.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                continue;
            }

            try {
                int value = Integer.parseInt(input);
                if (value <= 0) {
                    JOptionPane.showMessageDialog(null, "Enter a number greater than 0.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    continue;
                }
                return value;
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private static String askCourseName(int index) {

        while (true) {
            String course = showLargeInputDialog(
                "Course Input",
                "Enter course " + index + ":"
            );

            if (course == null) {
                return null;
            }

            course = course.trim();
            if (course.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Course name cannot be empty.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                continue;
            }

            return course;
        }
    }

    private static String buildTraversalOutput(CourseCollection collection) {

        StringBuilder builder = new StringBuilder();
        builder.append("Project Name: ").append(PROJECT_NAME).append("\n");
        builder.append("Presented By: ").append(PRESENTER_NAME).append("\n");
        builder.append("==== University Course Management System ====\n\n");

        builder.append("--- Forward Traversal Using Built-in Iterator ---\n");

        Iterator<String> forwardIterator = collection.createForwardIterator();
        int step = 1;

        while (forwardIterator.hasNext()) {
            builder.append("Iteration Step ").append(step).append("\n");
            builder.append("hasNext() = true\n");
            builder.append("next() returns: ").append(forwardIterator.next()).append("\n");
            builder.append("----------------------------\n");

            step++;
        }

        builder.append("\n--- Reverse Traversal Using Custom Iterator ---\n");

        Iterator<String> reverseIterator = collection.createReverseIterator();
        step = 1;

        while (reverseIterator.hasNext()) {
            builder.append("Iteration Step ").append(step).append("\n");
            builder.append("hasNext() = true\n");
            builder.append("next() returns: ").append(reverseIterator.next()).append("\n");
            builder.append("----------------------------\n");

            step++;
        }

        return builder.toString();
    }

    private static void showOutputWindow(String output) {

        JTextArea outputArea = new JTextArea(output);
        outputArea.setEditable(false);
        outputArea.setLineWrap(false);
        outputArea.setWrapStyleWord(false);
        outputArea.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        outputArea.setMargin(new Insets(12, 12, 12, 12));

        JScrollPane scrollPane = new JScrollPane(outputArea);

        JLabel projectTitle = new JLabel("Project: " + PROJECT_NAME);
        projectTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));

        JLabel presenterInfo = new JLabel("Presented By: " + PRESENTER_NAME);
        presenterInfo.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        JLabel projectInfo = new JLabel("University Course Management System - Iterator Demo Output");
        projectInfo.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        JPanel titlePanel = new JPanel(new GridLayout(3, 1));
        titlePanel.add(projectTitle);
        titlePanel.add(presenterInfo);
        titlePanel.add(projectInfo);

        JPanel mainPanel = new JPanel(new BorderLayout(12, 12));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(14, 14, 14, 14));
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JFrame frame = new JFrame("Iterator Design Pattern Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 760);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }

    private static String showLargeInputDialog(String title, String question) {

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        JLabel projectLabel = new JLabel("Project: " + PROJECT_NAME);
        projectLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));

        JLabel presenterLabel = new JLabel("Presented By: " + PRESENTER_NAME);
        presenterLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JLabel questionLabel = new JLabel(question);
        questionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        JTextField inputField = new JTextField(24);
        inputField.setFont(new Font("Segoe UI", Font.PLAIN, 18));

        JPanel topPanel = new JPanel(new GridLayout(3, 1, 0, 6));
        topPanel.add(projectLabel);
        topPanel.add(presenterLabel);
        topPanel.add(questionLabel);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(inputField, BorderLayout.CENTER);

        int result = JOptionPane.showConfirmDialog(
                null,
                panel,
                title,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            return inputField.getText();
        }

        return null;
    }
}