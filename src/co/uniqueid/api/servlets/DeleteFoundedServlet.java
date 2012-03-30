package co.uniqueid.api.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.uniqueid.api.operations.DeleteFounded;
import co.uniqueid.api.operations.URLUtilities;

@SuppressWarnings("serial")
public class DeleteFoundedServlet extends HttpServlet {

	// http://localhost:8888/DeleteFoundedService
	// ?UniqueID=
	// &Founded=

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		// response.getWriter().println(getData(request));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		response.getWriter().println(getData(request));
	}

	private String getData(HttpServletRequest request) {

		String uniqueID = URLUtilities.decode(request.getParameter("UniqueID"));
		String foundedID = URLUtilities.decode(request
				.getParameter("FoundedID"));

		DeleteFounded.delete(uniqueID, foundedID);

		String answer = CallbackUtilities.getCallback(
				request.getParameter("callback"), "OK");

		return answer;
	}

}
