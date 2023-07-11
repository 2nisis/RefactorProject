package incometaxcalculator.data.io;

import java.io.BufferedReader;
import java.io.IOException;

import incometaxcalculator.exceptions.WrongFileFormatException;
//https://refactoring.guru/smells/duplicate-code
public class TXTFileReader extends FileReader {
  
  private String format = "Receipt ID";
  private String delimeter = ":";
  private int splitStep = 2;
  
  public String getDelimeter() {
    return delimeter;
  }
  public int getSplitStep() {
    return splitStep;
  }
  public String getFormat() {
    return format;
  }
  
  protected String getDecodedValueOfField(String fieldsLine) {
    return fieldsLine;
  }
  
 /*
   // @overrides same method in superclass for testing purposes
  protected int checkForReceipt(BufferedReader inputStream)
      throws NumberFormatException, IOException {
    String line;
    while (!isEmpty(line = inputStream.readLine())) {
      String values[] = line.split(" ", 3);
      if (values[0].equals("Receipt")) {
        if (values[1].equals("ID:")) {
          int receiptId = Integer.parseInt(values[2].trim());
          return receiptId;
        }
      }
    }
    return -1;
  }
  
  protected String getValueOfField(String fieldsLine) throws WrongFileFormatException {
    if (isEmpty(fieldsLine)) {
      throw new WrongFileFormatException();
    }
    try {
      String values[] = fieldsLine.split(" ", 2);
      values[1] = values[1].trim();
      return values[1];
    } catch (NullPointerException e) {
      throw new WrongFileFormatException();
    }
  }
  
  */

}


