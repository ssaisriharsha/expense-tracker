package com.ssaisriharsha.expensetracker.DTOs;

import com.ssaisriharsha.expensetracker.entities.Expense;
import com.ssaisriharsha.expensetracker.utilities.Month;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExpenseDTO {
    private Month month;
    private String category;
    private int expense;
    private String notes;
    public ExpenseDTO(Expense e) {
        this.month=e.getMonth();
        this.category=e.getCategory();
        this.expense=e.getExpense();
        this.notes=e.getNotes();
    }
}
