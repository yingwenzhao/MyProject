package base;

import dao.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import mock.MockContext;
import mock.MockFactory;
import mock.MockInfo;
import model.Order;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
@Slf4j
public class ProviderMockFactory extends MockFactory {

    private Map<Class, Method> methodMap = new HashMap<Class, Method>();

    {
        Method[] methods = ProviderMockFactory.class.getDeclaredMethods();
        for (Method method : methods) {
            Class<?> returnType = method.getReturnType();
            methodMap.put(returnType,method);
        }
    }

    public <T> T createMockByInterface(Class<T> clazz) {
        Method method = methodMap.get(clazz);
        try {
            return (T)method.invoke(this);
        } catch (Exception e) {
            log.info("createMockByInterface exception = {}",e);
        }
        return null;
    }

    public Set<Class> getMockType() {

        return methodMap.keySet();
    }


    public OrderMapper getOrderMapper(){

        OrderMapper orderMapper = Mockito.mock(OrderMapper.class);

        Mockito.when(orderMapper.insert(Mockito.any(Order.class))).then(new Answer<Integer>() {
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {

                MockInfo mockInfo = MockContext.getMockInfo(OrderMapper.class);
                if(MockInfo.SYNC_SUCCESS.equals(mockInfo.getMockType())){
                    return -1;
                }
                return null;
            }
        });

        return orderMapper;
    }





}
