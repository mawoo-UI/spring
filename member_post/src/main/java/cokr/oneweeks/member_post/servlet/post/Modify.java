package cokr.oneweeks.member_post.servlet.post;

import java.io.IOException;
// import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import cokr.oneweeks.member_post.dto.Criteria;
import cokr.oneweeks.member_post.service.PostService;
import cokr.oneweeks.member_post.service.PostServiceImpl;
import cokr.oneweeks.member_post.utils.Commons;
import cokr.oneweeks.member_post.vo.Member;
import cokr.oneweeks.member_post.vo.Post;
@WebServlet("/post/modify")
public class Modify extends HttpServlet {
	private PostService service = new PostServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pnoStr = req.getParameter("pno");
		Object memberObj = req.getSession().getAttribute("member");
		Criteria cri = new Criteria(req);
		String redirectUrl = "list?" + cri.getQs2();
		
		if(pnoStr == null || memberObj == null) {
			Commons.printMsg("비정상적인 접근입니다.", redirectUrl, resp);
			return;
		}
		Long pno = Long.valueOf(pnoStr);
		Member m = (Member) memberObj;
		if(!m.getId().equals(service.findBy(pno).getWriter())) {
			Commons.printMsg("본인이 작성한 글만 수정할 수 있습니다.", redirectUrl, resp);
			return;
		
		}
		req.setAttribute("cri", cri);
		req.setAttribute("post", service.findBy(pno));
		req.getRequestDispatcher("/WEB-INF/jsp/post/modify.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object membObject = req.getSession().getAttribute("member");
		Criteria cri = new Criteria(req);
		
		if(membObject == null) {
			Commons.printMsg("비정상적인 접근입니다.","list?"+cri.getQs2(), resp);
			return;
		}
		Member m = (Member) membObject;
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String pnoStr = req.getParameter("pno");
		Long pno = Long.valueOf(pnoStr);
		
		if(!m.getId().equals(service.findBy(pno).getWriter())) {
			Commons.printMsg("본인이 작성한 글만 수정할 수 있습니다.", "list?"+cri.getQs2(), resp);
			return;
		}
		service.modify(Post.builder().title(title).content(content).pno(pno).build());
		resp.sendRedirect("view?pno="+pno+"&"+cri.getQs2());
	}
	
}
	
		
