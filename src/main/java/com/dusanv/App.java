package com.dusanv;

import java.io.IOException;

public class App 
{
    public static void main( String[] args )
    {
        ConverterService service = new ConverterService(new LetterProvider());

        try {
            String input = "DUSAN";
            service.convertPhrase(input, ":party_cat:", ":sheepy:");
            System.out.println("File saved as: " + input + ".txt");
        } catch (IOException e) {
            System.out.println("Failed to convert: " + e.getMessage());
        }
    }
}
