package com.tw;

import com.tw.controller.Controller;
import com.tw.controller.controllerlmpl.Controllerlmpl;

import java.text.ParseException;
import java.util.Scanner;

public class BadmintonCourtBill {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        Controller courtController = new Controllerlmpl();
        while (true){
            String userInput= scanner.nextLine();
            System.out.println(courtController.processRequest(userInput));
        }
    }
}
