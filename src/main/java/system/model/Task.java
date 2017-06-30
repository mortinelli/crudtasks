package system.model;

import javax.persistence.*;

/**
 * Created by smatveev on 23.06.2017.
 */

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TASK_NAME")
    private String name;

    @Column(name = "isDone")
    public boolean isDone;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}
