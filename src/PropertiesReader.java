import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
			  System.out.println("Information of all employees");

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
				//get the Employee object
			//	Employee e = getEmployee(el);

				//add it to list
			//	myEmpls.add(e);
			}
		}
		  
	  } catch (Exception e) {
		    e.printStackTrace();
		  }
	  return totalDrinks;
	}

	LinkedList getDrinkElements(String drinkname) {
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
			//for(int i = 0 ; i < nl.getLength();i++) {
			for(int i = 0 ; i < 2;i++) {

				//get the employee element
				Element el = (Element)nl.item(i);
				System.out.println("current drink element:" + getTextValue( el, "name", 2));
				//get the Employee object
			//	Employee e = getEmployee(el);

				//add it to list
			//	myEmpls.add(e);
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
		}

		return textVal;
	}

}
