package com.fullquackdeveloper.salesforcefeign.web;

import com.fullquackdeveloper.salesforcefeign.client.SalesforceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/accounts")
@Slf4j
public class AccountController {
    private final SalesforceClient client;

    @GetMapping(path="/{accountId}")
    public @ResponseBody ResponseEntity<?> getAccount(@PathVariable String accountId) {
        return new ResponseEntity<>(client.getAccountDetail(accountId), HttpStatus.OK);
    }
}
