package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query("SELECT userId FROM Order WHERE cartId = :cartId")
    public Long getOrderIdByCartId(@Param("cartId") Long cartId);

    @Query("SELECT cartId FROM Order WHERE userId = :userId")
    public <List>Long getOrderIdByUserId(@Param("userId") Long userId);

    @Override
    List<Order> findAll();

    @Override
    Optional<Order> findById(Long id);

    @Override
    Order save(Order order);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
