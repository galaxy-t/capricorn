import com.google.common.util.concurrent.RateLimiter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RateLimiterTests {


    private RateLimiter rateLimiter = null;


    @Before
    public void init() {

        this.rateLimiter = RateLimiter.create(0.5);

    }


    @Test
    public void test() {


        List<Runnable> tasks = new ArrayList<Runnable>();
        for (int i = 0; i < 10; i++) {
            tasks.add(new UserRequest(i));
        }
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (Runnable runnable : tasks) {
            System.out.println("等待时间：");
            this.rateLimiter.acquire();
            threadPool.execute(runnable);
        }

    }


    private static class UserRequest implements Runnable {

        private int id;

        public UserRequest(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(this.id);
        }
    }



}
