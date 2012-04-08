package co.uniqueid.api.operations;

import co.uniqueid.api.utilities.EncryptText;
import co.uniqueid.api.utilities.URLUtilities;

public class ListGroups {

	// http://jsonpfy.unoidme.appspot.com/ListDataService
	// ?kind=Groups
	// &filterField=UniqueID"
	// "&filterValue=" + AllineWatkins_1332886062783

	private static String getListUrl = "https://jsonpfy.unoidme.appspot.com/ListDataService";

	public static String list(final String uniqueID) {

		String parameters = "kind=Groups&filterField=UniqueID"
				+ "&filterValue=" + uniqueID;

		final String jsonString = URLUtilities.fetchURLPost(getListUrl,
				parameters + EncryptText.getAuthParameter());

		return jsonString;
	}

}
