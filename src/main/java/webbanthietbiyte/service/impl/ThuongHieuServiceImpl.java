package webbanthietbiyte.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import webbanthietbiyte.dto.ThuongHieuDTO;
import webbanthietbiyte.entity.ThuongHieu;
import webbanthietbiyte.repository.ThuongHieuRepository;
import webbanthietbiyte.service.ThuongHieuService;
import webbanthietbiyte.utils.HamDungChung;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {

	@Autowired
	private ThuongHieuRepository  thuongHieuRepository;

	@Override
	public List<ThuongHieuDTO> getThuongHieus() {
		List<ThuongHieu> thuongHieus = thuongHieuRepository.findAll(PageRequest.of(0, 5)).getContent();

		return thuongHieus.stream().map(s -> new ThuongHieuDTO(s.getId(), s.getTenThuongHieu(), s.getCode()))
				.collect(Collectors.toList());
	}

	@Override
	public List<ThuongHieuDTO> getThuongHieusTheoTenThuongHieu(String tenThuongHieu) {
		// TODO Auto-generated method stub
		List<ThuongHieu> thuongHieus = thuongHieuRepository.findByTenThuongHieuContainingIgnoreCase(tenThuongHieu);

		return thuongHieus.stream().map(s -> new ThuongHieuDTO(s.getId(), s.getTenThuongHieu(), s.getCode()))
				.collect(Collectors.toList());
	}

	@Override
	public ThuongHieuDTO getThuongHieuTheoId(int id) {
		// TODO Auto-generated method stub

		ThuongHieuDTO ThuongHieuDTO = thuongHieuRepository.findById(id)
				.map(s -> new ThuongHieuDTO(s.getId(), s.getTenThuongHieu(), s.getCode())).orElse(null);

		return ThuongHieuDTO;

	}

	@Override
	public ThuongHieuDTO themThuongHieu(String tenThuongHieu) {

		if (thuongHieuRepository.existsByTenThuongHieu(tenThuongHieu))
			return null;

		String code = HamDungChung.toSlug(tenThuongHieu);
		ThuongHieu thuongHieuResult = thuongHieuRepository.save(new ThuongHieu(tenThuongHieu, code));
		return new ThuongHieuDTO(thuongHieuResult.getId(), thuongHieuResult.getTenThuongHieu(),
				thuongHieuResult.getCode());

	}

	@Override
	public boolean xoaThuongHieuTheoId(int id) {
		// TODO Auto-generated method stub
		if (!thuongHieuRepository.existsById(id))
			return false;

		thuongHieuRepository.delete(thuongHieuRepository.findById(id).get());

		return true;

	}

	@Override
	public ThuongHieuDTO capNhatThuongHieu(Integer id, String tenThuongHieu) {
		if (thuongHieuRepository.existsByTenThuongHieuAndIdNot(tenThuongHieu, id)) {
			return null;
		}

		String code = HamDungChung.toSlug(tenThuongHieu);
		ThuongHieu thuongHieuResult = thuongHieuRepository.save(new ThuongHieu(id, tenThuongHieu, code));
		return new ThuongHieuDTO(thuongHieuResult.getId(), thuongHieuResult.getTenThuongHieu(),
				thuongHieuResult.getCode());
	}

	

}
