package co.uniqueid.api.operations.facebook;

import org.json.JSONObject;

import co.uniqueid.api.operations.JSONUtilities;
import co.uniqueid.api.operations.URLUtilities;

public class SaveFacebookInfo {

	private static String saveUnoUserUrl = "http://jsonpfy.unoidme.appspot.com/SaveDataService";

	public static void save(JSONObject unoUserJson) {

		String unoUserID = JSONUtilities.getString(unoUserJson, "ID");
		String parameters = "kind=FacebookInfo&ID=" + unoUserID;

		parameters += URLUtilities.addSaveParameter(unoUserJson, "facebook_id");
		
		parameters += URLUtilities.addSaveParameter(unoUserJson, "username");

		parameters += URLUtilities.addSaveParameter(unoUserJson, "facebook_email");

		parameters += URLUtilities.addSaveParameter(unoUserJson, "first_name");

		parameters += URLUtilities.addSaveParameter(unoUserJson, "last_name");

		parameters += URLUtilities.addSaveParameter(unoUserJson, "gender");

		parameters += URLUtilities.addSaveParameter(unoUserJson, "birthday");

		parameters += URLUtilities.addSaveParameter(unoUserJson, "relationship_status");

		//parameters += addParameter(unoUserJson, "city");

		URLUtilities.fetchURLPost(saveUnoUserUrl, parameters);
	}


}
