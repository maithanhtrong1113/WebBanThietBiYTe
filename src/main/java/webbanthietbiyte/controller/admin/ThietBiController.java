package webbanthietbiyte.controller.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webbanthietbiyte.dto.KeyValueDTO;
import webbanthietbiyte.dto.ThietBiDTO;
import webbanthietbiyte.service.ThietBiService;

@Controller
@RequestMapping(value = "/admin/thietbi")
public class ThietBiController {
	@Autowired
	private ThietBiService thietBiService;

	@GetMapping("/")
	public String trangChu(Model model,
			@RequestParam(name = "tenThietBi", required = false, defaultValue = "") String tenThietBi,
			@RequestParam(name = "nhomThietBi", required = false, defaultValue = "") String nhomThietBi,
			@RequestParam(name = "thuongHieu", required = false, defaultValue = "") String thuongHieu) {

		List<ThietBiDTO> thietbis = thietBiService.getThietBiTheoTenThietBiVaNhomThietBiVaThuongHieu(tenThietBi,
				nhomThietBi, thuongHieu);

		Map<String, List<KeyValueDTO>> tieuChis = thietBiService.getTieuChiTimKiem();

		model.addAttribute("nhomThietBis", tieuChis.get("nhomThietBis"));
		model.addAttribute("thuongHieus", tieuChis.get("thuongHieus"));
		model.addAttribute("thietbis", thietbis);

		return "thietBiAdmin";
	}

	@GetMapping("/api")
	public String ketQuaTrangChu(Model model,
			@RequestParam(name = "tenThietBi", required = false, defaultValue = "") String tenThietBi,
			@RequestParam(name = "nhomThietBi", required = false, defaultValue = "") String tenNhomThietBi,
			@RequestParam(name = "thuongHieu", required = false, defaultValue = "") String tenThuongHieu) {

		List<ThietBiDTO> thietBis = thietBiService.getThietBiTheoTenThietBiVaNhomThietBiVaThuongHieu(tenThietBi,
				tenNhomThietBi, tenThuongHieu);

		model.addAttribute("thietBis", thietBis);
		return "ketQuaThietBiAdmin";
	}

	@DeleteMapping("/api/xoa/{id}")
	public ResponseEntity<?> xoaThietBi(@PathVariable("id") Integer id) {

		if (thietBiService.xoa(id))
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@GetMapping("/them-thietbi")
	public String themVali(Model model) {

		setLuaChons(model);
		model.addAttribute("thietBi", new ThietBiDTO());

		return "themThietBi";
	}

	private void setLuaChons(Model model) {

		Map<String, List<String>> luaChons = thietBiService.getTenOfThuongHieuVaNhomThietBi();

		model.addAttribute("tenThuongHieus", luaChons.get("tenThuongHieus"));
		model.addAttribute("tenNhomThietBis", luaChons.get("tenNhomThietBis"));

	}

	@PostMapping("/them-thietbi")
	public String themThietBi(Model model, @ModelAttribute("thietBi") ThietBiDTO thietBiDTO) {

		thietBiDTO.setId(0);
//		DTOValidator.validate(valiChungDTO, bindingResult);
//
//		if (bindingResult.hasErrors()) {
//
//			setLuaChons(model);
//			return "themVali";
//		}
		thietBiService.themThietBi(thietBiDTO);
		return "redirect:/admin/thietbi/";
	}

	@GetMapping("/sua-thietbi/{id}")
	public String suaThietBi(Model model, @PathVariable("id") Integer id) {

		setLuaChons(model);
		ThietBiDTO thietBiDTO = thietBiService.getThietBiById(id);

		model.addAttribute("thietBi", thietBiDTO);

		return "themThietBi";
	}

	@PostMapping("/sua-thietbi/{id}")
	public String suaThietBi(@PathVariable("id") Integer id, @ModelAttribute("thietBi") ThietBiDTO thietBiDTO) {

		thietBiService.capNhatThietBi(id, thietBiDTO);

		return "redirect:/admin/thietbi/";
	}
}
