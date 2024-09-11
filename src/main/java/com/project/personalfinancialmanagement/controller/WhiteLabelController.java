package com.project.personalfinancialmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WhiteLabelController {
    @RequestMapping
    public ResponseEntity<?> whiteLabel() {
        return ResponseEntity.ok("Under Development");
    }
}
