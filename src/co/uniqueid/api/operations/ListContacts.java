package co.uniqueid.api.operations;


public class ListContacts {

	// http://jsonpfy.unoidme.appspot.com/ListSubArrayService
	// ?kind=Entity
	// &ID=goLiveSource
	// &fieldSubArray=groupConnections

	private static String getListContactsUrl = "http://jsonpfy.unoidme.appspot.com/ListSubArrayService";

	public static String list(final String uniqueID) {

		String parameters = "kind=UniqueID&ID=" + uniqueID
				+ "&fieldSubArray=Contacts";

		final String jsonString = URLUtilities.fetchURLPost(getListContactsUrl,
				parameters);

		return jsonString;

	}

}
