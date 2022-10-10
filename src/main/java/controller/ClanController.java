package controller;

import service.ClanService;
import service.impl.ClanServiceImpl;

public class ClanController {

    private final static ClanController clanController = new ClanController();
    private final ClanService clanService = ClanServiceImpl.getClanService();


    private ClanController() {
    }

    public static ClanController getInstance() {
        return clanController;
    }

    public Long getClanById(long clanId) {
        return clanService.get(clanId);
    }
}
