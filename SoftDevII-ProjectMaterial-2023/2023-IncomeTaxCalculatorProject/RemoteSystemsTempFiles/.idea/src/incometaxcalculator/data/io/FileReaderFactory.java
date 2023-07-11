package incometaxcalculator.data.io;

import incometaxcalculator.exceptions.WrongFileEndingException;

public class FileReaderFactory {

  public FileReader generateFileReader(String fileName) throws WrongFileEndingException {

    String ending[] = fileName.split("\\.");
    if (ending[1].equals("txt")) {
      FileReader reader = new TXTFileReader();
      return reader;
    } else if (ending[1].equals("xml")) {
      FileReader reader = new XMLFileReader();
      return reader;
    } else {
      throw new WrongFileEndingException();
    }
  }
}
