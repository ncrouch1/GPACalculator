package gpaCalculator.swing;

public class Course
{
    private String className;
    private int creditLoad;
    private double grade;

    public Course(String name, int load, double mark)
    {
        className = name;
        creditLoad = load;
        grade = mark;
    }

    public String getClassName() {
        return className;
    }

    public int getCreditLoad() {
        return creditLoad;
    }

    public double getGrade() {
        return grade;
    }

    public String toString() {
        return "Class Name: " + getClassName() +
                ", Credit Load: " + getCreditLoad() +
                ", Grade Received: " + getGrade();
    }
}
