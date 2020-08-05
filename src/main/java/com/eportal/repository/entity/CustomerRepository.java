package com.eportal.repository.entity;

import com.eportal.repository.entity.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional(Transactional.TxType.SUPPORTS)
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer findCustomerByInvitationCode(String invitationCode);
}
