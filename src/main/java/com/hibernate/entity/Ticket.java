package com.hibernate.entity;


import jdk.jfr.Timestamp;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "ticket")
public class Ticket extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "screen_time")
    private ScreenTime screenTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
}
