package incometaxcalculator.data.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import incometaxcalculator.data.management.Receipt;
import incometaxcalculator.data.management.TaxpayerManager;

public class XMLInfoWriter extends InfoWriter {
  
  private String formatList[] = {"<Name>" ,"<AFM>" ,"<Status>" ,"<Income>" ,"<Receipts>" ,"<ReceiptID>" , "<Date>" 
      , "<Kind>" , "<Amount>" , "<Company>" , "<Country>" , "<City>" , "<Street>" , "<Number>" };
  
  private String extensionList[] = {"</Name>" ,"</AFM>" ,"</Status>" ,"</Income>" ,"</Receipts>" ,"</ReceiptID>" , "</Date>" 
      , "</Kind>" , "</Amount>" , "</Company>" , "</Country>" , "</City>" , "</Street>" , "</Number>" };
 
  public String getFormat(int index) {
    return formatList[index];
  }
  
  public String placeExtension(int index) {
    return " " + extensionList[index];
  }
  
  public String getExtension() {
    return "xml";
  }
  
  
}