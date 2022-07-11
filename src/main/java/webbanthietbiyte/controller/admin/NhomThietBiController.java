package webbanthietbiyte.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import webbanthietbiyte.service.NhomThietBiService;
import webbanthietbiyte.dto.NhomThietBiDTO;

@Controller
@RequestMapping(value = "/admin/nhom-thietbi")
public class NhomThietBiController {

	@Autowired
	private NhomThietBiService nhomThietBiService;

	@GetMapping(value = "/trang-chu")
	public String trangChu(Model model) {
		model.addAttribute("nhomThietBis", nhomThietBiService.getNhomThietBis());
		return "trangChuNhomThietBiAdmin";
	}

	@GetMapping(value = "/api")
	public ResponseEntity<List<NhomThietBiDTO>> getListTheoTen(@RequestParam("tenNhomThietBi") String tenNhomThietBi,
			Model model) {

		List<NhomThietBiDTO> nhomThietBiDTOs = nhomThietBiService.getNhomThietBisTheoTenNhomThietBi(tenNhomThietBi);

		return ResponseEntity.ok(nhomThietBiDTOs);

	}

	@GetMapping(value = "/api/{nhomThietBiId}")
	public @ResponseBody ResponseEntity<NhomThietBiDTO> getTheoId(@PathVariable("nhomThietBiId") int id) {

		NhomThietBiDTO nhomThietBiDTO = nhomThietBiService.getNhomThietBiTheoId(id);

		if (nhomThietBiDTO == null)
			return new ResponseEntity<NhomThietBiDTO>(HttpStatus.NOT_FOUND);

		return ResponseEntity.ok(nhomThietBiDTO);

	}

	@PostMapping(value = "/api")
	public @ResponseBody ResponseEntity<NhomThietBiDTO> them(@RequestBody NhomThietBiDTO nhomThietBiDTO1) {

		NhomThietBiDTO nhomThietBiDTO = nhomThietBiService.themNhomThietBi(nhomThietBiDTO1.getTenNhomThietBi());
		if (nhomThietBiDTO == null)
			return new ResponseEntity<NhomThietBiDTO>(HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(nhomThietBiDTO);

	}

	@DeleteMapping(value = "/api/{nhomThietBiId}")
	public @ResponseBody ResponseEntity<?> xoa(@PathVariable("nhomThietBiId") int nhomThietBiId) {

		if (nhomThietBiService.xoaNhomThietBiTheoId(nhomThietBiId))
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	// cập nhật
	@PutMapping(value = "/api")
	public @ResponseBody ResponseEntity<NhomThietBiDTO> capNhat(@RequestBody NhomThietBiDTO nhomThietBiDTO1) {

		NhomThietBiDTO nhomThietBiDTO = nhomThietBiService.capNhatNhomThietBi(nhomThietBiDTO1.getId(),
				nhomThietBiDTO1.getTenNhomThietBi());
		if (nhomThietBiDTO == null)
			return new ResponseEntity<NhomThietBiDTO>(HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(nhomThietBiDTO);

	}

}
