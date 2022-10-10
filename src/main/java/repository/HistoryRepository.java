package repository;

import dto.EventDto;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class HistoryRepository {

    private final static HistoryRepository hr = new HistoryRepository();
    private final Map<Long, List<EventDto>> events = new ConcurrentHashMap<>();

    {
        List<EventDto> eventsFirstClan = new CopyOnWriteArrayList<>();
        eventsFirstClan.add(new EventDto(0, 0, 0));
        events.put(1L, eventsFirstClan);
        List<EventDto> eventsSecondClan = new CopyOnWriteArrayList<>();
        eventsSecondClan.add(new EventDto(0, 0, 0));
        events.put(2L, eventsSecondClan);
        List<EventDto> eventsThirdClan = new CopyOnWriteArrayList<>();
        eventsThirdClan.add(new EventDto(0, 0, 0));
        events.put(3L, eventsThirdClan);
        List<EventDto> eventsFourthClan = new CopyOnWriteArrayList<>();
        eventsFourthClan.add(new EventDto(0, 0, 0));
        events.put(4L, eventsFourthClan);
        List<EventDto> eventsFifthClan = new CopyOnWriteArrayList<>();
        eventsFifthClan.add(new EventDto(0, 0, 0));
        events.put(5L, eventsFifthClan);
    }

    private HistoryRepository() {
    }

    public static HistoryRepository getHistoryRepository() {
        return hr;
    }

    public void addEvent(long clanId, EventDto eventDto) {
        events.merge(clanId, events.get(clanId), (oldValue, value) -> {
            oldValue.add(eventDto);
            return oldValue;
        });
    }

    public List<EventDto> getEventsByClanId(long clanId) {
        return events.get(clanId);
    }
}
