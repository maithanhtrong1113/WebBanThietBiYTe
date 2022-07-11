package webbanthietbiyte.service;

import java.util.List;
import java.util.Map;

import webbanthietbiyte.dto.KeyValueDTO;
import webbanthietbiyte.dto.ThietBiDTO;


public interface ThietBiService {
	List<ThietBiDTO> getThietBiTheoTenThietBiVaNhomThietBiVaThuongHieu(String tenThietBi, String nhomThietBi,
			String thuongHieu);
	Map<String, List<KeyValueDTO>> getTieuChiTimKiem();
	boolean xoa(Integer id);
	boolean themThietBi(ThietBiDTO thietBiDTO);
	Map<String, List<String>> getTenOfThuongHieuVaNhomThietBi();
	ThietBiDTO getThietBiById(Integer id);
	boolean capNhatThietBi(Integer id, ThietBiDTO thietBiDTO);
	List<ThietBiDTO> getThietBisNoiBat(int limit);
	ThietBiDTO getChiTietThietBiDTO(String slug);

}
