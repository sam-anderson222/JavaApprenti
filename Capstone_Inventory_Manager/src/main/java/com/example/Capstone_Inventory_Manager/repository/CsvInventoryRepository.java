package com.example.Capstone_Inventory_Manager.repository;

import com.example.Capstone_Inventory_Manager.model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

public class CsvInventoryRepository implements InventoryRepository{
    private final HashMap<String, Product> inventory;

    public CsvInventoryRepository() {
        inventory = new HashMap<>();
    }

    // For manual creation for testing instead of using Spring.
    public CsvInventoryRepository(String filePath) {
        inventory = new HashMap<>();
        this.filePath = filePath;
        load();
    }

    @Value("${inventory.csv.filepath:data/inventory.csv}")
    private String filePath;

    @PostConstruct
    public void init() {
        System.out.println(filePath);
        load(); // Loads all data from file after Spring is done setting up.
    }


    @Override
    public Result<Void> addProduct(String productID, Product product) {
        if (containsProductID(productID)) { // Checking for reasons why method call could be invalid.
            return new Result<>(false, String.format("Error, product with ID %s already exists.", productID), null);
        } else if (productID == null) {
            return new Result<>(false, "Error, null product ID.", null);
        } else if (productID.isEmpty()) {
            return new Result<>(false, "Error, blank product ID.", null);
        } else if (!product.isValid()) {
            return new Result<>(false, "Error, invalid product received.", null);
        }

        inventory.put(productID, product);
        save();
        return new Result<>(true, String.format("%s added.", product.getProductName()), null);
    }

    @Override
    public Result<Void> removeProduct(String productID, int quantityToRemove) {
        Product p = getProduct(productID).data();

        if (productID == null) {
            return new Result<>(false, "Error, null product ID.", null);
        } else if (productID.isEmpty()) {
            return new Result<>(false, "Error, blank product ID.", null);
        } else if (p == null) { // If product isn't found
            return new Result<>(false, String.format("Error, product with ID %s not found.", productID), null);
        } else if (quantityToRemove <= 0) {
            return new Result<>(false, "Error, cannot remove non-positive quantity", null);
        }

        p.setQuantity(p.getQuantity() - quantityToRemove);

        // If quantity is less than 0, then remove product from stock
        if (p.getQuantity() <= 0) {
            inventory.remove(p.getProductID());
            save();
            return new Result<>(true, String.format("%s successfully removed.", p.getProductName()), null);
        } else {
            save();
            return new Result<>(true, String.format("%d %s removed.", quantityToRemove, p.getProductName()), null);
        }
    }

    @Override
    public Result<Void> updateProduct(String productID, Product newProduct) {
        if (productID == null) {
            return new Result<>(false, "Error, null product ID.", null);
        } else if (productID.isEmpty()) {
            return new Result<>(false, "Error, blank product ID.", null);
        } else if (!containsProductID(productID)) {
            return new Result<>(false, String.format("Error, product with ID %s doesn't exist.", productID), null);
        } else if (!newProduct.isValid()) {
            return new Result<>(false, "Error, invalid updated product data received.", null);
        }

        inventory.replace(productID, newProduct);
        save();
        return new Result<>(true, "Item successfully updated.", null);
    }

    @Override
    public Result<Product> getProduct(String productIdOrName) {
        // Try to find product via ID or name
        for (Product p : inventory.values()) {
            if (p.getProductID().equalsIgnoreCase(productIdOrName) || p.getProductName().equalsIgnoreCase(productIdOrName)) {
                return new Result<Product>(true, "", p);
            }
        }

        // Return null result if product not found.
        return new Result<Product>(false, String.format("'%s' not found! Please try again.", productIdOrName), null);
    }

    @Override
    public HashMap<String, Product> getStockTable() {
        return inventory;
    }

    // Checks for productID disregarding case (Ex: p001 and P001 both return the same object)
    @Override
    public boolean containsProductID(String productID) {
        for (String id : inventory.keySet()) {
            // If key already exists, return falling result.
            if (id.equalsIgnoreCase(productID))
                return true;
        }

        return false;
    }

    private void load() {
        File file = new File(filePath);
        if (!file.exists()) {
            return; // Do nothing if file doesn't exist
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while((line = reader.readLine()) != null) {
                String[] dataFields = line.split(",");
                String ID = dataFields[0];

                // Prevent same product ID from being added twice.
                if (containsProductID(ID)) {
                    continue;
                }

                String name = dataFields[1];
                int quantity = Integer.parseInt(dataFields[2]);
                BigDecimal price = new BigDecimal(dataFields[3]);
                ProductTypes type = ProductTypes.valueOf(dataFields[4]);

                switch (type) {
                    case PERISHABLE:
                        PerishableProduct perishableProduct = new PerishableProduct(ID, name, quantity, price, LocalDate.parse(dataFields[5]));
                        inventory.put(ID, perishableProduct);
                        break;
                    case ELECTRONIC:
                        ElectronicProduct electronicProduct = new ElectronicProduct(ID, name, quantity, price, dataFields[5]);
                        inventory.put(ID, electronicProduct);
                        break;
                    default:
                        break;
                }



            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file: " + filePath, e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error parsing data from file: " + filePath, e);
        }
    }

    private void save() {
        File file = new File(filePath);

        try(PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (Product product : inventory.values()) {
                writer.print(product.toCsvLine());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + filePath, e);
        }
    }
}
