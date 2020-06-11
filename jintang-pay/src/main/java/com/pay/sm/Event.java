package com.pay.sm;

public interface Event {

    void withinTransaction(Statable statableModel);

    void withoutTransaction(Statable statableModel);
}
