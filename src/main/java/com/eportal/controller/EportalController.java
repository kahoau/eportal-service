package com.eportal.controller;

import com.eportal.service.EportalService;
import com.eportal.repository.entity.model.Customer;
import com.eportal.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/eportal")
public class EportalController {
    @Autowired
    private EportalService ePortalService;

    @RequestMapping(value="/profile", method= RequestMethod.GET)
    public ResponseEntity<Customer> retrieveProfile(CustomerVO customerVO) {
        return ResponseEntity.ok(ePortalService.findCustomerByInvitationCode(
                customerVO.getInvitationCode()));
    }
}
