package com.shiftmanager.service.Impl;

import com.shiftmanager.dto.request.AccountRequest;
import com.shiftmanager.dto.response.AccountResponse;
import com.shiftmanager.entity.Account;
import com.shiftmanager.exception.AccountExistsException;
import com.shiftmanager.exception.ResourceNotFoundException;
import com.shiftmanager.repository.AccountRepository;
import com.shiftmanager.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    @Override
    public AccountResponse create(AccountRequest request) {
        Optional<Account> accountByPhoneNumber = accountRepository.findByPhonePrefixAndPhoneNumber(
                request.getPhonePrefix(), request.getPhoneNumber());

        if (accountByPhoneNumber.isPresent())
            throw new AccountExistsException(
                    String.format("Account Exists with phone number: &s" + request.getPhonePrefix(), request.getPhoneNumber()));
        Account account = modelMapper.map(request, Account.class);
        Account saved = accountRepository.save(account);

        return modelMapper.map(saved, AccountResponse.class);
    }

    @Override
    public AccountResponse getByPhoneNumber(String phoneNumber, String phoneNumberPrefix) {
        Account account = accountRepository.findByPhonePrefixAndPhoneNumber(phoneNumberPrefix, phoneNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "phone number", phoneNumberPrefix + phoneNumber));

        return modelMapper.map(account, AccountResponse.class);
    }
}
