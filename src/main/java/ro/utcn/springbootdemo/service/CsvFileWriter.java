package ro.utcn.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.Delimiter;
import ro.utcn.springbootdemo.entities.Order;
import ro.utcn.springbootdemo.repository.OrderRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileWriter {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    @Autowired
    OrderRepository orderRepository;
    private static final String FILE_HEADER = "idOrder,idMenu";
    public static void writeCsvFile(String fileName,List<Order> orders) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);

            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());

            //Add a new line separator after the header
            fileWriter.append("\n");


            for (Order order : orders) {
                fileWriter.append(String.valueOf(order.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(order.getMenu().getId()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }

    }

