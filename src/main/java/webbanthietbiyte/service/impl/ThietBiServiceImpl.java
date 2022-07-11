package webbanthietbiyte.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import webbanthietbiyte.converter.ThietBiConverter;
import webbanthietbiyte.dto.KeyValueDTO;
import webbanthietbiyte.dto.ThietBiDTO;
import webbanthietbiyte.entity.ThietBi;
import webbanthietbiyte.repository.NhomThietBiRepository;
import webbanthietbiyte.repository.ThietBiRepository;
import webbanthietbiyte.repository.ThuongHieuRepository;
import webbanthietbiyte.service.ThietBiService;

@Service
@Transactional
public class ThietBiServiceImpl implements ThietBiService {

	@Autowired
	private ThietBiRepository thietBiRepository;
	@Autowired
	private NhomThietBiRepository nhomThietBiRepository;
	@Autowired
	private ThuongHieuRepository thuongHieuRepository;
	@Autowired
	private ThietBiConverter thietBiConverter;

	@Override
	public List<ThietBiDTO> getThietBiTheoTenThietBiVaNhomThietBiVaThuongHieu(String tenThietBi, String nhomThietBis,
			String thuongHieus) {
		return thietBiRepository
				.findByTenThietBiContainingAndThuongHieuTenThuongHieuContainingAndNhomThietBiTenNhomThietBiContaining(
						tenThietBi, thuongHieus, nhomThietBis)
				.stream().map(s -> thietBiConverter.toThietBiDTO(s)).collect(Collectors.toList());

	}

	@Override
	public Map<String, List<KeyValueDTO>> getTieuChiTimKiem() {

		Map<String, List<KeyValueDTO>> result = new HashMap<>();

		result.put("nhomThietBis", nhomThietBiRepository.findAll().stream()
				.map(s -> new KeyValueDTO(s.getCode(), s.getTenNhomThietBi())).collect(Collectors.toList()));

		result.put("thuongHieus", thuongHieuRepository.findAll().stream()
				.map(s -> new KeyValueDTO(s.getCode(), s.getTenThuongHieu())).collect(Collectors.toList()));

		return result;
	}

	@Override
	public boolean xoa(Integer id) {
		try {
			thietBiRepository.deleteById(id);

			return true;
		} catch (Exception e) {

			return false;
		}

	}

	@Override
	public boolean themThietBi(ThietBiDTO ThietBiDTO) {

		ThietBiDTO.setId(0);
		ThietBi result = thietBiRepository.save(thietBiConverter.toThietBi(ThietBiDTO));

		if (result != null)
			return true;

		return false;
	}

	@Override
	public Map<String, List<String>> getTenOfThuongHieuVaNhomThietBi() {
		Map<String, List<String>> result = new HashMap<>();
		List<String> tenThuongHieus = thuongHieuRepository.findAll().stream().map(s -> s.getTenThuongHieu())
				.collect(Collectors.toList());
		result.put("tenThuongHieus", tenThuongHieus);

		List<String> tenNhomThietBis = nhomThietBiRepository.findAll().stream().map(s -> s.getTenNhomThietBi())
				.collect(Collectors.toList());
		result.put("tenNhomThietBis", tenNhomThietBis);
		return result;
	}

	@Override
	public ThietBiDTO getThietBiById(Integer id) {
		if (!thietBiRepository.existsById(id))
			return null;

		ThietBiDTO thietBiDTO = new ThietBiDTO();

		ThietBi thietBi = thietBiRepository.findById(id).get();

		thietBiDTO.setId(thietBi.getId());
		thietBiDTO.setTenThietBi(thietBi.getTenThietBi());
		thietBiDTO.setThoiGianBaoHanh(thietBi.getThoiGianBaoHanh());
		thietBiDTO.setTenThuongHieu(thietBi.getThuongHieu().getTenThuongHieu());
		thietBiDTO.setTenNhomThietBi(thietBi.getNhomThietBi().getTenNhomThietBi());
		thietBiDTO.setMoTa(thietBi.getMoTa());
		thietBiDTO.setGia(thietBi.getGia());
		thietBiDTO.setKhuyenMai(thietBi.getKhuyenMai());
		thietBiDTO.setMoTaThietBi(thietBi.getMoTaThietBi());
		return thietBiDTO;
	}

	@Override
	public boolean capNhatThietBi(Integer id, ThietBiDTO thietBiDTO) {

		thietBiDTO.setId(id);

		ThietBi result = thietBiRepository.save(thietBiConverter.toThietBi(thietBiDTO));

		if (result != null)
			return true;

		return false;

	}

	@Override
	public List<ThietBiDTO> getThietBisNoiBat(int limit) {
		return thietBiRepository.findAllByNoiBatTrue(PageRequest.of(0, limit)).stream()
				.map(s -> thietBiConverter.toThietBiDTO(s)).collect(Collectors.toList());
	}

	@Override
	public ThietBiDTO getChiTietThietBiDTO(String slug) {
		ThietBi thietBi = thietBiRepository.findBySlug(slug);
		return thietBiConverter.toThietBiDTO(thietBi);
	}

}
