package com.itspace.ws.api.resourceserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRest {
    String name;
    String surname;
    String userId;
}
