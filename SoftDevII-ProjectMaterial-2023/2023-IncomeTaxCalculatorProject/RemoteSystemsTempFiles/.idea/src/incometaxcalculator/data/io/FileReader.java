package incometaxcalculator.data.io;

import java.io.BufferedReader;
import java.io.IOException;

import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.WrongReceiptDateException;
import incometaxcalculator.exceptions.WrongFileFormatException;
import incometaxcalculator.exceptions.WrongReceiptKindException;
import incometaxcalculator.exceptions.WrongTaxpayerStatusException;

public abstract class FileReader {

  protected abstract String getFormat(); 
  protected abstract String getDelimeter();
  protected abstract int getSplitStep();
  protected abstract String getDecodedValueOfField(String fieldsLine);
  
  protected String getValueOfField(String fieldsLine) throws WrongFileFormatException {
    if (isEmpty(fieldsLine)) {
      throw new WrongFileFormatException();
    }
    try {
      String values[] = fieldsLine.split(" ", 2);
      values[1] = values[1].trim();
      return getDecodedValueOfField(values[1]);
    } catch (NullPointerException e) {
      throw new WrongFileFormatException();
    }
  }
  protected int checkForReceipt(BufferedReader inputStream) throws NumberFormatException, IOException {
    String line;
    while (!isEmpty(line = inputStream.readLine())) {
      String values[] = line.split( getDelimeter(), getSplitStep());
      if (values[0].equals(getFormat())) {
        int receiptId = Integer.parseInt(values[1].trim());
        return receiptId;
      }
    }
    return -1;
  }
 


  /**
   * 
   * @throws NumberFormatException 
   * @throws IOException xcvcxcvcxvxc
   * @throws WrongTaxpayerStatusException
   * @throws WrongFileFormatException
   * @throws WrongReceiptKindException
   * @throws WrongReceiptDateException
   */
  public void readFile(String fileName)
      throws NumberFormatException, IOException, WrongTaxpayerStatusException,
      WrongFileFormatException, WrongReceiptKindException, WrongReceiptDateException {

    BufferedReader inputStream = new BufferedReader(new java.io.FileReader(fileName));
    String fullname = getValueOfField(inputStream.readLine());
    int taxRegistrationNumber = Integer.parseInt(getValueOfField(inputStream.readLine()));
    String status = getValueOfField(inputStream.readLine());
    float income = Float.parseFloat(getValueOfField(inputStream.readLine()));
    createTaxpayer(fullname, taxRegistrationNumber, income, status);
    while (readReceipt(inputStream, taxRegistrationNumber));
  }

  protected boolean readReceipt(BufferedReader inputStream, int taxRegistrationNumber)
      throws WrongFileFormatException, IOException, WrongReceiptKindException,
      WrongReceiptDateException {

    int receiptId;
    if ((receiptId = checkForReceipt(inputStream)) < 0) {
      return false;
    }
    String issueDate = getValueOfField(inputStream.readLine());
    String kind = getValueOfField(inputStream.readLine());
    float amount = Float.parseFloat(getValueOfField(inputStream.readLine()));
    String companyName = getValueOfField(inputStream.readLine());
    String country = getValueOfField(inputStream.readLine());
    String city = getValueOfField(inputStream.readLine());
    String street = getValueOfField(inputStream.readLine());
    int number = Integer.parseInt(getValueOfField(inputStream.readLine()));
    createReceipt(receiptId, issueDate, amount, kind, companyName, country, city, street, number,
        taxRegistrationNumber);
    return true;
  }

  protected void createTaxpayer(String fullname, int taxRegistrationNumber, float income,
      String status) throws WrongTaxpayerStatusException {

    TaxpayerManager manager = new TaxpayerManager();
    manager.createTaxpayer(fullname, taxRegistrationNumber, status, income);
  }

  protected void createReceipt(int receiptId, String issueDate, float amount, String kind,
      String companyName, String country, String city, String street, int number,
      int taxRegistrationNumber) throws WrongReceiptKindException, WrongReceiptDateException {

    TaxpayerManager manager = new TaxpayerManager();
    manager.createReceipt(receiptId, issueDate, amount, kind, companyName, country, city, street,
        number, taxRegistrationNumber);
  }

  protected boolean isEmpty(String line) {
    if (line == null) {
      return true;
    } else {
      return false;
    }
  }

}