package com.shiftmanager.service;

import com.shiftmanager.dto.request.CreateAccountRequest;
import com.shiftmanager.dto.request.UpdateAccountRequest;
import com.shiftmanager.dto.response.AccountResponse;

public interface AccountService {
    AccountResponse create(CreateAccountRequest request);

    AccountResponse getByPhoneNumber(String mobileNumber, String mobileNumberPrefix);

    AccountResponse update(UpdateAccountRequest request);
}
