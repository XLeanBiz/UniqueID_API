package co.uniqueid.api.operations;

public class AddContact {

	// http://jsonpfy.unoidme.appspot.com/AddArrayDataService
	// ?kind=UniqueID&ID=goLiveSource
	// &Founded=LiveSourceWeb

	private static String saveArrayUrl = "http://jsonpfy.unoidme.appspot.com/AddArrayDataService";

	public static void save(final String uniqueID, final String contactUniqueID) {

		String parameters = "kind=UniqueID";

		parameters += "&ID=" + uniqueID;

		parameters += "&Contacts=" + contactUniqueID;

		URLUtilities.fetchURLPost(saveArrayUrl, parameters);
	}

}
