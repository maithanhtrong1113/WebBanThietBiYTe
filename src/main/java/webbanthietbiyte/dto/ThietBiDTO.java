package webbanthietbiyte.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import webbanthietbiyte.utils.XuLyTien;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThietBiDTO {

	private Integer id;
	private String slug;
	private String tenThietBi;
	private String tenThuongHieu;
	private String tenNhomThietBi;	
	private double gia;
	private double khuyenMai;
	private String thoiGianBaoHanh;
	private boolean noiBat;
	private String moTa;
	private String moTaThietBi;
	public double tinhGia() {
		return gia - ((gia / 100) * khuyenMai);
	}
	public String getGiaString() {
		return XuLyTien.dinhDangTien(tinhGia());
	}

	public String getGiaGocString() {
		return XuLyTien.dinhDangTien(gia);
	}
	

}
