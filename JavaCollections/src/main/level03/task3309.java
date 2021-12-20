package level03;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.StringWriter;

public class task3309 {
	
	public static String toXmlWithComment(Object obj, String tagName, String comment)
			throws JAXBException {
		StringWriter writer = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(obj, writer);
		
		String tag = "<" + tagName + ">";
		String com = "<!--" + comment + "-->";
		
		return writer.toString().replaceAll(tag, com + "\n" + tag);
	}
	
	public static void main(String[] args)
			throws JAXBException {
		TestObject test = new TestObject("Some1", "Some2", "Some3", "<![CDATA[need CDATA because of <and> ]]>");
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n"
				+ "<first>\n"
				+ "<second>some string</second>\n"
				+ "<second>some string</second>\n"
				+ "<second><![CDATA[need CDATA because of <and> ]]></second>\n"
				+ "</second>\n"
				+ "</first>\n"
				+ "\n";
		
		String result = toXmlWithComment(test, "second", "comment added");
		System.out.println(result);
	}
	
	@XmlRootElement
	@XmlType(name = "root")
	public static class TestObject {
		
		public String first;
		public String[] second;
		
		public TestObject(String first, String... second) {
			this.first = first;
			this.second = second;
		}
		
		public TestObject() {
		
		}
		
	}
	
}