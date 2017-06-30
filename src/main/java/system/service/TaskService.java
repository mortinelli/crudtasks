package system.service;


import org.springframework.stereotype.Service;
import system.dao.TaskDao;
import system.model.Task;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by smatveev on 23.06.2017.

лишний в данной реализации ничего не делает кроме перебросов запроса
 */

@Service
public class TaskService {
    private TaskDao taskDao;

    public void setTaskDao(TaskDao taskDao){ this.taskDao = taskDao;}

    @Transactional
    public List<Task> getAllTasks(){
        return taskDao.getAllTasks();
    }
    @Transactional
    public List<Task> getAllDoneTasks(){
        return taskDao.getAllDoneTasks();
    }
    @Transactional
    public List<Task> getAllNotDoneTasks(){
        return taskDao.getAllNotDoneTasks();
    }
    @Transactional
    public List<Task> getTasksByPageId(int page,int total){
        return this.taskDao.getTaskByPageId( page,total);
    }
    @Transactional
    public void updateTask(Task task){
        taskDao.updateTask(task);
    }
    @Transactional
    public void addTask(Task task){
        taskDao.addTask(task);
    }
    @Transactional
    public void removeTask(int id){
        taskDao.removeTask(id);
    }
    @Transactional
    public Task  getTaskById(int id){
        return taskDao.getTaskById(id);
    }

}
