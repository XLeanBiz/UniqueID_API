package co.uniqueid.api.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.uniqueid.api.operations.DeleteContact;
import co.uniqueid.api.operations.URLUtilities;

@SuppressWarnings("serial")
public class DeleteContactServlet extends HttpServlet {
	
	// http://localhost:8888/DeleteContactService
	// ?UniqueID=goLiveSource
	// &ContactID=JuneClarke_1332960875108


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		response.getWriter().println(getData(request));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		response.getWriter().println(getData(request));
	}

	private String getData(HttpServletRequest request) {

		String uniqueID = URLUtilities.decode(request.getParameter("UniqueID"));
		String contactID = URLUtilities.decode(request
				.getParameter("ContactID"));

		DeleteContact.delete(uniqueID, contactID);

		String answer = CallbackUtilities.getCallback(
				request.getParameter("callback"), "OK");

		return answer;
	}

}
