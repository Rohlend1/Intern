package com.senlainc.dto.subscribes;

import com.senlainc.models.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SubscribeDTO {

    private User subscriber;

    private User subscribedTo;
}
