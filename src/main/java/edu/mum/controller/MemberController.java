package edu.mum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Members;
import edu.mum.service.MemberService;
import edu.mum.service.UserCredentialsService;

@Controller
@RequestMapping({"/members"})
public class MemberController {
	
	@Autowired
	private MemberService  memberService;

	@Autowired
	private UserCredentialsService  credentialsService;

	@RequestMapping(value="", method = RequestMethod.GET)
	public String listMembers(Model model) {
		model.addAttribute("members", memberService.findAll());
		return "members";
	}
	
  	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String getMemberById(@PathVariable("id") Long id,Model model) {
		Members member = memberService.findOne(id);
		model.addAttribute("member", member);

 		return "member";
	}

//  	@RequestMapping(value="/number/{id}", method = RequestMethod.GET)
//	public String getMemberByMemberNumber(@PathVariable("id") Integer id,Model model) {
//		Members member = memberService.findByMemberNumber(id);
//		model.addAttribute("member", member);
//
// 		return "member";
//	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)

	public String getAddNewMemberForm(@ModelAttribute("newMember") Members newMember) {
	   return "signup";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewMemberForm(@Valid @ModelAttribute("newMember") Members memberToBeAdded, BindingResult result) {
		System.out.println("saving user to the database");
		if(result.hasErrors()) {
			return "signup";
		}

		 //  Error caught by ControllerAdvice IF no authorization...
		memberService.saveFull(memberToBeAdded);
			
 	   	return "products";
 
	}
	
 
}
