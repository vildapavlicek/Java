package Utils;

import Classes.Place;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class KmlCreator {

    DocumentBuilderFactory docFactory;
    DocumentBuilder docBuilder;
    Document doc;

    public KmlCreator(ArrayList<Place> places) throws ParserConfigurationException, TransformerException {
        this.init();
        Element root = this.generateRoot();
        places.stream().forEach(p -> {
            try {
                this.generateBody(p, root);
            } catch (TransformerException ex) {
                Logger.getLogger(KmlCreator.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer t = tFactory.newTransformer();

        DOMSource ds = new DOMSource(doc);
        StreamResult result = new StreamResult(System.out);
        t.transform(ds, result);
    }

    private void init() throws ParserConfigurationException {
        this.docFactory = DocumentBuilderFactory.newInstance();
        this.docBuilder = docFactory.newDocumentBuilder();
        this.doc = docBuilder.newDocument();
    }

    private Element generateRoot() {
        Element rootElement = doc.createElement("kml");
        doc.appendChild(rootElement);
        Attr kml = doc.createAttribute("xmlns");
        kml.setValue("http://www.opengis.net/kml/2.2");
        rootElement.setAttributeNode(kml);
        return rootElement;
    }

    private void generateBody(Place p, Element root) throws TransformerConfigurationException, TransformerException {
        /*
        <?xml version="1.0" encoding="UTF-8"?>
        <kml xmlns="http://www.opengis.net/kml/2.2">
            <Placemark>
                <name>Simple placemark</name>
                <description>Attached to the ground. Intelligently places itself 
                at the height of the underlying terrain.</description>
                <Point>
                    <coordinates>-122.0822035425683,37.42228990140251,0</coordinates>
                </Point>
            </Placemark>
        </kml>
         */

        Element placemarkElement = this.doc.createElement("Placemark");
        root.appendChild(placemarkElement);

        Element nameElement = doc.createElement("name");
        nameElement.appendChild(doc.createTextNode(p.getName()));
        placemarkElement.appendChild(nameElement);

        Element descriptionElement = doc.createElement("description");
        CDATASection cdataSection = doc.createCDATASection("<span class=\"placeId\" style=\"visibility:hidden\">" + p.getId() + "</span>");
        placemarkElement.appendChild(descriptionElement);
        descriptionElement.appendChild(cdataSection);

        Element pointElement = doc.createElement("Point");
        Element coordsElement = doc.createElement("coordinates");
        coordsElement.appendChild(doc.createTextNode(Double.toString(p.getLl().lat) + "," + Double.toString(p.getLl().lng)));
        pointElement.appendChild(coordsElement);
        placemarkElement.appendChild(pointElement);
    }
}
