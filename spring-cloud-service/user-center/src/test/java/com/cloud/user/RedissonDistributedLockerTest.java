//package com.cloud.user;
//
//import com.cloud.UserApplication;
//import com.cloud.user.service.TestService;
//import com.common.lock.DistributedLock;
//import lombok.extern.slf4j.Slf4j;
//import org.assertj.core.util.Lists;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.redisson.api.RedissonClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.util.StopWatch;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.Map;
//import java.util.Optional;
//import java.util.UUID;
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.Collectors;
//
///**
// * 项目名称：spring-cloud-service
// * 类 名 称：RedissonDistributedLockerTest
// * 类 描 述：TODO
// * 创建时间：2020/11/26 下午2:56
// * 创 建 人：chenyouhong
// */
//@Slf4j
////@RunWith(SpringRunner.class)
////@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = UserApplication.class) // 指定spring-boot的启动类
//public class RedissonDistributedLockerTest {
//
//
////    @Autowired
////    private DistributedLock distributedLocker;
//
//    @Autowired
//    private RedissonClient redissonClient;
//
//    @Autowired
//    private TestService testService;
//
//    private static final ExecutorService executorServiceB = Executors.newSingleThreadExecutor();
//
//    private static final ExecutorService executorServiceC = Executors.newSingleThreadExecutor();
//
//    private static final ExecutorService executorServiceD = Executors.newFixedThreadPool(10);
//
//    @Test
//    public void testA() throws Exception {
//
//        for (int i = 0; i < 10; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    testService.test("qqqq");
//                }
//            }).start();
//        }
//
//        Thread.sleep(1000000);
//    }
//
//    @Test
//    public void tryLockUnlockCost() throws Exception {
//        StopWatch stopWatch = new StopWatch("加锁解锁耗时统计");
//        stopWatch.start();
//        for (int i = 0; i < 10; i++) {
//            String key = "mock-key:" + UUID.randomUUID().toString().replace("-", "");
//            boolean test = redissonClient.getLock("test").tryLock(30000, 600000l, TimeUnit.MILLISECONDS);
//            System.out.println(test);
//            redissonClient.getLock("test").unlock();
////            boolean b = distributedLocker.tryLock();
////            System.out.println(b);
//
////            Optional<LockResource> optLocked = distributedLocker.tryLock(key, 600000, 600000);
////            Assert.assertTrue(optLocked.isPresent());
////            optLocked.get().unlock();
//        }
//        stopWatch.stop();
//        log.info(stopWatch.prettyPrint());
//    }
//
//    /**
//     * 模拟2个线程争抢锁：A先获取到锁，A释放锁后，B再获得锁
//     */
//    @Test
//    public void tryLockT() throws Exception {
//        String lockKey = "test";
//        ArrayList<Integer> list = Lists.newArrayList();
//        for (int i = 0; i < 10; i++) {
//            list.add(i);
////            new Thread(new Runnable() {
////                @Override
////                public void run() {
////                    try {
////                        boolean test = redissonClient.getLock(lockKey).tryLock(30000, 600000l, TimeUnit.MILLISECONDS);
////                        System.out.println(Thread.currentThread().getId() + "\t" + test);
////
////                        System.out.println(Thread.currentThread());
////                        Thread.sleep(10000);
////                        redissonClient.getLock(lockKey).unlock();
////                    } catch (Exception e) {
////
////                    }
////
////                }
////            }).start();
//        }
//
//        list.stream().map(e -> CompletableFuture.supplyAsync(() -> {
//            try {
//
//                boolean test = redissonClient.getLock(lockKey).tryLock(35000, 600000l, TimeUnit.MILLISECONDS);
//                System.out.println(Thread.currentThread().getId() + "\t" + test);
//
//                Thread.sleep(3000);
//                redissonClient.getLock(lockKey).unlock();
//            } catch (Exception ex) {
//
//            }
//            return e;
//        }, executorServiceD)).collect(Collectors.toList()).stream().map(CompletableFuture::join).collect(Collectors.toList());
//
//        System.out.println("============");
//
////        Thread.sleep(100000);
//    }
//
//
////    @Test
////    public void tryLock() throws Exception {
////        String key = "mock-key:" + UUID.randomUUID().toString().replace("-", "");
////        Optional<LockResource> optLocked = distributedLocker.tryLock(key, 600000, 600000);
////        Assert.assertTrue(optLocked.isPresent());
////
////        Optional<LockResource> optLocked2 = distributedLocker.tryLock(key, 600000, 600000);
////        Assert.assertTrue(optLocked2.isPresent());
////
////        optLocked.get().unlock();
////    }
////
////    /**
////     * 模拟2个线程争抢锁：A先获取到锁，A释放锁后，B再获得锁
////     */
////    @Test
////    public void tryLock2() throws Exception {
////        String key = "mock-key:" + UUID.randomUUID().toString().replace("-", "");
////        CountDownLatch countDownLatch = new CountDownLatch(1);
////        Future<Optional<LockResource>> submit = executorServiceB.submit(() -> {
////                    countDownLatch.await();
////                    log.info("B尝试获得锁：thread={}", currentThreadId());
////                    return distributedLocker.tryLock(key, 600000, 600000);
////                }
////        );
////
////        log.info("A尝试获得锁：thread={}", currentThreadId());
////        Optional<LockResource> optLocked = distributedLocker.tryLock(key, 300000, 600000);
////        Assert.assertTrue(optLocked.isPresent());
////
////        log.info("A已获得锁：thread={}", currentThreadId());
////        countDownLatch.countDown();
////
////        optLocked.get().unlock();
////        log.info("A已释放锁：thread={}", currentThreadId());
////
////        Optional<LockResource> lockResource2 = submit.get();
////        Assert.assertTrue(lockResource2.isPresent());
////
////        executorServiceB.submit(() -> {
////            log.info("B已获得锁：thread={}", currentThreadId());
////            lockResource2.get().unlock();
////            log.info("B已释放锁：thread={}", currentThreadId());
////        });
////    }
////
////    /**
////     * 模拟3个线程争抢锁：A先获取到锁，A释放锁后，B和C同时争抢锁
////     */
////    @Test
////    public void tryLock3() throws Exception {
////        String key = "mock-key:" + UUID.randomUUID().toString().replace("-", "");
////
////        log.info("A尝试获得锁：thread={}", currentThreadId());
////        Optional<LockResource> optLocked = distributedLocker.tryLock(key, 600000, 600000);
////
////        if (optLocked.isPresent()) {
////            log.info("A已获得锁：thread={}", currentThreadId());
////        }
////        Assert.assertTrue(optLocked.isPresent());
////
////        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
////        Future<Optional<LockResource>> submitB = executorServiceB.submit(() -> {
////                    cyclicBarrier.await();
////                    log.info("B尝试获得锁：thread={}", currentThreadId());
////                    return distributedLocker.tryLock(key, 600000, 600000);
////                }
////        );
////
////        Future<Optional<LockResource>> submitC = executorServiceC.submit(() -> {
////                    cyclicBarrier.await();
////                    log.info("C尝试获得锁：thread={}", currentThreadId());
////                    return distributedLocker.tryLock(key, 600000, 600000);
////                }
////        );
////
////        optLocked.get().unlock();
////        log.info("A已释放锁：thread={}", currentThreadId());
////
////        CountDownLatch countDownLatch = new CountDownLatch(2);
////        executorServiceB.submit(() -> {
////            log.info("B已获得锁：thread={}", currentThreadId());
////            try {
////                submitB.get().get().unlock();
////            } catch (InterruptedException | ExecutionException e) {
////                e.printStackTrace();
////            }
////            log.info("B已释放锁：thread={}", currentThreadId());
////            countDownLatch.countDown();
////        });
////
////        executorServiceC.submit(() -> {
////            log.info("C已获得锁：thread={}", currentThreadId());
////            try {
////                submitC.get().get().unlock();
////            } catch (InterruptedException | ExecutionException e) {
////                e.printStackTrace();
////            }
////            log.info("C已释放锁：thread={}", currentThreadId());
////            countDownLatch.countDown();
////        });
////
////        countDownLatch.await();
////    }
////
////    private static Long currentThreadId() {
////        return Thread.currentThread().getId();
////    }
////
////    @Test
////    public void tryLockWaitTimeout() throws Exception {
////        String key = "mock-key:" + UUID.randomUUID().toString();
////
////        Optional<LockResource> optLocked = distributedLocker.tryLock(key, 10, 2000);
////        Assert.assertTrue(optLocked.isPresent());
////
////        Optional<LockResource> optLockResource = CompletableFuture.supplyAsync(() -> {
////            long now = System.currentTimeMillis();
////            Optional<LockResource> optLockedAgain = distributedLocker.tryLock(key, 1000, 10);
////            long cost = System.currentTimeMillis() - now;
////            log.info("cost={}", cost);
////            return optLockedAgain;
////        }).exceptionally(th -> {
////            log.error("Exception: ", th);
////            return Optional.empty();
////        }).join();
////
////        Assert.assertTrue(!optLockResource.isPresent());
////    }
////
////    @Test
////    public void tryLockWithLeaseTime() throws Exception {
////        String key = "mock-key-with-leaseTime:" + UUID.randomUUID().toString();
////        Optional<LockResource> optLocked = distributedLocker.tryLock(key, 3000, 1000);
////        Assert.assertTrue(optLocked.isPresent());
////
////        // 可重入
////        Optional<LockResource> optLockedAgain = distributedLocker.tryLock(key, 3000, 1000);
////        Assert.assertTrue(optLockedAgain.isPresent());
////    }
////
////    /**
////     * 模拟1000个并发请求枪一把锁
////     */
////    @Test
////    public void tryLockWithLeaseTimeOnMultiThread() throws Exception {
////        int totalThread = 1000;
////        String key = "mock-key-with-leaseTime:" + UUID.randomUUID().toString();
////        AtomicInteger tryAcquireLockTimes = new AtomicInteger(0);
////        AtomicInteger acquiredLockTimes = new AtomicInteger(0);
////
////        ExecutorService executor = Executors.newFixedThreadPool(totalThread);
////        for (int i = 0; i < totalThread; i++) {
////            executor.submit(new Runnable() {
////
////                @Override
////                public void run() {
////                    tryAcquireLockTimes.getAndIncrement();
////                    Optional<LockResource> optLocked = distributedLocker.tryLock(key, 10, 10000);
////                    if (optLocked.isPresent()) {
////                        acquiredLockTimes.getAndIncrement();
////                    }
////                }
////            });
////        }
////        executor.awaitTermination(15, TimeUnit.SECONDS);
////
////        Assert.assertTrue(tryAcquireLockTimes.get() == totalThread);
////        Assert.assertTrue(acquiredLockTimes.get() == 1);
////    }
////
////    @Test
////    public void tryLockWithLeaseTimeOnMultiThread2() throws Exception {
////        int totalThread = 100;
////        String key = "mock-key-with-leaseTime:" + UUID.randomUUID().toString();
////        AtomicInteger tryAcquireLockTimes = new AtomicInteger(0);
////        AtomicInteger acquiredLockTimes = new AtomicInteger(0);
////
////        ExecutorService executor = Executors.newFixedThreadPool(totalThread);
////        for (int i = 0; i < totalThread; i++) {
////            executor.submit(new Runnable() {
////
////                @Override
////                public void run() {
////                    long now = System.currentTimeMillis();
////                    Optional<LockResource> optLocked = distributedLocker.tryLock(key, 10000, 5);
////                    long cost = System.currentTimeMillis() - now;
////                    log.info("tryAcquireLockTimes={}||wait={}", tryAcquireLockTimes.incrementAndGet(), cost);
////                    if (optLocked.isPresent()) {
////                        acquiredLockTimes.getAndIncrement();
////                        // 主动释放锁
////                        optLocked.get().unlock();
////                    }
////                }
////            });
////        }
////        executor.awaitTermination(20, TimeUnit.SECONDS);
////
////        log.info("tryAcquireLockTimes={}, acquireLockTimes={}", tryAcquireLockTimes.get(), acquiredLockTimes.get());
////        Assert.assertTrue(tryAcquireLockTimes.get() == totalThread);
////        Assert.assertTrue(acquiredLockTimes.get() == totalThread);
////    }
//
//}
