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
@Table(name = "thietbi")
public class ThietBi implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "ten_thietbi")
	private String tenThietBi;	
	private String slug;
	private double gia;
	@Column(name = "thoi_gian_bao_hanh")
	private String thoiGianBaoHanh;
	@Column(name = "noi_bat")
	private boolean noiBat;
	@Column(name = "khuyen_mai")
	private double khuyenMai;
	private String moTa;
	@Column(name = "mo_ta_thietbi")
	private String moTaThietBi;

	@ManyToOne
	@JoinColumn(name = "thuong_hieu_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_thietbi_thuonghieu"))
	private ThuongHieu thuongHieu;

	@ManyToOne
	@JoinColumn(name = "nhom_thietbi_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_thietbi_nhomthietbi"))
	private NhomThietBi nhomThietBi;

}
