package org.carlosacademic.springbootandspringmvc.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.UUID;

/**
 * Using request scope because we want to generate a new transaction id for every request
 */
@Component
@RequestScope
public class TransactionProcessor {

    public String generateTransactionId(){
        return UUID.randomUUID().toString();
    }
}
