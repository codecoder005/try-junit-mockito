package com.lmig.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    @Query(
            value = "select "
                   +"new com.lmig.user.UserOrderRow(u.uid, u.name, u.email "
                   +", o.oid, o.amount"
                   +") "
                   +"from UserEntity u "
                   +"left outer join "
                   +" OrderEntity o on u.uid = o.user.uid "
                   +" where u.uid = :uid "
                   +" and o.oid = :oid"
    )
    UserOrderRow getUserOrderRow(@Param(value="uid") Long uid, @Param(value="oid") Long oid);
}
