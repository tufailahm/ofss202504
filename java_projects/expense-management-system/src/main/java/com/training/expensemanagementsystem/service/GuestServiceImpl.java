package com.training.expensemanagementsystem.service;

import com.training.expensemanagementsystem.dao.GuestDAO;
import com.training.expensemanagementsystem.model.GuestUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService{

    @Autowired
    GuestDAO guestDAO;

    @Override
    @Transactional
    public boolean saveGuest(GuestUser guestUser) {
        if(guestUser.getMobileNumber().length() ==10)
        {
            guestDAO.save(guestUser);
            return true;
        }
        else {
            System.out.println("Mobile Number is invalid");
            return false;
        }
    }
}
