package com.ibagroup.common;

import java.util.ArrayList;
import java.util.List;

public class CommonMethods {

    public static List<Integer> getTicketNumbers(Integer quantity, Integer ticketQuantity){
        List<Integer> ticketNumbers = new ArrayList<>();

        while (ticketNumbers.size() < quantity) {
            int j = (int) (Math.random() * ticketQuantity + 1);
            if(!ticketNumbers.contains(j)){
                ticketNumbers.add(j);
            }
        }

        return ticketNumbers;
    }

}
