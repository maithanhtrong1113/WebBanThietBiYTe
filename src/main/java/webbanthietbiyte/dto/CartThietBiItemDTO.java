package webbanthietbiyte.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import webbanthietbiyte.utils.XuLyTien;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartThietBiItemDTO {

	private ThietBiDTO thietBiDTO;
	private int soLuong;
	

	public double tinhThanhTien() {

		return thietBiDTO.tinhGia() * soLuong;

	}

	public String getThanhTienString() {
		return XuLyTien.dinhDangTien(tinhThanhTien());

	}

	public CartThietBiItemDTO(ThietBiDTO thietBiDTO) {
		super();
		this.thietBiDTO = thietBiDTO;
	}

}
