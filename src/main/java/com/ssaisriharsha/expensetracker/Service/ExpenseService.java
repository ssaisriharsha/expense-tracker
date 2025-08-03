package com.ssaisriharsha.expensetracker.Service;

import com.ssaisriharsha.expensetracker.DTOs.ExpenseDTO;
import com.ssaisriharsha.expensetracker.Repository.ExpenseRepo;
import com.ssaisriharsha.expensetracker.entities.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepo repo;
    public ExpenseService(ExpenseRepo repo) {
        this.repo=repo;
    }

    public Page<ExpenseDTO> getExpenseList(String username, int pgNo, int size, String sortBy, String order) {
        Sort.Direction dir= order.equalsIgnoreCase("desc")?Sort.Direction.DESC:Sort.Direction.ASC;
        Pageable pageable= PageRequest.of(pgNo, size, dir, sortBy);
        Page<Expense> page=repo.findByUser_Username(username, pageable);
        Page<ExpenseDTO> dtoPage=page.map(ExpenseDTO::new);
        return dtoPage;
    }
}
