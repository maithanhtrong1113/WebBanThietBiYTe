package webbanthietbiyte.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import webbanthietbiyte.dto.NhomThietBiDTO;
import webbanthietbiyte.entity.NhomThietBi;
import webbanthietbiyte.repository.NhomThietBiRepository;
import webbanthietbiyte.service.NhomThietBiService;
import webbanthietbiyte.utils.HamDungChung;

@Service
public class NhomThietBiServiceImpl implements NhomThietBiService {

	@Autowired
	private NhomThietBiRepository nhomThietBiRepository;

	@Override
	public List<NhomThietBiDTO> getNhomThietBis() {
		List<NhomThietBi> nhomThietBis = nhomThietBiRepository.findAll(PageRequest.of(0, 10)).getContent();

		return nhomThietBis.stream().map(s -> new NhomThietBiDTO(s.getId(), s.getTenNhomThietBi(), s.getCode()))
				.collect(Collectors.toList());
	}

	@Override
	public List<NhomThietBiDTO> getNhomThietBisTheoTenNhomThietBi(String tenNhomThietBi) {
		// TODO Auto-generated method stub
		List<NhomThietBi> nhomThietBis = nhomThietBiRepository.findByTenNhomThietBiContainingIgnoreCase(tenNhomThietBi);

		return nhomThietBis.stream().map(s -> new NhomThietBiDTO(s.getId(), s.getTenNhomThietBi(), s.getCode()))
				.collect(Collectors.toList());
	}

	@Override
	public NhomThietBiDTO getNhomThietBiTheoId(int id) {
		// TODO Auto-generated method stub

		NhomThietBiDTO nhomThietBiDTO = nhomThietBiRepository.findById(id)
				.map(s -> new NhomThietBiDTO(s.getId(), s.getTenNhomThietBi(), s.getCode())).orElse(null);

		return nhomThietBiDTO;

	}

	@Override
	public NhomThietBiDTO themNhomThietBi(String tenNhomThietBi) {

		if (nhomThietBiRepository.existsByTenNhomThietBi(tenNhomThietBi))
			return null;

		String code = HamDungChung.toSlug(tenNhomThietBi);
		NhomThietBi nhomThietBiResult = nhomThietBiRepository.save(new NhomThietBi(tenNhomThietBi, code));
		return new NhomThietBiDTO(nhomThietBiResult.getId(), nhomThietBiResult.getTenNhomThietBi(),
				nhomThietBiResult.getCode());

	}

	@Override
	public boolean xoaNhomThietBiTheoId(int id) {
		// TODO Auto-generated method stub
		if (!nhomThietBiRepository.existsById(id))
			return false;

		nhomThietBiRepository.delete(nhomThietBiRepository.findById(id).get());

		return true;

	}

	@Override
	public NhomThietBiDTO capNhatNhomThietBi(Integer id, String tenNhomThietBi) {
		if (nhomThietBiRepository.existsByTenNhomThietBiAndIdNot(tenNhomThietBi, id)) {
			return null;
		}

		String code = HamDungChung.toSlug(tenNhomThietBi);
		NhomThietBi nhomThietBiResult = nhomThietBiRepository.save(new NhomThietBi(id, tenNhomThietBi, code));
		return new NhomThietBiDTO(nhomThietBiResult.getId(), nhomThietBiResult.getTenNhomThietBi(),
				nhomThietBiResult.getCode());
	}

	@Override
	public List<NhomThietBiDTO> getNhomThietBisTrangChu() {
		List<NhomThietBi> nhomThietBiss = nhomThietBiRepository.findAll(PageRequest.of(0, 10)).getContent();

		return nhomThietBiss.stream().map(s -> new NhomThietBiDTO(s.getId(), s.getTenNhomThietBi(), s.getCode()))
				.collect(Collectors.toList());
	}

}
