package co.uniqueid.api.operations;

import co.uniqueid.api.utilities.EncryptText;
import co.uniqueid.api.utilities.URLUtilities;

public class ListFounded {

	// http://jsonpfy.unoidme.appspot.com/ListSubArrayService
	// ?kind=Entity
	// &ID=goLiveSource
	// &fieldSubArray=groupConnections

	private static String getListContactsUrl = "https://jsonpfy.unoidme.appspot.com/ListSubArrayService";

	public static String list(final String uniqueID) {

		String parameters = "kind=UniqueID&ID=" + uniqueID
				+ "&fieldSubArray=Founded";

		final String jsonString = URLUtilities.fetchURLPost(getListContactsUrl,
				parameters + EncryptText.getAuthParameter());

		String groupJsonString = ListContactsFromGroup
				.getFoundedInfo(jsonString);

		return groupJsonString;

	}

}
