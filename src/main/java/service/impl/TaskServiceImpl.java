package service.impl;

import dto.EventDto;
import repository.ClanRepository;
import repository.HistoryRepository;
import service.TaskService;

public class TaskServiceImpl implements TaskService {

    private final static TaskService taskService = new TaskServiceImpl();
    private final HistoryRepository historyRepository = HistoryRepository.getHistoryRepository();
    private final ClanRepository clanRepository = ClanRepository.getClanRepository();

    private TaskServiceImpl() {
    }

    public static TaskService getTaskService() {
        return taskService;
    }

    @Override
    public void completeTask(long userId, long clanId, long taskId) {
        historyRepository.addEvent(clanId, new EventDto(userId, clanId, taskId));
        clanRepository.update(clanId, taskId);
    }
}
