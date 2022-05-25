package com.lmig.user;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(
        exclude = {"user"}
)
@EqualsAndHashCode(
        exclude = {"user"}
)
@Entity
@Table(
        name = "orders"
)
public class OrderEntity {
    @Id
    private Long oid;
    private Double amount;

    @ManyToOne
    @JoinColumn(
            name = "uid",
            referencedColumnName = "uid",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_orders_users_uid"
            )
    )
    private UserEntity user;
}
