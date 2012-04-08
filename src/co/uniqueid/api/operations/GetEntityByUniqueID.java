package co.uniqueid.api.operations;

import org.json.JSONException;
import org.json.JSONObject;

import co.uniqueid.api.utilities.EncryptText;
import co.uniqueid.api.utilities.URLUtilities;

public class GetEntityByUniqueID {

	// http://jsonpfy.unoidme.appspot.com/GetDataService
	// ?kind=UniqueID
	// &ID=FB_alline.oliveira

	private static String getUnoUserUrl = "https://jsonpfy.unoidme.appspot.com/GetDataService";

	public static String get(final String unoUserID) {

		String parameters = "kind=UniqueID&ID=" + unoUserID;

		final String jsonString = URLUtilities.fetchURLPost(getUnoUserUrl,
				parameters + EncryptText.getAuthParameter());

		return jsonString;
	}

	public static JSONObject getBasicInfo(final String unoUserID) {

		final String jsonString = get(unoUserID);

		JSONObject basicInfo = new JSONObject();

		try {

			JSONObject obj = new JSONObject(jsonString);

			basicInfo.put("ID", obj.get("ID"));

			basicInfo.put("entityName", obj.get("entityName"));

			if (obj.has("image")) {

				basicInfo.put("image", obj.get("image"));
			}

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return basicInfo;
	}
}
