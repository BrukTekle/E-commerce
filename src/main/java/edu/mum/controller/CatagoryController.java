package edu.mum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.domain.Catagory;
import edu.mum.domain.Product;
import edu.mum.service.CatagoryService;

@Controller
public class CatagoryController {

	CatagoryService CatagoryService;

	@RequestMapping(value = "/catagoryList", method = RequestMethod.GET)
	public String listCatagory(Model model) {

		List<Catagory> list = CatagoryService.findAllCatagories();
		model.addAttribute("catagory", list);

		return "catagory";

	}
	
	@RequestMapping(value = "/addCatagory", method = RequestMethod.POST)
	public @ResponseBody Catagory addCatagory(@Valid @RequestBody Catagory catagory) {
		System.out.println(catagory.getDescription()+"==================================");
		CatagoryService.save(catagory);;
		return catagory;
	}

}
