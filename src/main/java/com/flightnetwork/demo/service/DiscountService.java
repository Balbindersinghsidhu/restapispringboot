/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flightnetwork.demo.service;


import com.flightnetwork.demo.api.response.util.APIStatus;
import com.flightnetwork.demo.exception.ApplicationException;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Balbinder Singh
 */
public class DiscountService {
    
       
    public Double getDiscountAmount(String userType,double amount)
    {
        String str;
        Double finalamount=0.0;
        System.out.println("chek the value"+amount);
        try
        {            
            CSVReader csvReader = null;            
          
           // String fname="Discount.csv";                   
            String path="D:\\Discount.csv";
           
            try {
			
		csvReader = new CSVReader(new FileReader(path));

		} catch (Exception e) {                    
			str="File Not Found"; 
		}
            String[] nextLine;
            int per=0;
            double amountdiff=0.0;
           
            
            while ((nextLine = csvReader.readNext()) != null) {
                
                if ((userType == null ? nextLine[0] == null : userType.equals(nextLine[0])) ) {
                   Double start=Double.parseDouble(nextLine[1]);
                   Double end=Double.parseDouble(nextLine[2]);
                    if( amount >= start && amount <= end)
                    {
                       per=Integer.parseInt(nextLine[3]);
                       amountdiff=amount-start;
                       break;
                    }                                                                
                }
                                               
            }
            
            if(userType.equals("Standard") && per==0)
            {
                                
                return amount;
            }
            
            if(userType.equals("Standard") && per==10)
            {
                
                int amountdiffint=Double.valueOf(amountdiff).intValue();
                int discount=(amountdiffint*10)/100;
                finalamount=Integer.valueOf(discount).doubleValue();
                finalamount=amount-finalamount;
                return finalamount;
            }
             if(userType.equals("Standard") && per==15)
            {
                int tenperstand=(2000*10)/100;
                int amountdiffint=Double.valueOf(amountdiff).intValue();
                int discount=(amountdiffint*15)/100;
                discount=tenperstand+discount;
                 finalamount=Integer.valueOf(discount).doubleValue();
                finalamount=amount-finalamount;
                return finalamount;
                
            }
             
             if(userType.equals("Standard") && per==20)
            {
                int tenperstand=(2000*10)/100;
                int fifteenperstand=(2000*15)/100;
                int amountdiffint=Double.valueOf(amountdiff).intValue();
                int discount=(amountdiffint*20)/100;
                discount=tenperstand+fifteenperstand+discount;
                finalamount=Integer.valueOf(discount).doubleValue();
                finalamount=amount-finalamount;
                return finalamount;
                
            }
             
             if(userType.equals("Premium") && per==0)
            {
                                
                return amount;
            }
             
             
             if(userType.equals("Premium") && per==10)
            {
                
                int amountdiffint=Double.valueOf(amountdiff).intValue();
                int discount=(amountdiffint*10)/100;
                finalamount=Integer.valueOf(discount).doubleValue();
                finalamount=amount-finalamount;
                return finalamount;
            }
             if(userType.equals("Premium") && per==15)
            {
                int tenperstand=(500*10)/100;
                int amountdiffint=Double.valueOf(amountdiff).intValue();
                int discount=(amountdiffint*15)/100;
                discount=tenperstand+discount;
                finalamount=Integer.valueOf(discount).doubleValue();
                finalamount=amount-finalamount;
                return finalamount;
                
            }
             
             if(userType.equals("Premium") && per==20)
            {
                int tenperstand=(500*10)/100;
                int fifteenperstand=(2000*15)/100;
                int amountdiffint=Double.valueOf(amountdiff).intValue();
                int discount=(amountdiffint*20)/100;
                discount=tenperstand+fifteenperstand+discount;
                finalamount=Integer.valueOf(discount).doubleValue();
                finalamount=amount-finalamount;
                return finalamount;
                
            }
             
             if(userType.equals("Premium") && per==25)
            {
                int tenperstand=(500*10)/100;
                int fifteenperstand=(2000*15)/100;
                int twentyperstand=(2000*20)/100;
                int amountdiffint=Double.valueOf(amountdiff).intValue();
                int discount=(amountdiffint*20)/100;
                discount=tenperstand+fifteenperstand+twentyperstand+discount;
                finalamount=Integer.valueOf(discount).doubleValue();
                finalamount=amount-finalamount;
                return finalamount;
                
            }
            
            
            
            
            
            
        }catch(IOException | NumberFormatException ex)
        {
            throw new ApplicationException(APIStatus.ERR_INTERNAL_SERVER);
        }
        return finalamount;
    }
    
}
