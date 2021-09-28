package edu.fa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "timehall")
public class Seat extends BaseEntity{


    @Column(name = "style_seat")
    private String styleSeat;

    @Column(name = "row_seat")
    private String rowSeat;

    @Column(name = "hall_id")
    private int hallId;

    @ManyToOne
    @JoinColumn(name = "hall_id", referencedColumnName = "hall_id")
    private Hall hall;



}