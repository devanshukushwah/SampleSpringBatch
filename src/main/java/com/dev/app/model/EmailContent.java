package com.dev.app.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailContent {
    private String emailAddress;
    private long primaryKey;
    private long roomId;

}
