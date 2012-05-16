package co.uniqueid.api.operations;

import org.json.JSONObject;

import co.uniqueid.api.utilities.EncryptText;
import co.uniqueid.api.utilities.JSONUtilities;
import co.uniqueid.api.utilities.URLUtilities;

public class AddPermission {

	// http://jsonpfy.unoidme.appspot.com/AddArrayDataService
	// ?kind=UniqueID&ID=goLiveSource
	// &Permissions=LiveSourceWeb

	private static String saveArrayUrl = "https://jsonpfy.unoidme.appspot.com/AddArrayDataService";

	public static void save(final String uniqueID, final String permissionName) {

		String founded = GetEntityByUniqueID.get(permissionName);

		JSONObject foundedJson = JSONUtilities.getUserJson(founded);

		if (foundedJson == null || !foundedJson.has("ID")) {

			founded = GetUniqueID.getByField("entityName", permissionName);

			foundedJson = JSONUtilities.getUserJson(founded);
		}

		if (foundedJson != null) {

			String foundedID = JSONUtilities.getString(foundedJson, "ID");

			String parameters = "kind=UniqueID";
			parameters += "&ID=" + uniqueID;
			parameters += "&KeyKind=UniqueID";
			parameters += "&Permissions=" + foundedID;

			URLUtilities.fetchURLPost(saveArrayUrl,
					parameters + EncryptText.getAuthParameter());
		}

	}

}
