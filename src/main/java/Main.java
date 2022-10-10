import controller.ClanController;
import controller.HistoryController;
import controller.TaskController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final int EXECUTION_TIMES = 100;

    public static void main(String[] args) throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(16);
        List<Future<Boolean>> futures = new ArrayList<>();

        //launch add goldSum to clan
        for (int i = 0; i < EXECUTION_TIMES; i++) {
            Callable<Boolean> r = () -> {
                TaskController taskController = TaskController.getInstance();
                taskController.completeTask(1, 1, 1);
                return true;
            };
            Future<Boolean> future = executorService.submit(r);
            futures.add(future);

        }

        //launch take goldSum to clan
        for (int i = 0; i < EXECUTION_TIMES; i++) {
            Callable<Boolean> r = () -> {
                TaskController taskController = TaskController.getInstance();
                taskController.completeTask(1, 1, 4);
                return true;
            };
            Future<Boolean> future = executorService.submit(r);
            futures.add(future);
        }

        //wait completion
        futures.forEach(booleanFuture -> {
            try {
                booleanFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                logger.error(e.getMessage());
            }
        });

        //check values
        ClanController clanController = ClanController.getInstance();
        HistoryController historyController = HistoryController.getHistoryController();
        logger.info("Gold sum should be equal to zero: " + clanController.getClanById(1L));
        historyController.getHistoryByClanId(1L).forEach(logger::info);
        logger.info("History size should be: " + (1 + 2 * EXECUTION_TIMES) + " actual result is: " + historyController.getHistoryByClanId(1L).size());
    }

}
