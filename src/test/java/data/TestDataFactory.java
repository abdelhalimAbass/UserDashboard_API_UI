package data;

import java.util.concurrent.ThreadLocalRandom;

public class TestDataFactory {

    public static String randomMobile() {
        return TestData.gen_num= String.valueOf(
                ThreadLocalRandom.current().nextLong(100_000_000L, 1_000_000_000L));
    }

//    public static String randomEmail() {
//        return "test_" + System.currentTimeMillis() + "@mail.com";
//    }
}
