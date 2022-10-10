package dto;

import java.time.LocalDateTime;

public class EventDto {

    private long userId;
    private long clanId;
    private long taskId;
    private LocalDateTime localDateTime;

    public EventDto(long userId, long clanId, long taskId) {
        this.localDateTime = LocalDateTime.now();
        this.userId = userId;
        this.clanId = clanId;
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "EventDto{" +
                "userId=" + userId +
                ", clanId=" + clanId +
                ", taskId=" + taskId +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
