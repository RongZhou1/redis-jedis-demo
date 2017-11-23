import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RedisRepoTest {

    private Jedis jedis;
    private RedisRepo redisRepo;

    @BeforeEach
    void setUp() {
        jedis = new Jedis("localhost");
        redisRepo = new RedisRepo();
    }

    @Test
    public void shouldAddDataInRedisRepo() {
        String key = "w3key";
        String hello = "hello";
        String who = "who";
        redisRepo.redisSaveData(jedis, key, hello);
        assertEquals("OK", redisRepo.redisSaveData(jedis, key, hello));
        assertEquals(hello, redisRepo.redisRetrieveData(jedis, key));

        assertEquals("OK", redisRepo.redisModifyData(jedis, key, who));
        assertEquals(who, redisRepo.redisRetrieveData(jedis, key));

        assertEquals(new Long(1), redisRepo.redisDeleteData(jedis, key));
    }

}
