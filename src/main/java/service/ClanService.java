package service;

public interface ClanService {

    Long get(long clanId);

    boolean save(long clanId, long goldQuantity);

    void update(long clanId, long goldChange);
}
