package com.shiftmanager.service;

import com.shiftmanager.dto.request.AccountRequest;
import com.shiftmanager.dto.response.AccountResponse;

public interface AccountService {
    AccountResponse create(AccountRequest request);

    AccountResponse getByPhoneNumber(String mobileNumber, String mobileNumberPrefix);
}
