package com.example;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.model.Manufacturer;

@RestController
public class OrderMSController {

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value="/mfrList")
	public ResponseEntity<String> getData() throws RestClientException, URISyntaxException {
		List<ServiceInstance> list = client.getInstances("manufracturer-microservice");
		URI uri = null;
		List<Manufacturer> listManu = null;
		if (!list.isEmpty()) {
			uri = list.get(0).getUri();

			if (uri != null) {
				Manufacturer manufacturer = new Manufacturer(20, new Date(), "MS1");
				Manufacturer manufacturer2 = new Manufacturer(20, new Date(), "MS2");

				listManu = new ArrayList<>();
				listManu.add(manufacturer);
				listManu.add(manufacturer2);
			}

		}
		return (new RestTemplate()).postForEntity(new URI(uri.toString() +"/datarest"), listManu.get(0), String.class);

	}
}
