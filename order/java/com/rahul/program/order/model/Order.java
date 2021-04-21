package com.rahul.program.order.model;

import lombok.AllArgsConstructor;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "orders")
public class Order {
    @Id
    private String _id;
    private String checkIn;
    private String checkOut;
    private int noOfGuests;
    private Guest guest;
    private int noOfDays;
    private String roomId;
    private Long roomNo;
    private AmountDetails amountDetails;
    private String bookedAt;
    
    private boolean status;
}