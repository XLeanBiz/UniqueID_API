package co.uniqueid.api.operations;

public class DeleteContact {

	// http://jsonpfy.unoidme.appspot.com/SaveArrayDataService
	// ?kind=UniqueID&ID=goLiveSource
	// &Founded=LiveSourceWeb

	private static String saveArrayUrl = "http://jsonpfy.unoidme.appspot.com/SaveArrayDataService";

	public static void delete(final String uniqueID, final String contactID) {

		String parameters = "kind=UniqueID";

		parameters += "&ID=" + uniqueID;

		parameters += "&Contacts=" + contactID;

		URLUtilities.fetchURLPost(saveArrayUrl, parameters);
	}

}
