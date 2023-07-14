package com.senlainc.dto.subscribes;

import com.senlainc.dto.users.UserDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class SubscribeDto {

    @NotNull(message = "Subscriber can't be null")
    private UserDto subscriber;

    @NotNull(message = "Subscribed to can't be null")
    private UserDto subscribedTo;
}
