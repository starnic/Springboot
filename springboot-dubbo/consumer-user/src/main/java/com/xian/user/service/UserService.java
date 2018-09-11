package com.xian.user.service;

import com.xian.ticket.service.TicketService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
public class UserService {

    @Reference
    TicketService ticketService;

    public void hello() {
        String ticekt = ticketService.getTicket();
        System.out.println("买到票了！"+ ticekt);
    }
}
