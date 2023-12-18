package com.example.stage4e.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;


import java.util.UUID;

@Component
@Data
@Builder
public class Code {


    public String getCode(){return UUID.randomUUID().toString();
    }
}
