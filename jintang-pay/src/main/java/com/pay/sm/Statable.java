package com.pay.sm;

import java.math.BigInteger;

/**
 *  可状态化抽象
 */
public interface Statable {

    BigInteger getId();

    String getStatus();

    void setStatus(String status);

}
