package com.eportal.service;

import com.eportal.repository.entity.model.Customer;

public interface EportalService {
    Customer findCustomerByInvitationCode(String invitationCode);
}
