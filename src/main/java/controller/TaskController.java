package controller;

import service.TaskService;
import service.impl.TaskServiceImpl;

public class TaskController {

    private final static TaskController taskController = new TaskController();

    private final TaskService taskService = TaskServiceImpl.getTaskService();

    private TaskController() {
    }

    public static TaskController getInstance() {
        return taskController;
    }

    public void completeTask(long userId, long clanId, long taskId) {
        taskService.completeTask(userId, clanId, taskId);
    }
}
