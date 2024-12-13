package cokr.oneweeks.member_post.servlet.member;

import java.io.IOException;
import java.net.URLDecoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import cokr.oneweeks.member_post.service.MemberService;
import cokr.oneweeks.member_post.service.MemberServiceImpl;
import cokr.oneweeks.member_post.vo.Member;

	@WebServlet("/signin")
	public class Signin extends HttpServlet{
// 		private MemberService service = new MemberServiceImpl();

// 		@Override
// 		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 			req.getRequestDispatcher("/WEB-INF/jsp/member/signin.jsp").forward(req, resp);
// 		}

// 		@Override
// 		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 			req.setCharacterEncoding("utf-8");
// 			String id = req.getParameter("id");
// 			String pw = req.getParameter("pw");
// 			String remember = req.getParameter("remember-id");
			
			
// //			Member member = new Member();
// //			member.setId(id);
// //			기본값으로 되어있으면 한글깨짐 //한글 3byte ,영문 1byte(?)
// //			iso 8859-1 (기본값)
// 			Member member = Member.builder()
// 					.id(id)
// 					.pw(pw)
// 					.build();
			
// 			System.out.println(id);
// 			System.out.println(pw);
// 			System.out.println(remember);
			
			
			
// //			service.register(member);
// 			if (service.login(id, pw)) {
// 				//로그인 성공
// 				HttpSession session = req.getSession();
// 				session.setAttribute("member", service.findBy(id));
				
// 				//쿠키에 아이디 기억 여부 처리
// 				if(remember != null) {
// 					Cookie cookie = new Cookie("remember-id", id);
// 					System.out.println(cookie);
// 					cookie.setMaxAge(60 * 60 * 24 * 7);
// 					resp.addCookie(cookie);
// 				}else {
// 					Cookie[] cookie  = req.getCookies();
// 					for(Cookie c: cookie) {
// 						if (c.getName().equals("renenber-id")){
// 							c.setMaxAge(0);
// 							resp.addCookie(c);
// 							break;
// 						}
// 					}
// 				}
// 				//url파라미터 여부에 따른 리디렉션 페이지 지정
// 				String redirectURL = req.getContextPath()+"/index";
// 				String url = req.getParameter("url");
// 				if(url != null && !url.equals("")) {
// 					redirectURL = URLDecoder.decode(url, "utf-8");
// 				}
// 				resp.sendRedirect(redirectURL);
				
// 				//아이디 기억 안할 때 처리할 일
// 			} 
// 			else {
// 				resp.sendRedirect("login?msg=fail");
				
// 			}
			
// 		}
		
	}
	

