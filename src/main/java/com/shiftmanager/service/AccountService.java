package com.shiftmanager.service;

import com.shiftmanager.dto.request.CreateAccount;
import com.shiftmanager.dto.request.UpdateAccount;
import com.shiftmanager.dto.response.AccountResponse;

public interface AccountService {
    AccountResponse create(CreateAccount request);

    AccountResponse getByPhoneNumber(String mobileNumber, String mobileNumberPrefix);

    AccountResponse update(UpdateAccount request);
}
