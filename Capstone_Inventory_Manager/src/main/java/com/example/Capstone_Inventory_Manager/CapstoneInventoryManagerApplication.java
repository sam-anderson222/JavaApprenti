package com.example.Capstone_Inventory_Manager;

import com.example.Capstone_Inventory_Manager.repository.CsvInventoryRepository;
import com.example.Capstone_Inventory_Manager.service.InventoryService;
import com.example.Capstone_Inventory_Manager.view.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapstoneInventoryManagerApplication implements CommandLineRunner {

	@Autowired
	private Inventory inventory;

	public static void main(String[] args) {
		SpringApplication.run(CapstoneInventoryManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		inventory.run();
	}
}
