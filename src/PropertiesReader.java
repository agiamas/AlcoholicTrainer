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
		  LinkedList drinks = new LinkedList();
		  File file = new File(this.propFile);
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		  DocumentBuilder db = dbf.newDocumentBuilder();
		  Document doc = db.parse(file);
		  doc.getDocumentElement().normalize();
		  
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
		    	drinks.add(((Node) lstNm.item(0)).getNodeValue());
		  //    	System.out.println("drink: " + ((Node) lstNm.item(0)).getNodeValue());
		    }
		  }
		  //  drinks.add(nodeLst.item(i));
		  return drinks;
		  
		  } catch (Exception e) {
			    e.printStackTrace();
			  }
		  return null;
	}
}
