package cokr.oneweeks.member_post.servlet.post;

import java.io.IOException;
// import java.security.Provider.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import cokr.oneweeks.member_post.dto.Criteria;
import cokr.oneweeks.member_post.dto.PageDto;
import cokr.oneweeks.member_post.service.PostService;
import cokr.oneweeks.member_post.service.PostServiceImpl;


@WebServlet("/post/list")
public class PostList extends HttpServlet{
	// private PostService service = new PostServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터 수집
		Criteria cri = new Criteria(req);
		System.out.println(cri);
		// req.setAttribute("posts", service.list(cri));
		// req.setAttribute("pageDto", new PageDto(cri, service.count(cri)));
		// req.getRequestDispatcher("/WEB-INF/jsp/post/list.jsp").forward(req, resp);
	}
}
