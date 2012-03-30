package co.uniqueid.api.operations;

import org.json.JSONObject;

public class AddContact {

	// http://jsonpfy.unoidme.appspot.com/AddArrayDataService
	// ?kind=UniqueID&ID=goLiveSource
	// &Founded=LiveSourceWeb

	private static String saveArrayUrl = "http://jsonpfy.unoidme.appspot.com/AddArrayDataService";

	public static void save(final String uniqueID, final String contactParameter) {

		String contact = GetEntityByUniqueID.get(contactParameter);

		JSONObject contactJson = JSONUtilities.getUserJson(contact);

		if (contactJson == null) {

			contact = GetUniqueID.getByField("entityName", contactParameter);

			contactJson = JSONUtilities.getUserJson(contact);
		}

		if (contactJson != null) {

			String contactID = JSONUtilities.getString(contactJson, "ID");

			String parameters = "kind=UniqueID";

			parameters += "&ID=" + uniqueID;

			parameters += "&Contacts=" + contactID;

			URLUtilities.fetchURLPost(saveArrayUrl, parameters);
		}

	}

}
