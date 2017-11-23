import redis.clients.jedis.Jedis;

public class RedisJava {
    public void main(String[] args) {
        //连接本地的Redis服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server successfully");
        System.out.println("Server is running:" + jedis.ping());
    }

}
