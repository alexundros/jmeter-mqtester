package ru.alxpro.jmeter.mqtester;

import static java.lang.Integer.toHexString;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class Helper {

  private static final TransformerFactory tfc = TransformerFactory.newInstance();
  private static final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
  private static final String INDENT_AMOUNT = "{http://xml.apache.org/xslt}indent-amount";

  private Helper() {
  }

  public static String whoIs(Object obj) {
    Thread th = Thread.currentThread();
    return String.format("%s@%s On %s@%s",
        obj.getClass().getSimpleName(), toHexString(obj.hashCode()),
        th.getName(), toHexString(th.hashCode())
    );
  }

  public static String prettyPrintJSON(String src) throws Exception {
    JsonMapper mapper = new JsonMapper();
    String in = src.replaceAll("([^\"]?)(\\$\\{[^\\}]+\\})([^\"]?)", "$1\"$2\"$3");
    Object obj = mapper.readValue(in, Object.class);
    ObjectWriter ow = mapper.writerWithDefaultPrettyPrinter();
    String out = ow.writeValueAsString(obj);
    return out.replaceAll("\"(\\$\\{[^\\}]+\\})\"", "$1");
  }

  public static String prettyPrintXML(String src, boolean omit, int indent) throws Exception {
    Transformer tf = tfc.newTransformer();
    tf.setOutputProperty(OutputKeys.INDENT, "yes");
    tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, omit ? "yes" : "no");
    tf.setOutputProperty(INDENT_AMOUNT, String.valueOf(indent));
    Writer out = new StringWriter();
    InputSource is = new InputSource(new StringReader(src));
    Document doc = dbf.newDocumentBuilder().parse(is);
    tf.transform(new DOMSource(doc), new StreamResult(out));
    return out.toString();
  }

  public static String prettyPrintXML(String src) throws Exception {
    return prettyPrintXML(src, true, 2);
  }
}
