package com.jintang.activemq;

public class MqProviderTest {
/*
    public static void main(String[] args) {
        mqProductorTest();
    }


    public static void mqProductorTest() {
        Connection connection = null;
        Session session = null;
        MessageProducer producer = null;
        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.244.132:61616");
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            Destination testQueue = session.createQueue("test_queue");
            producer = session.createProducer(testQueue);
//            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);默认持久化
            Message message;
            for (int i = 0;i<20;i++){
                message= session.createTextMessage("MyActiveMq message =---------" + i);
                producer.send(message);
            }
            System.out.println("send message end***********************");

        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            try {
                session.commit();
                producer.close();
                session.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }*/


}
