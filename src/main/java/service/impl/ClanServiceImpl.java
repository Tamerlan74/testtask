package service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.ClanRepository;
import service.ClanService;

public class ClanServiceImpl implements ClanService {

    private static final ClanService clanService = new ClanServiceImpl();
    private final ClanRepository clanRepository = ClanRepository.getClanRepository();

    private ClanServiceImpl() {
    }

    public static ClanService getClanService() {
        return clanService;
    }

    @Override
    public Long get(long clanId) {
        return clanRepository.get(clanId);
    }

    @Override
    public boolean save(long clanId, long goldQuantity) {
        return clanRepository.save(clanId, goldQuantity);
    }

    @Override
    public void update(long clanId, long taskId) {
        clanRepository.update(clanId, taskId);
    }

}
