package com.senlainc.dto.subscribes;

import com.senlainc.dto.users.UserDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class SubscribeDTO {

    @NotNull(message = "Subscriber can't be null")
    private UserDTO subscriber;

    @NotNull(message = "Subscribed to can't be null")
    private UserDTO subscribedTo;
}
