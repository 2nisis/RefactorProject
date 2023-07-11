package incometaxcalculator.data.management;

import incometaxcalculator.exceptions.WrongReceiptDateException;

public class Receipt {

  private final int id;
  private final Date issueDate;
  private final float amount;
  private final String kind;
  private final String company;
  
  private final Address address;
  


  public Receipt(int id, String issueDate, float amount, String kind, String company ,String country, String city, String street, int number)
      throws WrongReceiptDateException {
    this.id = id;
    this.issueDate = createDate(issueDate);
    this.amount = amount;
    this.kind = kind;
    this.company = company;
    this.address = new Address(country, city, street, number);
  }

  private Date createDate(String issueDate) throws WrongReceiptDateException {
    String token[] = issueDate.split("/");
    if (token.length != 3) {
      throw new WrongReceiptDateException();
    }
    int day = Integer.parseInt(token[0]);
    int month = Integer.parseInt(token[1]);
    int year = Integer.parseInt(token[2]);
    return new Date(day, month, year);
  }

  public int getId() {
    return id;
  }

  public String getIssueDate() {
    return issueDate.toString();
  }

  public float getAmount() {
    return amount;
  }

  public String getKind() {
    return kind;
  }

  public String getCompany() {
    return company;
  }
  
  public Address getAddress() {
    return address;
  }


}