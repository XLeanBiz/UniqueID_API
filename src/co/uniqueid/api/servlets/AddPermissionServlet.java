package co.uniqueid.api.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.uniqueid.api.operations.AddPermission;
import co.uniqueid.api.utilities.CallbackUtilities;
import co.uniqueid.api.utilities.URLUtilities;

@SuppressWarnings("serial")
public class AddPermissionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		//response.getWriter().println(getData(request));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		response.getWriter().println(getData(request));
	}

	private String getData(HttpServletRequest request) {

		String uniqueID = URLUtilities.decode(request.getParameter("UniqueID"));
		String foundedID = URLUtilities.decode(request
				.getParameter("Permission"));

		AddPermission.save(uniqueID, foundedID);

		String answer = CallbackUtilities.getCallback(
				request.getParameter("callback"), "OK");

		return answer;
	}

}
