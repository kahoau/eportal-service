package com.eportal.service.impl;

import com.eportal.service.EportalService;
import com.eportal.repository.entity.CustomerRepository;
import com.eportal.repository.entity.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EportalServiceImpl implements EportalService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer findCustomerByInvitationCode(String invitationCode) {
        return customerRepository.findCustomerByInvitationCode(invitationCode);
    }
}
