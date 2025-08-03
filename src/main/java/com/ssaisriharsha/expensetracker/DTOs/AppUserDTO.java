package com.ssaisriharsha.expensetracker.DTOs;

import com.ssaisriharsha.expensetracker.entities.AppUser;
import lombok.Data;

@Data
public class AppUserDTO {
    private String username;
    private String email;
    public AppUserDTO(AppUser user) {
        this.username=user.getUsername();
        this.email=user.getEmail();
    }
}
