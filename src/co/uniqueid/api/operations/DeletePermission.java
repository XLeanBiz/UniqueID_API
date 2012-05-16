package co.uniqueid.api.operations;

import co.uniqueid.api.utilities.EncryptText;
import co.uniqueid.api.utilities.URLUtilities;

public class DeletePermission {

	// http://jsonpfy.unoidme.appspot.com/DeleteArrayDataService
	// ?kind=UniqueID&ID=goLiveSource
	// &Permissions=LiveSourceWeb

	private static String saveArrayUrl = "https://jsonpfy.unoidme.appspot.com/DeleteArrayDataService";

	public static void delete(final String uniqueID, final String permissionID) {

		String parameters = "kind=UniqueID";

		parameters += "&ID=" + uniqueID;
		parameters += "&KeyKind=UniqueID";
		parameters += "&Permissions=" + permissionID;

		URLUtilities.fetchURLPost(saveArrayUrl,
				parameters + EncryptText.getAuthParameter());

		// Save inverted positions
		/*
		 * parameters = "kind=UniqueID";
		 * 
		 * parameters += "&ID=" + foundedID;
		 * 
		 * parameters += "&Founded=" + uniqueID;
		 * 
		 * URLUtilities.fetchURLPost(saveArrayUrl, parameters);
		 */
	}

}
