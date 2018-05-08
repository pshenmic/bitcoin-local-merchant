package com.pshenmic.service;

import com.pshenmic.domain.OperationPrice;
import com.pshenmic.domain.Order;
import com.pshenmic.domain.Product;
import com.pshenmic.enums.Currency;
import com.pshenmic.exception.ElectrumRequestFailedException;
import com.pshenmic.exception.OperationPriceExtractingException;
import com.pshenmic.exception.OrderStatusMappingFailedException;
import com.pshenmic.exception.UnknownCurrencyException;
import com.pshenmic.model.electrum.SendRequest;
import com.pshenmic.repository.OrderRepository;
import com.pshenmic.util.BitcoinMathContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.MathContext;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PricesService pricesService;

    @Autowired
    private ElectrumService electrumService;

    @Autowired
    private MappingService mappingService;

    public Order getProductById(Long id) {
        return orderRepository.getOne(id);
    }

    public List<Order> getAllPendingOrders() {
        return orderRepository.findAllPendingOrders();
    }

    @Transactional
    public Order createOrderByProduct(Product product) throws OperationPriceExtractingException, UnknownCurrencyException, ElectrumRequestFailedException, OrderStatusMappingFailedException {
        Currency currency = product.getCurrency();

        OperationPrice operationPrice = new OperationPrice();
        operationPrice.setCurrency(currency);

        switch (currency) {
            case USD:
                operationPrice.setFiatRate(pricesService.getBtcUsdPrice());
                break;
            default:
                throw new UnknownCurrencyException();
        }

        operationPrice.setBtcPrice(product.getPrice().divide(operationPrice.getFiatRate(), BitcoinMathContext.BITCOIN_FRACTION));

        Order order = new Order();
        order.setProduct(product);
        order.setOperationPrice(operationPrice);


        SendRequest result = electrumService.sendRequest(operationPrice.getBtcPrice());

        order.setAddress(result.getAddress());
        order.setTime(result.getTime());
        order.setStatus(mappingService.toOrderStatus(result.getStatus()));
        if (order.getStatus() == null) {
            throw new OrderStatusMappingFailedException();
        }

        return orderRepository.save(order);
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.delete(id);
    }

    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }


}


