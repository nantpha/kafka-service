package io.devsgarden.kafkaservice.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.devsgarden.kafkaservice.model.Student;
import io.devsgarden.kafkaservice.service.KafkaSender;

@RestController
@RequestMapping("/kafkaProducer")
public class KafkaProducerController {

	@Autowired
	private KafkaSender sender;
	
	@PostMapping("/sendMsg")
	public ResponseEntity<String> sendData(@RequestBody Student student){
		sender.sendData(student);
		return new ResponseEntity<String>("Data sent to Kafka", HttpStatus.OK);
	}
}
