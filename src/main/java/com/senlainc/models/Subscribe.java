package com.senlainc.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="subscribe")
public class Subscribe {

    @EmbeddedId
    @Column(name = "subscribe_id")
    private SubscribeId id;
}
