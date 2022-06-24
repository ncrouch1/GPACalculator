package gpaCalculator.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class Get extends JFrame {
    private HashSet<Course> courses;
    private JPanel GetClasses;
    private JButton btnAdd;
    private JButton btnClear;
    private JButton btnFinish;
    private JTextField tfName;
    private JTextField tfLoad;
    private JTextField tfGrade;
    private JTextArea jtaDisplay;
    private boolean finished;

    public Get() {
        courses = new HashSet<>();
        finished = false;

        setContentPane(GetClasses);
        setTitle("Class Entry");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String className = tfName.getText();
                try {
                    int creditLoad = Integer.parseInt(tfLoad.getText());
                    double grade = Double.parseDouble(tfGrade.getText());
                    courses.add(new Course(className,creditLoad, grade));
                    jtaDisplay.setText("");
                    tfLoad.setText("");
                    tfGrade.setText("");
                    tfName.setText("");
                } catch (Exception f) {
                    jtaDisplay.setText("Input invalid, one or more inputs were in invalid formats.");
                }

            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfName.setText("");
                tfGrade.setText("");
                tfLoad.setText("");
                jtaDisplay.setText("");
            }
        });

        btnFinish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double gpaSum = 0.0;
                int credits = 0;
                String display = "";
                for (Course crs: courses) {
                    display += crs.toString() + "\n\n";
                    gpaSum += crs.getGrade() * crs.getCreditLoad();
                    credits += crs.getCreditLoad();
                }
                double gpa = getGpa(gpaSum, credits);
                display += "GPA: " + gpa;
                jtaDisplay.setText(display);
                courses.clear();
            }
        });
    }

    private double getGpa(double gpa, int credits) {
        return Math.floor((gpa / credits) * 100) / 100;
    }

    public boolean isFinished() { return finished; }
    public HashSet<Course> getCourses() { return courses; }

    public static void main(String[] args) {
        Get myFrame = new Get();
    }
}
