package com.putstack.user_service_query.service;

import com.putstack.user_service_query.entity.UserSummary;

public interface QueryService {
    public void reset();
    public UserSummary getUserInfo(String orderId);
}
