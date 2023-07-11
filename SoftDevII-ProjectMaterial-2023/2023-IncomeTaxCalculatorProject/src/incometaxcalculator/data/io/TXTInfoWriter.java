package incometaxcalculator.data.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import incometaxcalculator.data.management.Receipt;
import incometaxcalculator.data.management.TaxpayerManager;

public class TXTInfoWriter extends InfoWriter {
  
  
 private String formatList[] = {"Name:" ,"AFM:" ,"Status:" ,"Income:" ,"Receipts:" ,"Receipt ID:" , "Date:" 
      , "Kind:" , "Amount:" , "Company:" , "Country:" , "City:" , "Street:" , "Number:" };

  public String getFormat(int index) {
    return formatList[index];
  }
  
  //dummy functionality
  public String placeExtension(int index) {
    return "";
  }
  public String getExtension() {
    return "txt";
  }

}