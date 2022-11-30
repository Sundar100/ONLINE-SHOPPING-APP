package com.sundar.spring.eureka.salesorderservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sundar.spring.eureka.salesorderservice.entity.Customer_SOS;
import com.sundar.spring.eureka.salesorderservice.entity.InputRequest;
import com.sundar.spring.eureka.salesorderservice.entity.Item;
import com.sundar.spring.eureka.salesorderservice.entity.OrderLineDTO;
import com.sundar.spring.eureka.salesorderservice.entity.Order_Details_By_Customer;
import com.sundar.spring.eureka.salesorderservice.entity.Order_Line_Item;
import com.sundar.spring.eureka.salesorderservice.entity.OutputResponse;
import com.sundar.spring.eureka.salesorderservice.entity.Sales_Order;
import com.sundar.spring.eureka.salesorderservice.repository.Customer_Sos_Respository;
import com.sundar.spring.eureka.salesorderservice.repository.Order_Line_Item_Repository;
import com.sundar.spring.eureka.salesorderservice.repository.Sales_Order_Repository;

@Service
@RefreshScope
public class Customer_Sos_Service {

	public Long count = 1l;

	@Autowired
	private Customer_Sos_Respository customer_Sos_Respository;

	@Autowired
	private Sales_Order_Repository sales_Order_repostory;

	@Autowired
	private Order_Line_Item_Repository order_Line_Item_Repository;

	@Autowired
	@Lazy
	private RestTemplate template;

	@Value("${microservices.item-service.endpoints.endpoint.uri}")
	private String ENDPOINT_URI;

	public void subscribe(Customer_SOS customersos) {
		customer_Sos_Respository.save(customersos);
	}

	public List<Customer_SOS> getall() {
		return customer_Sos_Respository.findAll();
	}

	public Optional<Customer_SOS> getById(Long id) {
		return customer_Sos_Respository.findById(id);
	}

	@HystrixCommand(fallbackMethod = "placeOrderfallBack")
	public ResponseEntity<Object> placeOrder(InputRequest inputRequest) {
		double price = 0;
		String order_date = inputRequest.getOrder_date();
		Long cust_id = inputRequest.getCust_id();
		String order_desc = inputRequest.getOrder_desc();
		List<String> items = inputRequest.getItems();
		List<Order_Line_Item> orderLineItem = new ArrayList<Order_Line_Item>();

		if (getById(cust_id).isEmpty()) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		} else {

			for (String item : items) {
				Item itemInfo = template.getForObject(ENDPOINT_URI + item, Item.class);
				if (itemInfo == null) {
					return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
				} else {
					price += itemInfo.getPrice();
					Order_Line_Item OLI = new Order_Line_Item();
					OLI.setItem_name(item);
					OLI.setItem_quantity(1);
					orderLineItem.add(OLI);
				}
			}

			Sales_Order sales_Order = new Sales_Order(count++, order_date, cust_id, order_desc, price);
			Sales_Order saved = sales_Order_repostory.save(sales_Order);

			orderLineItem.forEach(order_Line_Item -> {
				order_Line_Item.setOrder_id(saved.getId());
				order_Line_Item_Repository.save(order_Line_Item);
			});
			OutputResponse orderDetails = getOrderDetails(saved.getId());
			return new ResponseEntity<Object>(orderDetails, HttpStatus.OK);
		}

	}

	public ResponseEntity<Object> getOrderDetailsByCustomerId(Long customerId) {
		if (getById(customerId).isEmpty()) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		} else {
			List<Order_Details_By_Customer> listOfOrders = new ArrayList<Order_Details_By_Customer>();
			List<Sales_Order> saved = sales_Order_repostory.findOrderByCustomerId(customerId);
			for (Sales_Order so : saved) {
				Order_Details_By_Customer ODBC = new Order_Details_By_Customer();
				ODBC.setOrder_id(so.getId());
				ODBC.setOrder_desc(so.getOrder_desc());
				listOfOrders.add(ODBC);
			}
			return new ResponseEntity<Object>(listOfOrders, HttpStatus.OK);
		}
	}

	public OutputResponse getOrderDetails(Long orderId) {
		Sales_Order sales_order = sales_Order_repostory.findOrderById(orderId);
		List<Order_Line_Item> findOrderById = order_Line_Item_Repository.findByOrderId(orderId);

		OutputResponse outputResponse = new OutputResponse();
		outputResponse.setOrder_id(orderId);
		outputResponse.setOrder_description(sales_order.getOrder_desc());

		List<OrderLineDTO> orderLineDTOList = new ArrayList<OrderLineDTO>();

		for (Order_Line_Item order_Line_Item : findOrderById) {
			OrderLineDTO orderLineDTO = new OrderLineDTO();
			orderLineDTO.setItem_name(order_Line_Item.getItem_name());
			orderLineDTO.setItem_quantity(order_Line_Item.getItem_quantity());
			orderLineDTOList.add(orderLineDTO);
		}

		outputResponse.setOrderLineItems(orderLineDTOList);

		return outputResponse;
	}

	public ResponseEntity<Object> placeOrderfallBack(InputRequest inputRequest) {
		OutputResponse outputResponse = new OutputResponse();
		outputResponse.setOrder_id(null);
		outputResponse.setOrder_description("Due to server Down Order cant be placed");
		outputResponse.setOrderLineItems(null);
		return new ResponseEntity<Object>(outputResponse, HttpStatus.BAD_REQUEST);
	}

}
