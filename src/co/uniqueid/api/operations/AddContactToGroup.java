package co.uniqueid.api.operations;

import org.json.JSONObject;

import co.uniqueid.api.utilities.EncryptText;
import co.uniqueid.api.utilities.JSONUtilities;
import co.uniqueid.api.utilities.URLUtilities;

public class AddContactToGroup {

	// http://jsonpfy.unoidme.appspot.com/AddArrayDataService
	// ?kind=UniqueID&ID=goLiveSource
	// &Founded=LiveSourceWeb

	private static String saveArrayUrl = "https://jsonpfy.unoidme.appspot.com/AddArrayDataService";

	public static void save(final String groupID, final String contactParameter) {

		String contact = GetEntityByUniqueID.get(contactParameter);

		JSONObject contactJson = JSONUtilities.getUserJson(contact);

		if (contactJson == null || !contactJson.has("ID")) {

			contact = GetUniqueID.getByField("entityName", contactParameter);

			contactJson = JSONUtilities.getUserJson(contact);
		}

		if (contactJson != null) {

			String contactID = JSONUtilities.getString(contactJson, "ID");

			String parameters = "kind=Groups";

			parameters += "&ID=" + groupID;
			
			parameters += "&KeyKind=UniqueID";

			parameters += "&Contacts=" + contactID;

			URLUtilities.fetchURLPost(saveArrayUrl, parameters
					+ EncryptText.getAuthParameter());
		}

	}

}
