package mock;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@Getter
@Setter
public final class MockInfo{

    public static final String SYNC_SUCCESS = "SYNC_SUCCESS";

    public static final String SYNC_FAIL = "SYNC_FAIL";

    public static final String SYNC_TIMEOUT = "SYNC_TIMEOUT";

    public static final String ASYNC_SUCCESS = "ASYNC_SUCCESS";

    public static final String ASYNC_FAIL = "ASYNC_FAIL";

    public static final MockInfo DEFAULT_MOCK_INFO = new MockInfo(SYNC_SUCCESS,CallingStackPattern.ANY,String.class);


    private String mockType;

    private CallingStackPattern callingStackPattern;

    private Class clazz;

    public MockInfo(String mockType, CallingStackPattern callingStackPattern, Class clazz) {
        this.mockType = mockType;
        this.callingStackPattern = callingStackPattern;
        this.clazz = clazz;
    }

    public MockInfo(){

    }

    private String info;

    private Lock lock;

    private Condition condition;

    private CountDownLatch countDownLatch;



    public boolean isMockType(String mockType){
        if(mockType == null) return false;
        return mockType.equals(this.mockType);
    }



}
