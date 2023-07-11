package incometaxcalculator.data.io;

import incometaxcalculator.data.management.TaxpayerManager;

import java.io.IOException;
import java.io.PrintWriter;

public class TXTLogWriter extends LogWriter {

  
  private String formatList[] = {"Name:" ,"AFM:" ,"Income:" ,"Basic Tax:" ,"Tax Increase:" ,"Tax Decrease:" , "Total Tax:" 
      , "TotalReceiptsGathered:" , "Entertainment:" , "Basic:" , "Travel:" , "Health:" , "Other:" };
  
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
