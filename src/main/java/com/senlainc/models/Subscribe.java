package com.senlainc.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Subscribe {

    private int id;

    private User subscribedBy;

    private User subscribedAt;


    public Subscribe(User subscribedTo, User subscribedAt) {
        this.subscribedBy = subscribedTo;
        this.subscribedAt = subscribedAt;
    }
}
