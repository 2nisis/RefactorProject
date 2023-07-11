package incometaxcalculator.data.io;

import java.io.BufferedReader;
import java.io.IOException;

import incometaxcalculator.exceptions.WrongFileFormatException;
//https://refactoring.guru/smells/duplicate-code
public class XMLFileReader extends FileReader {
  
  private String format = "<ReceiptID>";
  private String delimeter = " ";
  private int splitStep = 3;

  public String getDelimeter() {
    return delimeter;
  }
  public int getSplitStep() {
    return splitStep;
  }
  public String getFormat() {
    return format;
  } 

  protected String getDecodedValueOfField(String fieldsLine){
    
      String valueReversed[] = new StringBuilder(fieldsLine).reverse().toString().trim()
          .split(" ", 2);
      return new StringBuilder(valueReversed[1]).reverse().toString();
    
  }
 /* 
   // @overrides same method in superclass for testing purposes
  protected int checkForReceipt(BufferedReader inputStream)
      throws NumberFormatException, IOException {
    String line;
    while (!isEmpty(line = inputStream.readLine())) {
      String values[] = line.split(" ", 3);
      if (values[0].equals("<ReceiptID>")) {
        int receiptId = Integer.parseInt(values[1].trim());
        return receiptId;
      }
    }
    return -1;
  }
  //@overrides same method in superclass for testing purposes
  protected String getValueOfField(String fieldsLine) throws WrongFileFormatException {
    if (isEmpty(fieldsLine)) {
      throw new WrongFileFormatException();
    }
    try {
      String valueWithTail[] = fieldsLine.split(" ", 2);
      String valueReversed[] = new StringBuilder(valueWithTail[1]).reverse().toString().trim()
          .split(" ", 2);
      return new StringBuilder(valueReversed[1]).reverse().toString();
    } catch (NullPointerException e) {
      throw new WrongFileFormatException();
    }
  }
*/
  

  
}