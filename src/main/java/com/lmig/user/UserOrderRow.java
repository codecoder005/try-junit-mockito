package com.lmig.user;


import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class UserOrderRow implements Serializable {
    @Serial
    private static final long serialVersionUID = 8622082944635409537L;

    @NonNull
    private Long uid;
    @NonNull
    private String name;
    @NonNull
    private String email;
    private Long oid;
    private Double amount;
}
