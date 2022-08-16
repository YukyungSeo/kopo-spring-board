package kr.ac.kopo.member.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

@SessionAttributes("loginVO")
@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet(Model model) {

		MemberVO memberVO = new MemberVO();
		model.addAttribute("memberVO", memberVO);

		// WEB-INF/jsp/member/login.jsp
		return "member/login";
	}

	@PostMapping("/login")
	public String loginPost(@Valid @ModelAttribute("memberVO") MemberVO member, BindingResult result, Model model,
			HttpSession session) {
		/*
		 * 1. MemberVO 의 member가 null값이 아닌 valid한 값이 들어왔는가 확인 -> BindingResult 를 가지고 확인
		 * 2.1 null 값을 가진 error 값이 들어온 경우 forward member/login.jsp 2.2 정상값이 들어온 경우,
		 * id/password가 유효한지 select 문으로 체크 2.2.1 유효한 id/password - db에 존재 welcome!!!
		 * 홍길동님 반가워요. session에 해당 유효한 memberVO 등록 2.2.2 유효하지 않을 때 - db에 존재 x - 사용자에게
		 * 메세지, id/password 유효하지 않으니, 다시 입력하세요. forward member/login.jsp 3. interceptor
		 */
		System.out.println(member);
		System.out.println(result);

		if (result.hasErrors()) {
			// null 값이 존재 -> 다시 입력
			// WEB-INF/jsp/member/login.jsp
			return "/member/login";
		} else {

			// null 값이 존재하지 않음 -> id/password가 유요한 사용자인지 확인
			MemberVO authMember = memberService.login(member);
			System.out.println("authMember : " + authMember);

			if (authMember == null) {
				// id/password 유효하지 않은 경우
				// WEB-INF/jsp/member/login.jsp
				model.addAttribute("loginmsg", "아이디와 패스워드가 유효하지 않습니다.");
				return "member/login";
				
			} else {
//				session.setAttribute("loginVO", authMember);
				model.addAttribute("loginVO", authMember);
				return "redirect:/board";
				
			}
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, SessionStatus sessionStatus) {
//		session.invalidate();
		sessionStatus.setComplete();
		return "redirect:/";
	}

	@GetMapping("/register")
	public String registerGet(Model model) {
		
		MemberVO memberVO = new MemberVO();
		model.addAttribute("memberVO", memberVO);
		
		return "member/register";
	}
	
//	@PostMapping("/register")
//	public String registerPost(@Valid ) {
//		
//	}
}
