package com.hotel.roomservice.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(value = "room")
@Data
@AllArgsConstructor // siyalu args thyena objects hmbenwa
@NoArgsConstructor
@Builder //constructor based
public class Room {
    @Id
    private String id;
    private String no;
    private BigDecimal price;

}
