package com.training.expensemanagementsystem.dao;

import com.training.expensemanagementsystem.model.GuestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestDAO extends JpaRepository<GuestUser,Long> {

            public List<GuestUser> findByBalanceLessThan(Double amount);
             public List<GuestUser> findByMonthlyIncomeBetween(Double min, Double max);
            public List<GuestUser> findByMobileNumber(String  mobileNumber);

            @Query("SELECT g FROM GuestUser g WHERE g.guestName = :guestName")
          List<GuestUser> searchDemo(@Param("guestName") String guestName);



}
