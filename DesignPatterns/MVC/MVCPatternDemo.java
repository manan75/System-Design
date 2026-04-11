package DesignPatterns.MVC;

public class MVCPatternDemo {
    public static void main(String[] args) {
        // Fetch student record from database or dummy data
        Student model = new Student();
        model.setName("John");
        model.setRollNo("101");

        // Create view and controller
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        // Display student data
        controller.updateView();

        // Update model data
        controller.setStudentName("Alice");

        // Display updated data
        controller.updateView();
    }
}
