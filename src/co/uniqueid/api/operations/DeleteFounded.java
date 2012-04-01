package co.uniqueid.api.operations;

public class DeleteFounded {

	// http://jsonpfy.unoidme.appspot.com/DeleteArrayDataService
	// ?kind=UniqueID&ID=goLiveSource
	// &Founded=LiveSourceWeb

	private static String saveArrayUrl = "http://jsonpfy.unoidme.appspot.com/DeleteArrayDataService";

	public static void delete(final String uniqueID, final String foundedID) {

		String parameters = "kind=UniqueID";

		parameters += "&ID=" + uniqueID;

		parameters += "&Founded=" + foundedID;

		URLUtilities.fetchURLPost(saveArrayUrl, parameters);

		// Save inverted positions
	/*	parameters = "kind=UniqueID";

		parameters += "&ID=" + foundedID;

		parameters += "&Founded=" + uniqueID;

		URLUtilities.fetchURLPost(saveArrayUrl, parameters);*/
	}

}
