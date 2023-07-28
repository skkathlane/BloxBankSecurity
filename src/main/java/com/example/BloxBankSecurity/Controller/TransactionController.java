package com.example.BloxBankSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @GetMapping("/deposit")
    public String deposit(){
        return "now you can deposit money";
    }
    @GetMapping("/withdraw")
    public String withdraw(){
        return "now you can withdraw";
    }
    @GetMapping("/transfer")
    public String transfer(){
        return "now you can transfer";
    }

}
