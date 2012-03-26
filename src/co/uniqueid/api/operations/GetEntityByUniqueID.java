package co.uniqueid.api.operations;


public class GetEntityByUniqueID {

	// http://jsonpfy.unoidme.appspot.com/GetDataService
	// ?kind=UniqueID
	// &ID=FB_alline.oliveira

	private static String getUnoUserUrl = "http://jsonpfy.unoidme.appspot.com/GetDataService";

	public static String get(final String unoUserID) {

		String parameters = "kind=UniqueID&ID=" + unoUserID;

		final String jsonString = URLUtilities.fetchURLPost(getUnoUserUrl,
				parameters);

		return jsonString;
	}
}
