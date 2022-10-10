package repository;

import dto.EventDto;
import enums.Task;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClanRepository {
    private final static ClanRepository clanRepository = new ClanRepository();
    private final ConcurrentHashMap<Long, Long> clans = new ConcurrentHashMap<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(16);

    {
        clans.put(1L, 0L);
        clans.put(2L, 0L);
        clans.put(3L, 0L);
        clans.put(4L, 0L);
        clans.put(5L, 0L);
    }

    private ClanRepository() {
    }

    public static ClanRepository getClanRepository() {
        return clanRepository;
    }

    public ConcurrentHashMap<Long, Long> getClans() {
        return clans;
    }

    public Long get(long clanId) {
        return clans.get(clanId);
    }

    public boolean save(long clanId, long goldQuantity) {
        return clans.put(clanId, goldQuantity) != null;
    }

    public void update(long clanId, long taskId) {
        executorService.submit(() -> {
            long changeGold = Task.getTaskById(taskId).getQuantityGold();
            long v = clans.compute(clanId, (key, value) -> changeGold + value);
        });
    }
}
