package webbanthietbiyte.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class TrangChuAdmin {

	@GetMapping(value = "/trang-chu")
	public String index(Model model) {

		return "trangChuAdmin";
	}

}
