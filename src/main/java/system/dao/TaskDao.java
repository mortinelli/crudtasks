package system.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import system.model.Task;


import java.util.List;


/**
 * Created by smatveev on 23.06.2017.
 */
@Repository
public class TaskDao {


 private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Task> getAllTasks(){
        Session session = sessionFactory.getCurrentSession();
        List<Task> allTasks = session.createQuery("from system.model.Task").list();
        return allTasks;
    }

    public List<Task> getAllDoneTasks(){
        Session session = sessionFactory.getCurrentSession();
        List<Task> allTasks = session.createQuery("from system.model.Task where isDone = '1' ").list();
        return allTasks;
    }

    public List<Task> getAllNotDoneTasks(){
        Session session = sessionFactory.getCurrentSession();
        List<Task> allTasks = session.createQuery("from system.model.Task where isDone = '0'").list();
        return allTasks;
    }

    public void addTask(Task task){
        Session session = sessionFactory.getCurrentSession();
        session.persist(task);
    }

    public void updateTask(Task task){
        Session session = sessionFactory.getCurrentSession();
        session.update(task);
    }

    public void removeTask(int id){
        Session session = sessionFactory.getCurrentSession();
        Task task = (Task) session.load(Task.class, new Integer(id));
        if(task != null){
            session.delete(task);
        }
    }

    public Task getTaskById(int id){
        Session session = sessionFactory.getCurrentSession();
        Task task = (Task) session.load(Task.class, new Integer(id));
        return task;
    }
    public List<Task> getTaskByPageId(int pageid, int total){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from system.model.Task" );
        query.setFirstResult(pageid);
        query.setMaxResults(total);
        List<Task> allTasks = query.list();
        return allTasks;
    }
}
