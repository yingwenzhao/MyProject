package mock;

import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public abstract class MockFactory {

    public abstract <T> T createMockByInterface(Class<T> clazz);

    public abstract Set<Class> getMockType();

    protected abstract class AsyncThread extends Thread{

        private Lock lock;
        private Condition condition;

        protected AsyncThread(Lock lock, Condition condition) {
            this.lock = lock;
            this.condition = condition;
        }

        protected AsyncThread(MockInfo mockInfo) {
            this.lock = mockInfo.getLock();
            this.condition = mockInfo.getCondition();
        }


        public void run() {
            try {
                async();
            } finally {
                lock.lock();
                condition.signal();
                lock.unlock();
            }
        }

        /**
         * 异步具体实现
         */
        public abstract void async();
    }

}
