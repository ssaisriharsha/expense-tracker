package com.ssaisriharsha.expensetracker.entities;

import com.ssaisriharsha.expensetracker.utilities.Month;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="expenses")
@NoArgsConstructor
@Data
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long expenseId;
    private Month month;
    private String category;
    private int expense;
    private String notes;
    private LocalDateTime time=LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name="userId")
    private AppUser user;

    public Expense(Month month, String category, int expense) {
        this.month=month;
        this.category=category;
        this.expense=expense;
    }
}
