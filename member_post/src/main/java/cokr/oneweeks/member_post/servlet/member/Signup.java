package cokr.oneweeks.member_post.servlet.member;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import cokr.oneweeks.member_post.service.MemberService;
import cokr.oneweeks.member_post.service.MemberServiceImpl;
import cokr.oneweeks.member_post.vo.Member;


@WebServlet("/signup")
public class Signup extends HttpServlet{
// 	private MemberService service = new MemberServiceImpl();

// 	@Override
// 	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 		req.getRequestDispatcher("/WEB-INF/jsp/member/signup.jsp").forward(req, resp);
// 	}

// 	@Override
// 	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 		req.setCharacterEncoding("utf-8");
// 		String id = req.getParameter("id");
// 		String pw = req.getParameter("pw");
// 		String name = req.getParameter("name");
// 		String email = req.getParameter("email");
// 		String roadAddr = req.getParameter("roadAddr");
// 		String detailAddr = req.getParameter("detailAddr");
		
// //		Member member = new Member();
// //		member.setId(id);
// //		기본값으로 되어있으면 한글깨짐 //한글 3byte ,영문 1byte(?)
// //		iso 8859-1 (기본값)
// 		Member member = Member.builder()
// 				.id(id)
// 				.pw(pw)
// 				.name(name)
// 				.email(email)
// 				.roadAddr(roadAddr)
// 				.detailAddr(detailAddr)
// 				.build();
		
// 		System.out.println(member);
		
// 		service.register(member);
		
// 		resp.sendRedirect("signup");
// 	}
	
}
