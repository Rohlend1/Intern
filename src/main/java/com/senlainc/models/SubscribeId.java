package com.senlainc.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class SubscribeId implements Serializable {

    @Column(name = "subscriber")
    private Integer subscriber;

    @Column(name = "subscribe_to")
    private Integer subscribedTo;
}
