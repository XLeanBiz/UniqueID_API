package co.uniqueid.api.operations;

public class ListGroups {

	// http://jsonpfy.unoidme.appspot.com/ListDataService
	// ?kind=Groups
	// &filterField=UniqueID"
	// "&filterValue=" + AllineWatkins_1332886062783

	private static String getListUrl = "http://jsonpfy.unoidme.appspot.com/ListDataService";

	public static String list(final String uniqueID) {

		String parameters = "kind=Groups&filterField=UniqueID"
				+ "&filterValue=" + uniqueID;

		final String jsonString = URLUtilities.fetchURLPost(getListUrl,
				parameters);

		return jsonString;
	}

}
