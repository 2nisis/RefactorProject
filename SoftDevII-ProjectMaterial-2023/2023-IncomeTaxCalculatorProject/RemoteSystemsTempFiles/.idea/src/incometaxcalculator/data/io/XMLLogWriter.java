package incometaxcalculator.data.io;

import incometaxcalculator.data.management.TaxpayerManager;

import java.io.IOException;
import java.io.PrintWriter;

public class XMLLogWriter extends LogWriter {


  
  private String formatList[] = {"<Name>" ,"<AFM>" ,"<Income>" ,"<BasicTax>" ,"<TaxIncrease>" ,"<TaxDecrease>" , "<TotalTax>" 
      , "<Receipts>" , "<Entertainment>" , "<Basic>" , "<Travel>" , "<Health>" , "<Other>" };
  
  private String extensionList[] = {"</Name>" ,"</AFM>" ,"</Income>" ,"</BasicTax>" ,"</TaxIncrease>" ,"</TaxDecrease>" , "</TotalTax>" 
      , "</Receipts>" , "</Entertainment>" , "</Basic>" , "</Travel>" , "</Health>" , "</Other>" };
  
  public String getFormat(int index) {
    return formatList[index];
  }
  
  public String placeExtension(int index) {
    return  " " + extensionList[index];
  }
  public String getExtension() {
    return "xml";
  }

}
