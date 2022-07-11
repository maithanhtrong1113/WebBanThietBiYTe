package webbanthietbiyte.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import webbanthietbiyte.utils.XuLyTien;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartThietBiDTO {

	private List<CartThietBiItemDTO> CartThietBiItemDTOs;

	public double tinhThanhTien() {

		double thanhTien = 0;

		for (CartThietBiItemDTO s : CartThietBiItemDTOs) {

			thanhTien += s.tinhThanhTien();
		}

		return thanhTien;

	}

	public String getThanhTienString() {

		return XuLyTien.dinhDangTien(tinhThanhTien());

	}

}
