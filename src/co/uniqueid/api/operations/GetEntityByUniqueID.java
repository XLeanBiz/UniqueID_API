package co.uniqueid.api.operations;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import co.uniqueid.api.utilities.EncryptText;
import co.uniqueid.api.utilities.JSONUtilities;
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

	public static String getWithInfo(final String unoUserID) {

		String jsonString = get(unoUserID);

		jsonString = getInformation(jsonString);

		return jsonString;
	}

	public static String getInformation(String jsonString) {

		JSONObject json;
		try {

			json = new JSONObject(jsonString);

			json = getInformation(json);

			return json.toString();

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return null;
	}

	public static JSONObject getInformation(JSONObject json) {

		try {
			if (!json.isNull("Founded")) {

				JSONArray foundeds = (JSONArray) json.get("Founded");

				json.put("FoundedInfo", getGroupInfo(foundeds));

			}

			if (!json.isNull("Permissions")) {

				JSONArray permissions = (JSONArray) json.get("Permissions");

				json.put("PermissionsInfo", getGroupInfo(permissions));
			}

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return json;
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

	public static JSONArray getGroupInfo(final JSONArray groupList) {

		JSONArray groupArray = new JSONArray();

		if (groupList != null) {

			for (int j = 0; j < groupList.length(); j++) {

				String entityID;
				try {

					entityID = (String) groupList.get(j);

					JSONObject entity = GetEntityByUniqueID
							.getBasicInfo(JSONUtilities
									.convertToEntityID(entityID));

					groupArray.put(entity);

				} catch (JSONException e) {

					e.printStackTrace();
				}

			}
		}

		return groupArray;
	}
}
