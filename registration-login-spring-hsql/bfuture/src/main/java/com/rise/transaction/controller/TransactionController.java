package com.rise.transaction.controller;

import com.rise.transaction.dto.TransactionRequest;
import com.rise.transaction.dto.TransactionResponse;
import com.rise.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(method = RequestMethod.GET, value = "/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TransactionResponse> transaction(HttpServletRequest httpServletRequest, @RequestParam("id") String id) {

        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setUserId(id);
        List<TransactionResponse> transactionResponseList = transactionService.transaction(transactionRequest);

        return transactionResponseList;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findAllTransaction", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TransactionResponse> findAllTransaction(HttpServletRequest httpServletRequest) {

        TransactionRequest transactionRequest = new TransactionRequest();
        List<TransactionResponse> transactionResponseList = transactionService.findAllTransaction();

        return transactionResponseList;
    }
}
