package com.ssaisriharsha.expensetracker.Controller;

import com.ssaisriharsha.expensetracker.DTOs.ExpenseDTO;
import com.ssaisriharsha.expensetracker.Service.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1")
public class ExpenseController {
    private final ExpenseService service;
    public ExpenseController(ExpenseService service) {
        this.service=service;
    }

    @GetMapping("/{username}")
    public ResponseEntity<Page<ExpenseDTO>> getExpenseList(
            @PathVariable("username") String username,
            @RequestParam(name="pgNo", required=false, defaultValue="0") int pgNo,
            @RequestParam(name="size", required = false, defaultValue="10") int size,
            @RequestParam(name="sortBy", required=false, defaultValue="time") String sortBy,
            @RequestParam(name="order", required = false, defaultValue="asc") String order
    ) {
        Page<ExpenseDTO> page=service.getExpenseList(username, pgNo, size, sortBy, order);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

}
