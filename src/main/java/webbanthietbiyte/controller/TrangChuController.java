package webbanthietbiyte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import webbanthietbiyte.service.NhomThietBiService;
import webbanthietbiyte.service.ThietBiService;

@Controller
public class TrangChuController {
	
	@Autowired
	NhomThietBiService nhomThietBiService;
	@Autowired
	ThietBiService thietBiService;
	private static final int SIZE = 4;
	@GetMapping(value = "/")
	public String trangChu(Model model) {
		model.addAttribute("nhomThietBiss", nhomThietBiService.getNhomThietBisTrangChu());
		model.addAttribute("thietBisNoiBat", thietBiService.getThietBisNoiBat(SIZE*10));

		return "trangChu";
	}

}
