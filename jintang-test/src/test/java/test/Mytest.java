package test;
import java.math.BigDecimal;
import java.util.Date;

import base.JintangTest;
import dao.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import mock.MockConfiguration;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

@Slf4j
public class Mytest extends JintangTest {
    
    @Autowired
    private OrderMapper orderMapper;

    @Test
    @MockConfiguration({"dao.OrderMapper,SYNC_SUCCESS,Mytest.orderTest"})
    public void orderTest(){

        Order order = new Order();
        order.setId(125L);
        order.setTxType("38");
        order.setMercId("5435344");
        order.setMercCustId("5555555");
        order.setChannelType("w");
        order.setChannelSeqNo("2334222233");
        order.setProductCode("12222222");
        order.setOrderTimeOut("23h");
        order.setOrderAmt(new BigDecimal("110"));
        order.setRefundAmt(new BigDecimal("22220"));
        order.setOrgOrderNo("222222");
        order.setOrderStatus("00");
        order.setTransId("I323333333");
        order.setRequestTime(new Date());
        order.setRequestCompleteTime(new Date());
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        order.setCustId("3444333334");

        log.info("order tostring order ={}",order);

        int insert = orderMapper.insert(order);
        log.info("orderMapper.insert(order) insert={}",insert);
    }


}
