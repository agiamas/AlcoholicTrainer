import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Iterator;
import java.util.LinkedList;

public class PropertiesReader {
String propFile;
LinkedList totalDrinks;
	PropertiesReader(String propFile) {
		this.propFile = propFile;
		//init class to read the xml file with drinks settings
	}
	
	Document getDocument() {
		  try {
			  File file = new File(this.propFile);
			  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			  DocumentBuilder db = dbf.newDocumentBuilder();
			  Document doc = db.parse(file);
			  doc.getDocumentElement().normalize();
			  System.out.println("Root element " + doc.getDocumentElement().getNodeName());
			  NodeList nodeLst = doc.getElementsByTagName("drink");
			
			  for (int s = 0; s < nodeLst.getLength(); s++) {

			    Node fstNode = nodeLst.item(s);
			    
			    if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
			  
			           Element fstElmnt = (Element) fstNode;
			      NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("ingredients");
			      Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
			      NodeList fstNm = fstNmElmnt.getChildNodes();
			      NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("name");
			      Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
			      NodeList lstNm = lstNmElmnt.getChildNodes();
			    }
			    return doc;
			  }
			  } catch (Exception e) {
			    e.printStackTrace();
			  }
			return null;
	}

	/*
	 * return a list of all the drink names.
	 */

	
	LinkedList getDrinks() {
		try {
			totalDrinks = new LinkedList();
		 LinkedList drinks = new LinkedList();
		  File file = new File(this.propFile);
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  Document doc = db.parse(file);
		//get the root element
		Element docEle = doc.getDocumentElement();

		//get a nodelist of  elements
		NodeList nl = docEle.getElementsByTagName("drink");
		if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {

				//get the employee element
				Element el = (Element)nl.item(i);
				totalDrinks.add(getTextValue(el,"drinkname", 2));
			}
		}
		  
	  } catch (Exception e) {
		    e.printStackTrace();
		  }
	  return totalDrinks;
	}
//attribute is 0 default for just the name,1 for quantity, 2 for special instructions
	LinkedList getDrinkElements(String drinkname, int attribute) {
	String currentValue;
	String attributeValue;
	if(attribute == 0) {
		attributeValue = "name";
	}
	else if(attribute == 1) {
		attributeValue = "quantity";
	}
	else if(attribute == 2) {
		attributeValue = "specialInstruction";
	}
	else {
		// return the drink elements names by default
		attributeValue = "name";
	}
	try {
		System.out.println("drinkname:" + drinkname);
		totalDrinks = new LinkedList();
		LinkedList drinks = new LinkedList();
		File file = new File(this.propFile);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		//get the root element
		Element docEle = doc.getDocumentElement();
		
		//get a nodelist of elements
		NodeList nl = docEle.getElementsByTagName("drink");
		for (int s = 0; s < nl.getLength(); s++) {
			Node fstNode = nl.item(s);
			if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
				Element fstElmnt = (Element) fstNode;
				
				NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("drinkname");
				Element lstNmElmnt = (Element) lstNmElmntLst.item(0);
				NodeList lstNm = lstNmElmnt.getChildNodes();
				String currentDrinkName = ((Node) lstNm.item(0)).getNodeValue();
				System.out.println("drink name: " + ((Node) lstNm.item(0)).getNodeValue());	
				if(currentDrinkName.equals(drinkname) ){
					NodeList fstNmElmntLst = fstElmnt.getElementsByTagName(attributeValue);
					for(int temp = 0; temp < fstNmElmntLst.getLength(); temp++) {
					Element fstNmElmnt = (Element) fstNmElmntLst.item(temp);
					NodeList fstNm = fstNmElmnt.getChildNodes();
					for(int temp2 = 0 ; temp2 < fstNm.getLength(); temp2++) {
						String currentDrinkElement = ((Node) fstNm.item(temp2)).getNodeValue();
						totalDrinks.add(currentDrinkElement);
					//	System.out.println("drink element : " + ((Node) fstNm.item(temp2)).getNodeValue());	
					}
					}
				}
			}
		}
	} catch (Exception e) {
		    e.printStackTrace();
		  }
	  return totalDrinks;
	}

	private String getTextValue(Element ele, String tagName, int index) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
			//textVal = el.getNodeName();
			//textVal = el.getNodeValue();
		}

		return textVal;
	}

}
