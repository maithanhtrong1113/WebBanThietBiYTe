package webbanthietbiyte.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webbanthietbiyte.dto.CartDTO;
import webbanthietbiyte.service.GioHangService;
import webbanthietbiyte.service.NguoiDungService;

@Controller
@RequestMapping(value = "/gio-hang")
public class GioHangController {
	
	@Autowired
	private GioHangService gioHangService;
	@Autowired
	private NguoiDungService nguoiDungService;
	
	@GetMapping(value = "")
	public String xemGioHang(Model model, HttpSession session) {

		CartDTO cartDTO = (CartDTO) session.getAttribute("gioHang");

		if (cartDTO != null) {
			model.addAttribute("cart", gioHangService.convertCartDTOToCartThietBiDTO(cartDTO));
		}

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		model.addAttribute("nguoiDung", nguoiDungService.getTheoEmail(username));

		return "gioHang";
	}
	@GetMapping(value = "/them-gio-hang")
	public String themGioHang(HttpSession session, @RequestParam(name = "slug") String slug) {

		CartDTO cartDTO;

		if (session.getAttribute("gioHang") == null) {
			cartDTO = new CartDTO();
		} else {
			cartDTO = (CartDTO) session.getAttribute("gioHang");
		}

		cartDTO.them(slug);
		session.setAttribute("gioHang", cartDTO);

		return "redirect:/gio-hang";
	}

	@GetMapping(value = "/giam-gio-hang")
	public String giamSachGioHang(HttpSession session, @RequestParam(name = "slug") String slug) {

		CartDTO cartDTO = (CartDTO) session.getAttribute("gioHang");

		if (cartDTO != null) {

			cartDTO.giam(slug);

			if (cartDTO.getCartItemDTOs().isEmpty()) {
				session.removeAttribute("gioHang");

			} else {
				session.setAttribute("gioHang", cartDTO);
			}
		}

		return "redirect:/gio-hang";
	}

	@GetMapping(value = "/xoa-gio-hang/{maThietBi}")
	public String xoaGioHang(HttpServletRequest request, HttpSession session,@RequestParam(name = "slug") String slug) {

		CartDTO cartDTO = (CartDTO) session.getAttribute("gioHang");

		if (cartDTO != null) {

			cartDTO.xoa(slug);

			if (cartDTO.getCartItemDTOs().isEmpty()) {
				session.removeAttribute("gioHang");
			} else {
				session.setAttribute("gioHang", cartDTO);
			}
		}

		return "redirect:/gio-hang";
	}

	@GetMapping(value = "/dat-hang")
	public String datHang(HttpSession session) {

		CartDTO cartDTO = (CartDTO) session.getAttribute("gioHang");

		if (gioHangService.datHang(cartDTO)) {

			session.removeAttribute("gioHang");
			return "ketQuaDatHang";
		}

		return "redirect:/gio-hang";

	}
}
