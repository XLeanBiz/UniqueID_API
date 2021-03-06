package co.uniqueid.api.operations;

import co.uniqueid.api.utilities.EncryptText;
import co.uniqueid.api.utilities.URLUtilities;

public class DeleteFounded {

	// http://jsonpfy.unoidme.appspot.com/DeleteArrayDataService
	// ?kind=UniqueID&ID=goLiveSource
	// &Founded=LiveSourceWeb

	private static String saveArrayUrl = "https://jsonpfy.unoidme.appspot.com/DeleteArrayDataService";

	public static void delete(final String uniqueID, final String foundedID) {

		String parameters = "kind=UniqueID";

		parameters += "&ID=" + uniqueID;
		parameters += "&KeyKind=UniqueID";
		parameters += "&Founded=" + foundedID;

		URLUtilities.fetchURLPost(saveArrayUrl,
				parameters + EncryptText.getAuthParameter());

	}

}
