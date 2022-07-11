package webbanthietbiyte.service;

import java.util.List;
import java.util.Optional;

import webbanthietbiyte.dto.NguoiDungDTO;
import webbanthietbiyte.entity.NguoiDung;

public interface NguoiDungService {

	NguoiDungDTO save(NguoiDungDTO nguoiDungDTO);
	NguoiDungDTO save1(NguoiDungDTO nguoiDungDTO);
	boolean themNguoiDungDB(NguoiDungDTO nguoiDungDTO, String host);                         
	List<NguoiDungDTO> getDanhSachNguoiDungTheoEmailVaSoDienThoai(String email, String soDienThoai, int page, int size);
	Optional<NguoiDungDTO> getTheoMaNguoiDung(int maNguoiDung);
	boolean xoaNguoiDungTheoMaNguoiDung(int maNguoiDung);
	NguoiDungDTO getTheoEmail(String email);
	NguoiDung getBuoiDungTheoEmail(String mail);
	boolean capNhatTrangThaiVaRole(Integer id, boolean trangThai, String role);
	
	
}
