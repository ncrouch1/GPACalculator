package StateMachine;

import javax.swing.*;

abstract class State
{
    static State input, finish, current;

    void enter(Course[] courses, JFrame window) {}
    void update(Course[] courses, JFrame window) {}
}

class Input extends State
{
    void enter(Course[] courses, JFrame window)
    {

    }

    void update(Course[] courses, JFrame window)
    {

    }
}

class Finish extends State
{
    void enter(Course[] courses, JFrame window)
    {

    }

    void update(Course[] courses, JFrame window)
    {

    }
}

public class StateMachine
{
    static State input, finish, current;
    static JFrame window;
    Course[] courses;
    int size;

    public StateMachine(int size, JFrame window)
    {
        input = new Input();
        finish = new Finish();
        current = input;
        this.size = size;
        courses = new Course[size];
        this.window = window;
    }

    public Course[] perform(Course[] courses)
    {
        for (int i = 0; i < size; i++)
        {
            current.enter(courses, window);
            current.update(courses, window);
        }
        current = finish;
        current.enter(courses, window);
        current.update(courses, window);


        return courses;
    }
}
