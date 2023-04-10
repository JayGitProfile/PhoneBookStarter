package com.pb;

import com.pb.model.PhoneBookEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class PhoneBookApplication {

	public static Map<String, PhoneBookEntry> phoneBookEntries;

	public static void main(String[] args) {

		SpringApplication.run(PhoneBookApplication.class, args);
		phoneBookEntries = new HashMap<>();

	}
}
