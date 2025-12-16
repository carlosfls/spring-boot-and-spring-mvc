package org.carlosacademic.springbootandspringmvc.service;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final TransactionProcessor transactionProcessor;

    public ProductService(TransactionProcessor transactionProcessor) {
        this.transactionProcessor = transactionProcessor;
    }

    public void buyProduct(){
        String transactionId = transactionProcessor.generateTransactionId();
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Product bought");
    }
}
