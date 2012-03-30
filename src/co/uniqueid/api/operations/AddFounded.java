package co.uniqueid.api.operations;

import org.json.JSONObject;

public class AddFounded {

	// http://jsonpfy.unoidme.appspot.com/AddArrayDataService
	// ?kind=UniqueID&ID=goLiveSource
	// &Founded=LiveSourceWeb

	private static String saveArrayUrl = "http://jsonpfy.unoidme.appspot.com/AddArrayDataService";

	public static void save(final String uniqueID, final String foundedParameter) {

		String founded = GetEntityByUniqueID.get(foundedParameter);

		JSONObject foundedJson = JSONUtilities.getUserJson(founded);

		if (foundedJson == null) {

			founded = GetUniqueID.getByField("entityName", foundedParameter);

			foundedJson = JSONUtilities.getUserJson(founded);
		}

		if (foundedJson != null) {

			String foundedID = JSONUtilities.getString(foundedJson, "ID");

			String parameters = "kind=UniqueID";

			parameters += "&ID=" + uniqueID;

			parameters += "&Founded=" + foundedID;

			URLUtilities.fetchURLPost(saveArrayUrl, parameters);

			// Save inverted positions
			parameters = "kind=UniqueID";

			parameters += "&ID=" + foundedID;

			parameters += "&Founded=" + uniqueID;

			URLUtilities.fetchURLPost(saveArrayUrl, parameters);
		}

	}

}
