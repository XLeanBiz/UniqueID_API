package co.uniqueid.api.operations;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtilities {

	public static String getString(final JSONObject json, final String key) {

		String value = null;
		try {
			value = json.getString(key);
		} catch (JSONException e) {
			//e.printStackTrace();
		}
		return value;
	}
	
	public static JSONObject getUserJson(String jsonString) {

		JSONObject userJsonObject = null;

		if (jsonString != null && !jsonString.equals("")) {

			try {

				JSONArray json = new JSONArray(jsonString);
				userJsonObject = (JSONObject) json.get(0);

			} catch (JSONException e) {
				// e.printStackTrace();
			}
		}

		return userJsonObject;
	}
	
	public static String convertToEntityID(String jsonEntity) {

		jsonEntity = jsonEntity.replace("UniqueID(\"", "");
		jsonEntity = jsonEntity.replace("\")", "");

		return jsonEntity;
	}

}