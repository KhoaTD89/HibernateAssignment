package com.hibernate.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "hall")
public class Hall extends BaseEntity{

    @Column(name = "hall_name")
    private String hallName;

    @Column(name = "seat_qty")
    private int seatQty;

    @OneToMany(mappedBy = "hall")
    private Set<Seat> seats;

    @OneToMany(mappedBy = "hall")
    private List<ScreenTimeHall> screenTimeHalls;

}