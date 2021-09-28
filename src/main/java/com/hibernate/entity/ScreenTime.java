package com.hibernate.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "screenTime")
public class ScreenTime extends BaseEntity{

    @OneToMany(mappedBy = "screenTime")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "screenTime")
    private List<ScreenTimeHall> screenTimeHalls;

    @OneToMany(mappedBy = "screenTime")
    private List<ScreenTimeMovie> screenTimeMovies;

    private LocalDateTime start;

    private LocalDateTime end;

    private double price;


}
