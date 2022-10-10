package service.impl;

import dto.EventDto;
import repository.HistoryRepository;
import service.HistoryService;

import java.util.List;

public class HistoryServiceImpl implements HistoryService {

    private final static HistoryService historyService = new HistoryServiceImpl();
    private final HistoryRepository historyRepository = HistoryRepository.getHistoryRepository();

    public static HistoryService getHistoryService() {
        return historyService;
    }

    private HistoryServiceImpl() {
    }

    @Override
    public List<EventDto> getClanHistory(long clanId) {
        return historyRepository.getEventsByClanId(clanId);
    }
}
