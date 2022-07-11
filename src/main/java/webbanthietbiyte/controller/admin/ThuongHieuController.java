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

import webbanthietbiyte.dto.NhomThietBiDTO;
import webbanthietbiyte.dto.ThuongHieuDTO;
import webbanthietbiyte.service.ThuongHieuService;


@Controller
@RequestMapping(value = "/admin/thuong-hieu")
public class ThuongHieuController {

	@Autowired
	private ThuongHieuService thuongHieuService;
	
	
	@GetMapping(value = "/trang-chu")
	public String trangChu(Model model) {
		model.addAttribute("thuongHieus", thuongHieuService.getThuongHieus());
		return "trangChuThuongHieuAdmin";
	}
	
	@GetMapping(value = "/api")
	public ResponseEntity<List<ThuongHieuDTO>> getListTheoTen(@RequestParam("tenThuongHieu") String tenThuongHieu,
			Model model) {

		List<ThuongHieuDTO> thuongHieuDTOs = thuongHieuService.getThuongHieusTheoTenThuongHieu(tenThuongHieu);

		return ResponseEntity.ok(thuongHieuDTOs);

	}

	@GetMapping(value = "/api/{thuongHieuId}")
	public @ResponseBody ResponseEntity<ThuongHieuDTO> getTheoId(@PathVariable("thuongHieuId") int id) {

		ThuongHieuDTO thuongHieuDTO = thuongHieuService.getThuongHieuTheoId(id);

		if (thuongHieuDTO == null)
			return new ResponseEntity<ThuongHieuDTO>(HttpStatus.NOT_FOUND);

		return ResponseEntity.ok(thuongHieuDTO);

	}

	@PostMapping(value = "/api")
	public @ResponseBody ResponseEntity<ThuongHieuDTO> them(@RequestBody ThuongHieuDTO thuongHieuDTO1) {

		ThuongHieuDTO thuongHieuDTO = thuongHieuService.themThuongHieu(thuongHieuDTO1.getTenThuongHieu());
		if (thuongHieuDTO == null)
			return new ResponseEntity<ThuongHieuDTO>(HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(thuongHieuDTO);

	}

	@DeleteMapping(value = "/api/{thuongHieuId}")
	public @ResponseBody ResponseEntity<?> xoa(@PathVariable("thuongHieuId") int thuongHieuId) {

		if (thuongHieuService.xoaThuongHieuTheoId(thuongHieuId))
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	// cập nhật
	@PutMapping(value = "/api")
	public @ResponseBody ResponseEntity<ThuongHieuDTO> capNhat(@RequestBody ThuongHieuDTO thuongHieuDTO1) {

		ThuongHieuDTO nhomThietBiDTO = thuongHieuService.capNhatThuongHieu(thuongHieuDTO1.getId(),
				thuongHieuDTO1.getTenThuongHieu());
		if (nhomThietBiDTO == null)
			return new ResponseEntity<ThuongHieuDTO>(HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(nhomThietBiDTO);

	}
	
}
