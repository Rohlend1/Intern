package com.senlainc.util;

import com.senlainc.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class SubscribeId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE,CascadeType.REFRESH})
    @JoinColumn(name = "subscriber",referencedColumnName = "user_id")
    private User subscriber;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE,CascadeType.REFRESH})
    @JoinColumn(name = "subsribed_to", referencedColumnName = "user_id")
    private User subscribedTo;
}
