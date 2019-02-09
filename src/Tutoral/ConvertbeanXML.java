package Tutoral;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ConvertbeanXML {

	public static void main(String[] args) throws Exception  {
		Item bean = new Item();
	    bean.setId(new Long(1));
	    bean.setItemName("a");
	    bean.setItemColour("Red");
	    bean.setItemQuantities(new Integer(100));

	    XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("C:\\test\\Bean.xml")));

	    encoder.writeObject(bean);
	    encoder.close();

	}

}


class Item {
  private Long id;
  private String itemName;
  private String itemColour;
  private Integer itemQuantities;
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getItemName() {
    return itemName;
  }
  public void setItemName(String itemName) {
    this.itemName = itemName;
  }
  public String getItemColour() {
    return itemColour;
  }
  public void setItemColour(String itemColour) {
    this.itemColour = itemColour;
  }
  public Integer getItemQuantities() {
    return itemQuantities;
  }
  public void setItemQuantities(Integer itemQuantities) {
    this.itemQuantities = itemQuantities;
  }
}



