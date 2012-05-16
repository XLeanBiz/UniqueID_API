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

		String permission = GetEntityByUniqueID.get(permissionName);

		JSONObject permissionJson = JSONUtilities.getUserJson(permission);

		if (permissionJson == null || !permissionJson.has("ID")) {

			permission = GetUniqueID.getByField("entityName", permissionName);

			permissionJson = JSONUtilities.getUserJson(permission);
		}

		if (permissionJson != null) {

			String permissionID = JSONUtilities.getString(permissionJson, "ID");

			String parameters = "kind=UniqueID";
			parameters += "&ID=" + uniqueID;
			parameters += "&KeyKind=UniqueID";
			parameters += "&Permissions=" + permissionID;

			URLUtilities.fetchURLPost(saveArrayUrl,
					parameters + EncryptText.getAuthParameter());

			// Save inverted positions
			parameters = "kind=UniqueID";
			parameters += "&ID=" + permissionID;
			parameters += "&KeyKind=UniqueID";
			parameters += "&Permissions=" + uniqueID;

			URLUtilities.fetchURLPost(saveArrayUrl,
					parameters + EncryptText.getAuthParameter());
		}

	}

}
