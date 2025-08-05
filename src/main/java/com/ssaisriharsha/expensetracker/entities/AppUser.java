package com.ssaisriharsha.expensetracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="users")
@NoArgsConstructor
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Email
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name="username", unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String authority;
    private LocalDateTime createdOn=LocalDateTime.now();
    @OneToMany(mappedBy="user")
    @JsonIgnore
    private List<Expense> expenses;
    public AppUser(String username, String password, String email) {
        this.username=username;
        this.password=password;
        this.email=email;
    }
}
