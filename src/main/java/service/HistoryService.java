package service;

import dto.EventDto;

import java.util.List;

public interface HistoryService {

    List<EventDto> getClanHistory(long clanId);
}
