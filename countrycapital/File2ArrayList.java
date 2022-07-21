package com.sarvesh.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.sarvesh.model.CountryInfo;

public class File2ArrayList {
	public List<CountryInfo>createList(File countryInfoFile){
		CountryInfo countryInfo;
		ArrayList<CountryInfo>countryInfoList = new ArrayList<CountryInfo>();
		String line;
		//String capital;
		String[] result = null;
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(countryInfoFile), StandardCharsets.UTF_8)); 
				;
				line = bufferedReader.readLine();
				while((line = bufferedReader.readLine()) != null) {
					result = line.split(",");
			        String country_code = result[0];
			   	 String iso_code = result[1];
			   	 String name = result[2];
			   	 String name_in_own_language = result[3];
			   	 String population = result[4];
			   	 String capital = result[5];
			   	 String currency = result[6];
			   	 String pMPre = result[7];
			   	 String pmpresident = result[8];
			   	 String continent = result[9];
			   	 countryInfo = new CountryInfo(         country_code,
			   		  iso_code,
			   		  name,
			   		  name_in_own_language,
			   		  population,
			   		  capital,
			   		  currency,
			   		  pMPre,
			   		  pmpresident,
			   		  	continent);
			   	 countryInfoList.add(countryInfo);
				}
				bufferedReader.close(); 
				}
			
			catch (IOException ex) {
				ex.printStackTrace();
			}
			return countryInfoList;
		}
	}



