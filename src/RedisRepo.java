import redis.clients.jedis.Jedis;

class RedisRepo {

    String redisSaveData(Jedis jedis, String key, String value) {
        return jedis.set(key, value);
    }

    Long redisDeleteData(Jedis jedis, String key) {
        return jedis.del(key);
    }

    String redisModifyData(Jedis jedis, String key, String value) {
        return jedis.set(key, value);
    }

    String redisRetrieveData(Jedis jedis, String key) {
        return jedis.get(key);
    }
}
