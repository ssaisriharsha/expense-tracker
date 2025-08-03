package com.ssaisriharsha.expensetracker.Repository;

import com.ssaisriharsha.expensetracker.entities.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
}
