package com.lmig.user;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(
        name = "users"
)
public class UserEntity {
    @Id
    private Long uid;
    private String name;
    private String email;

    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<OrderEntity> placedOrders;
}
