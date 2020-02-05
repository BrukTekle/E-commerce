package edu.mum.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}
