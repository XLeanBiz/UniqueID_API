package co.uniqueid.api.operations;

public class AddGroup {

	// http://jsonpfy.unoidme.appspot.com/SaveDataService
	// ?kind=Groups
	// &UniqueID=goLiveSource
	// &Group=LiveSourceWeb

	private static String saveUrl = "http://jsonpfy.unoidme.appspot.com/SaveDataService";

	public static void save(final String uniqueID, final String groupName) {

		String parameters = "kind=Groups";

		parameters += "&ID=" + uniqueID + "_"
				+ URLUtilities.compactName(groupName);

		parameters += "&fieldsKind=String&fieldsName=UniqueID&fieldsValue="
				+ uniqueID;

		parameters += "&fieldsKind=String&fieldsName=Group&fieldsValue="
				+ groupName;

		URLUtilities.fetchURLPost(saveUrl, parameters);
	}

}
