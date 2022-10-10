package enums;

import java.util.Arrays;

public enum Task {

    DIG_GOLD(1, 100),
    ROB_GOLD(2, 200),
    DONATE_GOLD(3, 300),
    TAKE_GOLD(4, -100);

    private final long id;
    private final long quantityGold;

    Task(long id, long quantityGold) {
        this.id = id;
        this.quantityGold = quantityGold;
    }

    public static Task getTaskById(long id) {
        return Arrays.stream(Task.values())
                .filter(task -> id == task.id)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("task not exist with id: " + id));
    }

    public long getQuantityGold() {
        return quantityGold;
    }
}
