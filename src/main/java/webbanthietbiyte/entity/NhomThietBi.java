package webbanthietbiyte.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nhom_thietbi")
public class NhomThietBi implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "ten_nhom_thietbi")
	private String tenNhomThietBi;
	private String code;
	
	@OneToMany(mappedBy = "nhomThietBi")
	private List<ThietBi> thietBis;

	public NhomThietBi(String tenNhomVali, String code) {
		super();
		this.tenNhomThietBi = tenNhomVali;
		this.code = code;
	}

	public NhomThietBi(String tenNhomVali) {
		super();
		this.tenNhomThietBi = tenNhomVali;
	}
	public NhomThietBi(Integer id, String tenNhomThietBi, String code) {
		super();
		this.id = id;
		this.tenNhomThietBi = tenNhomThietBi;
		this.code = code;
	}

}
