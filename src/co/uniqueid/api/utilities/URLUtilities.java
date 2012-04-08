package co.uniqueid.api.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;


public class URLUtilities {

	private static Logger logger = Logger.getLogger("UnoIDMe");

	public static String encode(final String text) {
		try {
			return URLEncoder.encode(text, "UTF-8");
		} catch (final UnsupportedEncodingException e) {
			throw new IllegalStateException(e);
		}
	}

	public static String decode(final String text) {

		if (text != null) {

			try {
				return URLDecoder.decode(text, "UTF-8");
			} catch (final UnsupportedEncodingException e) {
				throw new IllegalStateException(e);
			}
		} else {

			return null;
		}
	}

	public static String fetchURLGet(final String u, String parameters) {

		String returnedString = "";
		try {

			final URL url = new URL(u + "?" + parameters);

			// logger.log(Level.INFO, "fetchURLGet=" + url);

			final BufferedReader reader = new BufferedReader(
					new InputStreamReader(url.openStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				returnedString += line;
			}
			reader.close();
		} catch (final MalformedURLException e) {
			System.out.println("MalformedURLException calling url" + u
					+ e.getMessage());
		} catch (final IOException e) {
			System.out.println("IOException calling url" + u + e.getMessage());
		}
		return returnedString;
	}

	public static String fetchURLPost(final String u, String parameters) {

		String returnedString = "";
		try {

			final URL url = new URL(u);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			OutputStreamWriter writer = new OutputStreamWriter(
					connection.getOutputStream());
			writer.write(parameters);
			writer.close();
			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(connection.getInputStream()));
				String line;
				while ((line = reader.readLine()) != null) {
					returnedString += line;
				}
				reader.close();
			} else {
				System.out.println(connection.getResponseMessage());
				logger.log(Level.INFO, "connection.getResponseMessage()=" + u
						+ parameters + connection.getResponseMessage());
				returnedString += "erro:" + u + parameters
						+ connection.getResponseCode();
			}
		} catch (final MalformedURLException e) {
			System.out.println("MalformedURLException calling url" + u
					+ e.getMessage());
			logger.log(Level.INFO, "e.getMessage()=" + e.getMessage());
			returnedString += u + parameters + e.getMessage();
		} catch (final IOException e) {
			System.out.println("IOException calling url" + u + e.getMessage());
			logger.log(Level.INFO, "e.getMessage()=" + e.getMessage());
			returnedString += u + parameters + e.getMessage();
		}

		return returnedString;
	}

	public static String addSaveParameter(JSONObject json, String parameter) {

		String parameterValue = JSONUtilities.getString(json, parameter);
		if (parameterValue != null) {
			return "&fieldsKind=String&fieldsName=" + parameter
					+ "&fieldsValue=" + URLUtilities.encode(parameterValue);
		} else {

			return "";
		}
	}

	public static String addSaveParameterString(String value, String parameter) {

		if (value != null) {
			return "&fieldsKind=String&fieldsName=" + parameter
					+ "&fieldsValue=" + URLUtilities.encode(value);
		} else {

			return "";
		}
	}

	public static String addSaveParameterText(String value, String parameter) {

		if (value != null) {
			return "&fieldsKind=Text&fieldsName=" + parameter + "&fieldsValue="
					+ URLUtilities.encode(value);
		} else {

			return "";
		}
	}
	
	public static String compactName(String name) {

		name = name.replaceAll("\\.","");
		
		String[] words = (name.trim()).split(" ");

		String compressedFileName = "";

		for (int i = 0; i < words.length; i++) {

			String word = words[i];

			word = (word.substring(0, 1)).toUpperCase() + word.substring(1);

			compressedFileName += word;
		}

		return compressedFileName;
	}
}