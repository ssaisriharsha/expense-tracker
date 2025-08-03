package com.ssaisriharsha.expensetracker.Repository;

import com.ssaisriharsha.expensetracker.entities.Expense;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {
    public Page<Expense> findByUser_Username(String username, Pageable pageable);
}
