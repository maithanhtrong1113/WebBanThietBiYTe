package webbanthietbiyte.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webbanthietbiyte.dto.ThietBiDTO;
import webbanthietbiyte.entity.NhomThietBi;
import webbanthietbiyte.entity.ThietBi;
import webbanthietbiyte.entity.ThuongHieu;
import webbanthietbiyte.repository.NhomThietBiRepository;
import webbanthietbiyte.repository.ThietBiRepository;
import webbanthietbiyte.repository.ThuongHieuRepository;
import webbanthietbiyte.utils.HamDungChung;

@Component
public class ThietBiConverter {
	
	@Autowired
	ThietBiRepository thietBiRepository;
	
	@Autowired
	ThuongHieuRepository thuongHieuRepository;
	
	@Autowired
	NhomThietBiRepository nhomThietBiRepository;

	public ThietBiDTO toThietBiDTO(ThietBi thietBi) {

		ThietBiDTO thietBiDTO = new ThietBiDTO();
		thietBiDTO.setId(thietBi.getId());
		thietBiDTO.setSlug(thietBi.getSlug());
		thietBiDTO.setTenThietBi(thietBi.getTenThietBi());
		thietBiDTO.setTenNhomThietBi(thietBi.getNhomThietBi().getTenNhomThietBi());
		thietBiDTO.setTenThuongHieu(thietBi.getThuongHieu().getTenThuongHieu());
		thietBiDTO.setGia(thietBi.getGia());
		thietBiDTO.setKhuyenMai(thietBi.getKhuyenMai());
		thietBiDTO.setThoiGianBaoHanh(thietBi.getThoiGianBaoHanh());
		thietBiDTO.setNoiBat(thietBi.isNoiBat());
		thietBiDTO.setMoTa(thietBi.getMoTa());
		thietBiDTO.setMoTaThietBi(thietBi.getMoTaThietBi());
		return thietBiDTO;
	}

	public ThietBi toThietBi(ThietBiDTO thietBiDTO) {

		if (thietBiDTO == null)
			return null;

		Integer id = thietBiDTO.getId();

		ThietBi thietBi = new ThietBi();

		if (id != 0) {
			thietBi = thietBiRepository.findById(id).get();
		} else {
			thietBi.setId(0);
		}
		thietBi.setSlug(thietBiDTO.getSlug());
		thietBi.setTenThietBi(thietBiDTO.getTenThietBi());
		thietBi.setSlug(HamDungChung.toSlug(thietBiDTO.getTenThietBi()));
		thietBi.setGia(thietBiDTO.getGia());
		thietBi.setThoiGianBaoHanh(thietBiDTO.getThoiGianBaoHanh());
		thietBi.setNoiBat(thietBiDTO.isNoiBat());
		thietBi.setKhuyenMai(thietBiDTO.getKhuyenMai());
		thietBi.setMoTa(thietBiDTO.getMoTa());
		thietBi.setMoTaThietBi(thietBiDTO.getMoTaThietBi());

		ThuongHieu thuongHieu = thuongHieuRepository.findByTenThuongHieu(thietBiDTO.getTenThuongHieu());
		thietBi.setThuongHieu(thuongHieu);

		NhomThietBi nhomThietBi = nhomThietBiRepository.findByTenNhomThietBi(thietBiDTO.getTenNhomThietBi());
		thietBi.setNhomThietBi(nhomThietBi);

		return thietBi;
	}
}
