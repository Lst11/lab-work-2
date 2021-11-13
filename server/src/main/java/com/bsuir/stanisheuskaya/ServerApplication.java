package com.bsuir.stanisheuskaya;

import com.bsuir.stanisheuskaya.controller.ServerController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ServerApplication {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("server\\src\\main\\resources\\banner.txt"))) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ServerController.getInstance().work();
    }
}
