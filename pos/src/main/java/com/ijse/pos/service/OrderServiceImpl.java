package com.ijse.pos.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.pos.dto.OrderDTO;
import com.ijse.pos.entity.Item;
import com.ijse.pos.entity.Order;
import com.ijse.pos.repository.ItemRepository;
import com.ijse.pos.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order creatOrder(OrderDTO orderDTO) {
        Order order = new Order();

        List<Long> items = orderDTO.getProducts();

        Set<Item> itemSet = new HashSet<>();

        order.setTotal(0.0);

        for (Long itemId : items) {
            Item item = itemRepository.findById(itemId).orElse(null);
            if (item != null && item.getQty() != 0) {
                itemSet.add(item);
                order.setTotal(order.getTotal() + item.getPrice());

                // reduce the qty from current stock
            }
        }
        Double tax = (order.getTotal() / 100) * 15;

        order.setTax(tax);
        order.setOrderTime(LocalDateTime.now());
        order.setItems(itemSet);

        return orderRepository.save(order);

    }
}
