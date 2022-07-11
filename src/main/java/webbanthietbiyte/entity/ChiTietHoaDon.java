package webbanthietbiyte.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chi_tiet_hoa_don")
public class ChiTietHoaDon implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	@ManyToOne
	@JoinColumn(name = "thiet_bi_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_cthd_thietbi"))
	private ThietBi thietBi;

	
	@ManyToOne
	@JoinColumn(name = "hoa_don_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_cthd_hoadon"))
	private HoaDon hoaDon;

	private double gia;
	@Column(name = "khuyen_mai")
	private double khuyenMai;
	@Column(name = "so_luong")
	private int soLuong;

	public double tinhGia() {

		return gia - (gia / 100)*khuyenMai;
	}

	public double tinhThanhTien() {

		return tinhGia() * soLuong;
	}

}
