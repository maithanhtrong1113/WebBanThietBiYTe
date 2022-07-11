package webbanthietbiyte.service;

import java.util.List;

import webbanthietbiyte.dto.NhomThietBiDTO;

public interface NhomThietBiService {
	List<NhomThietBiDTO> getNhomThietBis();
	

	List<NhomThietBiDTO> getNhomThietBisTheoTenNhomThietBi(String tenNhomThietBi);

	NhomThietBiDTO getNhomThietBiTheoId(int id);

	NhomThietBiDTO capNhatNhomThietBi(Integer id, String tenNhomThietBi);

	boolean xoaNhomThietBiTheoId(int id);

	NhomThietBiDTO themNhomThietBi(String tenNhomThietBi);
	List<NhomThietBiDTO> getNhomThietBisTrangChu();
}
