package com.senlainc.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="subscribe")
public class Subscribe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscribe_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "subscriber", referencedColumnName = "user_id")
    private User subscriber;

    @ManyToOne
    @JoinColumn(name = "subscribed_to", referencedColumnName = "user_id")
    private User subscribedTo;

}
