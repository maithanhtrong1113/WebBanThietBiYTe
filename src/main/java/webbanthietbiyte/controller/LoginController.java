package webbanthietbiyte.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import webbanthietbiyte.dto.NguoiDungDTO;
import webbanthietbiyte.repository.NguoidungRepository;
import webbanthietbiyte.service.NguoiDungService;

@Controller
public class LoginController {



	@Autowired
	private NguoiDungService nguoiDungService;
	
	@Autowired
	private NguoidungRepository nguoidungRepository;

	@GetMapping(value = "/login")
	public String login() {

		return "loginForm";
	}

	@GetMapping(value = "/dang-ki")
	public String dangKi(Model model) {

		Integer nguoiDungId = Integer.valueOf(RandomStringUtils.randomNumeric(6));

		NguoiDungDTO nguoiDung = new NguoiDungDTO(nguoiDungId);

		model.addAttribute("nguoiDung", nguoiDung);

		return "dangKi";
	}

	@PostMapping(value = "/dang-ki")
	public String dangKi(HttpServletRequest request, @ModelAttribute("nguoiDung") NguoiDungDTO nguoiDungDTO,
			BindingResult bindingResult) {

		String email = nguoiDungDTO.getEmail();
		
		if(nguoidungRepository.existsByEmail(email)) {
			bindingResult.rejectValue("email", null, "Email đã trùng");
		}
		

		// nếu có lỗi
		if (bindingResult.hasErrors()) {
			return "dangKi";
		}

		// không có lỗi
		String baseUrl = "http://" + request.getHeader("host");
		nguoiDungService.themNguoiDungDB(nguoiDungDTO, baseUrl);

		return "redirect:/login";
	}



}
