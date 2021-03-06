package co.uniqueid.api.operations;

import co.uniqueid.api.utilities.EncryptText;
import co.uniqueid.api.utilities.URLUtilities;

public class RenameMainGroup {

	private static String saveUnoUserUrl = "https://jsonpfy.unoidme.appspot.com/SaveDataService";

	public static void save(final String uniqueID, final String groupName) {

		String parameters = "kind=UniqueID";

		parameters += "&ID=" + uniqueID;

		parameters += "&fieldsKind=String&fieldsName=MainGroupName"
				+ "&fieldsValue=" + URLUtilities.encode(groupName);

		URLUtilities.fetchURLPost(saveUnoUserUrl,
				parameters + EncryptText.getAuthParameter());

	}
}
