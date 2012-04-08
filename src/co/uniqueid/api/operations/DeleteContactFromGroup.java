package co.uniqueid.api.operations;

import co.uniqueid.api.utilities.EncryptText;
import co.uniqueid.api.utilities.URLUtilities;

public class DeleteContactFromGroup {

	// http://jsonpfy.unoidme.appspot.com/DeleteArrayDataService
	// ?kind=Groups&ID=goLiveSource
	// &Founded=LiveSourceWeb

	private static String saveArrayUrl = "https://jsonpfy.unoidme.appspot.com/DeleteArrayDataService";

	public static void delete(final String groupID, final String contactID) {

		String parameters = "kind=Groups";

		parameters += "&ID=" + groupID;

		parameters += "&KeyKind=UniqueID";

		parameters += "&Contacts=" + contactID;

		URLUtilities.fetchURLPost(saveArrayUrl,
				parameters + EncryptText.getAuthParameter());
	}

}
