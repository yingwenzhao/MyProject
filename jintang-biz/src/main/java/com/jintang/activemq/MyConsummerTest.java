package com.jintang.activemq;


public class MyConsummerTest {

    /*public static void main(String[] args) {
        myConsummerTest();
        *//*for (int i = 0;i<3;i++){
            new Thread(new Runnable() {
                public void run() {
                    myConsummerListenerTest();
                }
            },"ThreadName"+i).start();
        }*//*

    }


    private static void myConsummerTest() {
        Connection connection = null;
        Session session = null;
        MessageConsumer consumer = null;
        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.244.132:61616");
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            Queue test_queue = session.createQueue("test_queue");
            consumer = session.createConsumer(test_queue);
            while (true) {
                TextMessage receive = (TextMessage) consumer.receive(1000L);
                if (receive != null) {
                    System.out.println(Thread.currentThread().getName()+"当前消费消息=====" + receive.getText());
                    receive.acknowledge();
                } else {
                    break;
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
//                session.commit();
                consumer.close();
                session.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


        private static void myConsummerListenerTest(){
            Connection connection = null;
            Session session = null;
            MessageConsumer consumer = null;
            try {
                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.244.132:61616");
                connection = connectionFactory.createConnection();
                connection.start();
                session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                Queue test_queue = session.createQueue("test_queue");
                consumer = session.createConsumer(test_queue);

                consumer.setMessageListener(new MessageListener() {
                    public void onMessage(Message message) {
                        try {
                            if(message != null){
                                TextMessage textMessage = (TextMessage)message;
                                System.out.println(Thread.currentThread()+"当前消费消息====="+textMessage.getText());
                            }
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                });
                System.in.read();

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    consumer.close();
                    session.close();
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }



    }
*/
}
