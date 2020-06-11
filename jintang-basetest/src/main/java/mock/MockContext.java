package mock;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
@Slf4j
public final class MockContext {

    private static final long WAIT_TIMEOUT = TimeUnit.SECONDS.toSeconds(30L);

    private MockContext() {
    }

    private static final InheritableThreadLocal<List<MockInfo>> THREAD_LOCAL_MOCKLIST = new InheritableThreadLocal<List<MockInfo>>() {

        @Override
        protected List<MockInfo> initialValue() {

            LinkedList<MockInfo> mockInfos = new LinkedList<MockInfo>();
            return mockInfos;
        }
    };


    public static List<MockInfo> getMockList() {
        return THREAD_LOCAL_MOCKLIST.get();
    }


    public static void addMockInfo(Class clazz, String mockType, String info, String... callingStackPattern) {

        MockInfo mockInfo = new MockInfo();
        THREAD_LOCAL_MOCKLIST.get().add(mockInfo);

        mockInfo.setClazz(clazz);
        mockInfo.setMockType(mockType);
        mockInfo.setCallingStackPattern(new CallingStackPattern(callingStackPattern));
        mockInfo.setInfo(info);

    }

    public static void addMockInfo(Class clazz, String mockType, Lock lock, Condition condition, String info, String... callingStackPattern) {

        MockInfo mockInfo = new MockInfo();
        THREAD_LOCAL_MOCKLIST.get().add(mockInfo);

        mockInfo.setClazz(clazz);
        mockInfo.setMockType(mockType);
        mockInfo.setLock(lock);
        mockInfo.setCondition(condition);
        mockInfo.setCallingStackPattern(new CallingStackPattern(callingStackPattern));
        mockInfo.setInfo(info);

    }

    public static void resetContext() {
        THREAD_LOCAL_MOCKLIST.remove();
        LinkedList<MockInfo> mockInfos = new LinkedList<MockInfo>();
        THREAD_LOCAL_MOCKLIST.set(mockInfos);
    }

    public static MockInfo getMockInfo(Class<?> clazz) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (MockInfo mockInfo : THREAD_LOCAL_MOCKLIST.get()) {
            if (!clazz.equals(mockInfo.getClazz())) {
                continue;
            }
            CallingStackPattern stackPattern = mockInfo.getCallingStackPattern();
            if (stackPattern.match(stackTrace)) {
                return mockInfo;
            }
        }

        return MockInfo.DEFAULT_MOCK_INFO;
    }

    public static void waitAsyncThreadComplete(Class mockClass) {
        for (MockInfo mockInfo : THREAD_LOCAL_MOCKLIST.get()) {
            if (mockInfo.getLock()!=null&&mockClass.getName().equals(mockInfo.getClazz().getName())){
                try {
                    mockInfo.getCondition().await(WAIT_TIMEOUT,TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    log.info("waitAsyncThreadComplete exception",e);
                } finally {
                    mockInfo.getLock().unlock();
                }
            }
        }
    }


}