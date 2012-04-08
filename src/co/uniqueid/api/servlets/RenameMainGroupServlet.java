package co.uniqueid.api.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.uniqueid.api.operations.RenameMainGroup;
import co.uniqueid.api.utilities.CallbackUtilities;
import co.uniqueid.api.utilities.URLUtilities;

@SuppressWarnings("serial")
public class RenameMainGroupServlet extends HttpServlet {

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
		String groupName = URLUtilities.decode(request
				.getParameter("MainGroupName"));

		RenameMainGroup.save(uniqueID, groupName);

		String answer = CallbackUtilities.getCallback(
				request.getParameter("callback"), "OK");

		return answer;
	}

}
