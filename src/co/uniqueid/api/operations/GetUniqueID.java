package co.uniqueid.api.operations;


public class GetUniqueID {

	// http://jsonpfy.unoidme.appspot.com/ListDataService
	// ?kind=Entity
	// &filterField=email&filterValue=alline.oliveira@gmail.com

	private static String getUniqueIDUrl = "http://jsonpfy.unoidme.appspot.com/ListDataService";

	public static String getByField(final String fieldName,
			final String fieldValue) {

		String parameters = "kind=UniqueID&filterField=" + fieldName
				+ "&filterValue=" + fieldValue;

		final String jsonString = URLUtilities.fetchURLPost(getUniqueIDUrl,
				parameters);

		return jsonString;
	}
}
