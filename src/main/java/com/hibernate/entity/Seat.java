package com.hibernate.entity;

import com.hibernate.util.SeatStatus;
import com.hibernate.util.SeatType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "seat")
public class Seat extends BaseEntity{
    private SeatStatus seatStatus;

    @Column(name = "seat_type")
    private SeatType seatType;

    @Column(name = "seat_row")
    private String seatRow;

    @Column(name = "seat_column")
    private int seatColumn;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;



}