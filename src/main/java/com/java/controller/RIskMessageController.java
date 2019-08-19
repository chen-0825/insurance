package com.java.controller;

import com.java.service.RiskMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RIskMessageController {
    @Autowired
    private RiskMessageService riskMessageService;
    @RequestMapping("/selAllRiskMessage")
    public String selAllRiskMessage(Model model){
        model.addAttribute("list",riskMessageService.selAllRiskMessage());
        return "RiskMessage/RiskMessageIndex";
    }
}
