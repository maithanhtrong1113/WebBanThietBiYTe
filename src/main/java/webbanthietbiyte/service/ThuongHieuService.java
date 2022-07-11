package webbanthietbiyte.service;

import java.util.List;

import webbanthietbiyte.dto.ThuongHieuDTO;

public interface ThuongHieuService {
	List<ThuongHieuDTO> getThuongHieus();

	List<ThuongHieuDTO> getThuongHieusTheoTenThuongHieu(String tenThuongHieu);

	ThuongHieuDTO getThuongHieuTheoId(int id);

	ThuongHieuDTO capNhatThuongHieu(Integer id, String tenThuongHieu);

	boolean xoaThuongHieuTheoId(int id);

	ThuongHieuDTO themThuongHieu(String tenThuongHieu);
}
