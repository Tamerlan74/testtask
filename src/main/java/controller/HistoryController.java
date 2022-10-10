package controller;

import dto.EventDto;
import service.HistoryService;
import service.impl.HistoryServiceImpl;

import java.util.List;

public class HistoryController {

    private final static HistoryController historyController = new HistoryController();
    private final HistoryService historyService = HistoryServiceImpl.getHistoryService();

    private HistoryController() {
    }

    public static HistoryController getHistoryController() {
        return historyController;
    }

    public List<EventDto> getHistoryByClanId(long clanId) {
        return historyService.getClanHistory(clanId);
    }
}
