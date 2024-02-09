package com.shiftmanager.service.Impl;

import com.shiftmanager.dto.request.CreateAccountRequest;
import com.shiftmanager.dto.request.UpdateAccountRequest;
import com.shiftmanager.dto.response.AccountResponse;
import com.shiftmanager.entity.Account;
import com.shiftmanager.entity.Role;
import com.shiftmanager.exception.AccountExistsException;
import com.shiftmanager.exception.ResourceNotFoundException;
import com.shiftmanager.repository.AccountRepository;
import com.shiftmanager.repository.RoleRepository;
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
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Override
    public AccountResponse create(CreateAccountRequest request) {
        Optional<Account> accountByPhoneNumber = accountRepository.findByPhonePrefixAndPhoneNumber(
                request.getPhonePrefix(), request.getPhoneNumber());

        if (accountByPhoneNumber.isPresent())
            throw new AccountExistsException(
                    String.format("Account Exists with phone number: &s" + request.getPhonePrefix(), request.getPhoneNumber()));
        Account account = modelMapper.map(request, Account.class);
        setRole(request, account);
        Account saved = accountRepository.save(account);

        return modelMapper.map(saved, AccountResponse.class);
    }

    private void setRole(CreateAccountRequest request, Account account) {
        Role role = roleRepository.findById(request.getRole_id())
                .orElseThrow(() -> new ResourceNotFoundException("Role", "id", request.getRole_id().toString()));
        account.setRole(role);
    }

    @Override
    public AccountResponse getByPhoneNumber(String phoneNumber, String phoneNumberPrefix) {
        Account account = getAccountByPhoneNumber(phoneNumber, phoneNumberPrefix);

        return modelMapper.map(account, AccountResponse.class);
    }

    private Account getAccountByPhoneNumber(String phoneNumber, String phoneNumberPrefix) {
        return accountRepository.findByPhonePrefixAndPhoneNumber(phoneNumberPrefix, phoneNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "phone number", phoneNumberPrefix + phoneNumber));
    }

    @Override
    public AccountResponse update(UpdateAccountRequest request) {
        Account account = getAccountByPhoneNumber(request.getPhoneNumber(), request.getPhonePrefix());
        modelMapper.map(request, account);
        Account saved = accountRepository.save(account);

        return modelMapper.map(saved, AccountResponse.class);
    }
}
