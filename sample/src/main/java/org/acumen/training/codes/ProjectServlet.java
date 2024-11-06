package org.acumen.training.codes;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

import org.acumen.training.codes.dao.ProjectDao;
import org.acumen.training.codes.model.Project;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ProjectServlet", urlPatterns = "/project/add")
public class ProjectServlet extends HttpServlet{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String projectid= req.getParameter("id").trim();
		String projectname= req.getParameter("projectname").trim();
		String projectdate= req.getParameter("projectdate").trim();
		Short projid;
		LocalDate projDate;
		try {
			projid = Short.parseShort(projectid);
			projDate = LocalDate.parse(projectdate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			ProjectDao dao = new ProjectDao("hrms_pu");
			Project project = new Project();

			project.setId(projid);
			project.setProjname(projectname);
			project.setProjdate(projDate);
			dao.insert(project);
			
			List<Project> projects= dao.selectAllProject();
			req.setAttribute("projects", projects);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/project_result.html");
		dispatcher.forward(req, resp);
		
		
	}

}
