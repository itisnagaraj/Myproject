package com.sarvesh.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.sarvesh.model.CountryInfo;

public class CapitalFinder {
	private List<CountryInfo> countryInfoList;
	public CapitalFinder(List<CountryInfo> data) {
		
		this.countryInfoList = data;
	}
public String findCapitalByCountry(String countryName, String output) {
	File file= new File(output);
	if (file.isDirectory()) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmdd");
		String dateAsString = simpleDateFormat.format(new Date());
		System.out.println(countryName);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY/MM/DD HH/MM/SS EEEE");
		LocalDateTime now = LocalDateTime.now();
		String capital2Find = null;
		for (int i=0;i<countryInfoList.size();i++) {
			if((countryInfoList.get(i).getName()).equalsIgnoreCase(countryName)) {
				capital2Find ="--------["+ countryName.toLowerCase() +"]-------"+ "\n\nIn Own Language:"+ countryInfoList.get(i).getName_in_own_language() + "\nContinent:"+ countryInfoList.get(i).getContinent() + "\nPopulation:"+ countryInfoList.get(i).getPopulation() +"\nPresident:" + countryInfoList.get(i).getPmpresident() + "\nCurrency:"+ countryInfoList.get(i).getCurrency() +"\nIso_Code:"+countryInfoList.get(i).getIso_code() + "\nCapital:"+ countryInfoList.get(i).getCapital() +"\nISD_Code:"+ countryInfoList.get(i).getIso_code() +"\n\n---[" +dtf.format(now) + "]---";
				output=output + "output_" +countryName.toLowerCase() +"-" +dateAsString;
				break;
			}
			if(capital2Find == null) {
				capital2Find = "Sorry, matched country name could not be found.";
			}
			
		}
		if(capital2Find !="Sorry, matched country name could not be found.") {
			try {
				FileWriter fstream = new FileWriter(output + ".txt");
				BufferedWriter out = new BufferedWriter(fstream);
				out.write(capital2Find + "\n");
				System.out.println("Output File:" + output + ".txt is generated successfully");
				out.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return capital2Find;
		}
	}
	return countryName;
	
}

}
