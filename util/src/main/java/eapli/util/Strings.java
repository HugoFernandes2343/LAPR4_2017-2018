/**
 *
 */
package eapli.util;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Random;

/**
 * utility class for string manipulation
 *
 * @author Paulo Gandra Sousa
 */
public class Strings {

	private static final String CHARSET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	private Strings() {
		// to make sure this is an utility class
	}

	/**
	 * checks whether a String is empty (zero length or all spaces) or null
	 *
	 * @param text
	 * @return
	 */
	public static boolean isNullOrEmpty(String text) {
		return ((text == null) || (text.isEmpty()));
	}

	/**
	 * checks whether a String is empty (zero length or all spaces) or null
	 *
	 * @param text
	 * @return
	 */
	public static boolean isNullOrWhiteSpace(final String text) {
		return (text == null || text.trim().isEmpty());
	}

	public static String prettyFormat(final String input) {
		return prettyFormat(input, 2);
	}

	/**
	 * returns an XML formated output.
	 * <p>
	 * based in code from <a href=
	 * "http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java">
	 * stack overflow</a>
	 *
	 * @param input
	 * @param indent
	 * @return
	 */
	public static String prettyFormat(final String input, final int indent) {
		try {
			final Source xmlInput = new StreamSource(new StringReader(input));
			final StringWriter stringWriter = new StringWriter();
			final StreamResult xmlOutput = new StreamResult(stringWriter);
			final TransformerFactory transformerFactory = TransformerFactory.newInstance();
			transformerFactory.setAttribute("indent-number", indent);
			final Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(xmlInput, xmlOutput);
			return xmlOutput.getWriter().toString();
		} catch (final IllegalArgumentException | TransformerException e) {
			throw new RuntimeException(e); // TODO review it
		}
	}

	public static String randomString(int len) {
		return randomString(len, CHARSET);
	}

	public static String randomString(int len, String charSet) {
		final Random rnd = new Random();
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			final int c = rnd.nextInt(charSet.length());
			sb.append(charSet.charAt(c));
		}
		return sb.toString();
	}

	public static String truncate(String org, int len) {
		if (len < org.length()) {
			return org.substring(0, len);
		} else {
			return org;
		}
	}

	public static String left(String org, int len) {
		return org.substring(0, len);
	}

	public static String right(String org, int len) {
		return org.substring(org.length() - len);
	}
}
