package com.sarvesh.app;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import com.sarvesh.util.CapitalFinder;
import com.sarvesh.util.File2ArrayList;
import com.sarvesh.model.CountryInfo;

public class CapitalFinderTask {
	public static void main(String[] args) throws IOException {
		String again;
		File file= new File(AppConst.countryInfoFilePath);
		if (!file.isFile()) {
			System.out.println("Required File is Missing !!!");
			System.exit(0);
		}
		Scanner s= new Scanner(System.in);
		do
		{
			System.out.println("Name of the country to Find");
			String countryName = s.nextLine();
			System.out.println("Output directory:");
			String output=s.nextLine();
			File2ArrayList file2ArrayList = new File2ArrayList();
			CapitalFinder capitalFinder = new CapitalFinder(file2ArrayList.createList(file));
			{
				System.out.println(capitalFinder.findCapitalByCountry(countryName,output));
			}
			System.out.println("Do you want to search more? [Y/N]:");
			again = s.nextLine();
			
		}
		while(again.equalsIgnoreCase("y"));
		if(again.equalsIgnoreCase("n")) {
			System.out.println("Thanks.... have a nice time.");
			System.exit(0);
		}
		if(!again.equalsIgnoreCase("y")||!again.equalsIgnoreCase("n"))
		{
			System.out.println("Please enter valid input");
		}
		s.close();
	}

}
