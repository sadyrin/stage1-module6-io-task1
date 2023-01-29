package com.epam.mjc.io;

import java.io.File;

import java.io.BufferedReader;


public class FileReader {
    private String name;
    private Integer age;
    private String email;
    private Long phone;

    public Profile getDataFromFile(File file) {
		
		try(java.io.FileReader reader = new java.io.FileReader(file);){
			
			BufferedReader br = new BufferedReader(reader);

			String line = null;

			while ((line = br.readLine()) != null) {
				if(line.contains("Name:")) name = line.split(": ")[1];
				if(line.contains("Age:")) age = Integer.parseInt(line.split(": ")[1]);
				if(line.contains("Email:")) email = line.split(": ")[1];
				if(line.contains("Phone:")) phone = Long.parseLong(line.split(": ")[1]);
			}

			br.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		} 

        return new Profile(name, age, email, phone);
    }
}
