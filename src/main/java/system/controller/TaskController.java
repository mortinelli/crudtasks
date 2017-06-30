package system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import system.model.Task;
import system.service.TaskService;


/**
 * Created by smatveev on 23.06.2017.
 */

@Controller

public class TaskController {

    private TaskService taskService;
    private int pageIndex = 0;
    private int total =5;
    private int maxIndex;

    @Autowired (required = true)
    @Qualifier(value = "taskService")
    public void setTaskService(TaskService taskService){
        this.taskService = taskService;
        maxIndex = taskService.getAllTasks().size();}

    @RequestMapping(value = "/alltasks",method = RequestMethod.GET)
    public String getAllTask(Model model){
        model.addAttribute("allTasks",taskService.getAllTasks());
        model.addAttribute("task", new Task());
        return "tasks";
    }
    @RequestMapping(value = "/alldonetasks",method = RequestMethod.GET)
    public String getAllDoneTask(Model model){
        model.addAttribute("allTasks",taskService.getAllDoneTasks());
        model.addAttribute("task", new Task());
        return "tasks";
    }
    @RequestMapping(value = "/allnotdonetasks",method = RequestMethod.GET)
    public String getAllNotDoneTask(Model model){
        model.addAttribute("allTasks",taskService.getAllNotDoneTasks());
        model.addAttribute("task", new Task());
        return "tasks";
    }
    @RequestMapping(value = "/tasks/next5",method = RequestMethod.GET)
    public String getNext5Tasks(Model model){
        maxIndex= taskService.getAllTasks().size(); //если базу обновлили в процессе работы программы, обновляем значения для корректной работы Next and Previos
        if((pageIndex*total)/total<= maxIndex/total){
            pageIndex++;
        }
       int minElement=pageIndex*total-total;
        model.addAttribute("allTasks",taskService.getTasksByPageId(minElement,total));
        model.addAttribute("task", new Task());
        return "tasks";
    }

    @RequestMapping(value = "/tasks/previous5",method = RequestMethod.GET)
    public String getPrevious5Tasks(Model model){
     maxIndex= taskService.getAllTasks().size(); //если базу обновлили в процессе работы программы, обновляем значения для корректной работы Next and Previos
             if(pageIndex >1){
                pageIndex--;}
       int minElement=pageIndex*total-total;
        model.addAttribute("allTasks",taskService.getTasksByPageId(minElement,total));
        model.addAttribute("task", new Task());
        return "tasks";
    }
    @RequestMapping(value = "/tasks/add", method = RequestMethod.POST)
    public String addTask(@ModelAttribute("task") Task task){
        if(task.getId() == 0){
            this.taskService.addTask(task);
        }else {
            this.taskService.updateTask(task);
        }
        return "redirect:/alltasks";
    }
    @RequestMapping("/remove/{id}")
    public String removeTask(@PathVariable("id") int id){
        this.taskService.removeTask(id);
        return "redirect:/alltasks";
    }
    @RequestMapping("edit/{id}")
    public String editTask(@PathVariable("id") int id, Model model){
        model.addAttribute("task", this.taskService.getTaskById(id));
        model.addAttribute("allTasks", this.taskService.getAllTasks());
        return "tasks";
    }

    @RequestMapping("taskdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        model.addAttribute("task", this.taskService.getTaskById(id));
        return "taskdata";
    }
}
