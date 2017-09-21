package foundtruck.com.br.foundtruck.helper;

/**
 * Created by Aragorn on 20/09/2017.
 */

import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XmlParser {

    // constructor
    public XmlParser() {

    }

    /**
     * Getting XML from URL making HTTP request
     * @param url string
     * */
    public String getXmlFromUrl(String url) {
        String xml = null;

        xml = "<music>"
                +"<song>"
                        +"<id>1</id>"
                        +"<title>Someone Like You</title>"
                        +"<artist>Adele</artist>"
                        +"<duration>4:47</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/adele.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>2</id>"
                        +"<title>Space Bound</title>"
                        +"<artist>Eminem</artist>"
                        +"<duration>4:38</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/eminem.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>3</id>"
                        +"<title>Stranger In Moscow</title>"
                        +"<artist>Michael Jackson</artist>"
                        +"<duration>5:44</duration>"
                        +"<thumb_url>https://api.androidhive.info/music/images/mj.png</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>4</id>"
                        +"<title>Love The Way You Lie</title>"
                        +"<artist>Rihanna</artist>"
                        +"<duration>4:23</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/rihanna.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>5</id>"
                        +"<title>Khwaja Mere Khwaja</title>"
                        +"<artist>A R Rehman</artist>"
                        +"<duration>6:58</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/arrehman.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>6</id>"
                        +"<title>All My Days</title>"
                        +"<artist>Alexi Murdoch</artist>"
                        +"<duration>4:47</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/alexi_murdoch.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>7</id>"
                        +"<title>Life For Rent</title>"
                        +"<artist>Dido</artist>"
                        +"<duration>3:41</duration>"
                        +"<thumb_url>https://api.androidhive.info/music/images/dido.png</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>8</id>"
                        +"<title>Love To See You Cry</title>"
                        +"<artist>Enrique Iglesias</artist>"
                        +"<duration>4:07</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/enrique.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>9</id>"
                        +"<title>The Good, The Bad And The Ugly</title>"
                        +"<artist>Ennio Morricone</artist>"
                        +"<duration>2:42</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/ennio.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>10</id>"
                        +"<title>Show me the meaning</title>"
                        +"<artist>Backstreet Boys</artist>"
                        +"<duration>3:56</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/backstreet_boys.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>11</id>"
                        +"<title>Someone Like You</title>"
                        +"<artist>Adele</artist>"
                        +"<duration>4:47</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/adele.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>12</id>"
                        +"<title>Space Bound</title>"
                        +"<artist>Eminem</artist>"
                        +"<duration>4:38</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/eminem.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>13</id>"
                        +"<title>Stranger In Moscow</title>"
                        +"<artist>Michael Jackson</artist>"
                        +"<duration>5:44</duration>"
                        +"<thumb_url>https://api.androidhive.info/music/images/mj.png</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>14</id>"
                        +"<title>Love The Way You Lie</title>"
                        +"<artist>Rihanna</artist>"
                        +"<duration>4:23</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/rihanna.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>15</id>"
                        +"<title>Khwaja Mere Khwaja</title>"
                        +"<artist>A R Rehman</artist>"
                        +"<duration>6:58</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/arrehman.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>16</id>"
                        +"<title>All My Days</title>"
                        +"<artist>Alexi Murdoch</artist>"
                        +"<duration>4:47</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/alexi_murdoch.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>17</id>"
                        +"<title>Life For Rent</title>"
                        +"<artist>Dido</artist>"
                        +"<duration>3:41</duration>"
                        +"<thumb_url>https://api.androidhive.info/music/images/dido.png</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>18</id>"
                        +"<title>Love To See You Cry</title>"
                        +"<artist>Enrique Iglesias</artist>"
                        +"<duration>4:07</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/enrique.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>19</id>"
                        +"<title>The Good, The Bad And The Ugly</title>"
                        +"<artist>Ennio Morricone</artist>"
                        +"<duration>2:42</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/ennio.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>20</id>"
                        +"<title>Show me the meaning</title>"
                        +"<artist>Backstreet Boys</artist>"
                        +"<duration>3:56</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/backstreet_boys.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>21</id>"
                        +"<title>Someone Like You</title>"
                        +"<artist>Adele</artist>"
                        +"<duration>4:47</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/adele.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>22</id>"
                        +"<title>Space Bound</title>"
                        +"<artist>Eminem</artist>"
                        +"<duration>4:38</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/eminem.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>23</id>"
                        +"<title>Stranger In Moscow</title>"
                        +"<artist>Michael Jackson</artist>"
                        +"<duration>5:44</duration>"
                        +"<thumb_url>https://api.androidhive.info/music/images/mj.png</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>24</id>"
                        +"<title>Love The Way You Lie</title>"
                        +"<artist>Rihanna</artist>"
                        +"<duration>4:23</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/rihanna.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>25</id>"
                        +"<title>Khwaja Mere Khwaja</title>"
                        +"<artist>A R Rehman</artist>"
                        +"<duration>6:58</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/arrehman.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>26</id>"
                        +"<title>All My Days</title>"
                        +"<artist>Alexi Murdoch</artist>"
                        +"<duration>4:47</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/alexi_murdoch.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>27</id>"
                        +"<title>Life For Rent</title>"
                        +"<artist>Dido</artist>"
                        +"<duration>3:41</duration>"
                        +"<thumb_url>https://api.androidhive.info/music/images/dido.png</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>28</id>"
                        +"<title>Love To See You Cry</title>"
                        +"<artist>Enrique Iglesias</artist>"
                        +"<duration>4:07</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/enrique.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>29</id>"
                        +"<title>The Good, The Bad And The Ugly</title>"
                        +"<artist>Ennio Morricone</artist>"
                        +"<duration>2:42</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/ennio.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"<song>"
                        +"<id>30</id>"
                        +"<title>Show me the meaning</title>"
                        +"<artist>Backstreet Boys</artist>"
                        +"<duration>3:56</duration>"
                        +"<thumb_url>"
                        +"https://api.androidhive.info/music/images/backstreet_boys.png"
                        +"</thumb_url>"
                        +"</song>"
                        +"</music>"


        ;
        // return XML
        return xml;
    }

    /**
     * Getting XML DOM element
     * @param xml string
     * */
    public Document getDomElement(String xml){
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder db = dbf.newDocumentBuilder();

            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            doc = db.parse(is);

        } catch (ParserConfigurationException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (SAXException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (IOException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        }

        return doc;
    }

    /** Getting node value
     * @param elem element
     */
    public final String getElementValue( Node elem ) {
        Node child;
        if( elem != null){
            if (elem.hasChildNodes()){
                for( child = elem.getFirstChild(); child != null; child = child.getNextSibling() ){
                    if( child.getNodeType() == Node.TEXT_NODE  ){
                        return child.getNodeValue();
                    }
                }
            }
        }
        return "";
    }

    /**
     * Getting node value
     * @param str String
     * @param item Element
     * */
    public String getValue(Element item, String str) {
        NodeList n = item.getElementsByTagName(str);
        return this.getElementValue(n.item(0));
    }
}