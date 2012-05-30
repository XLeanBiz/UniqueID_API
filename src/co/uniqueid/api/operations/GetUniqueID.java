package co.uniqueid.api.operations;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import co.uniqueid.api.utilities.EncryptText;
import co.uniqueid.api.utilities.URLUtilities;

public class GetUniqueID {

	// http://jsonpfy.unoidme.appspot.com/ListDataService
	// ?kind=Entity
	// &filterField=email&filterValue=alline.oliveira@gmail.com

	private static String getUniqueIDUrl = "https://jsonpfy.unoidme.appspot.com/ListDataService";

	public static String getByField(final String fieldName,
			final String fieldValue) {

		String parameters = "kind=UniqueID&filterField=" + fieldName
				+ "&filterValue=" + fieldValue;

		String jsonString = URLUtilities.fetchURLPost(getUniqueIDUrl,
				parameters + EncryptText.getAuthParameter());

		jsonString = getInfo(jsonString);

		return jsonString;
	}

	private static String getInfo(String jsonString) {

		JSONArray idsWithInfo = new JSONArray();

		JSONArray ids;
		try {
			ids = new JSONArray(jsonString);

			for (int j = 0; j < ids.length(); j++) {

				JSONObject entityID = GetEntityByUniqueID
						.getInformation((JSONObject) ids.get(j));

				idsWithInfo.put(entityID);
			}

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return idsWithInfo.toString();
	}
}
