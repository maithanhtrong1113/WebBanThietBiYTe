package webbanthietbiyte.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CartDTO {

	private List<CartItemDTO> cartItemDTOs;

	public CartDTO() {
		cartItemDTOs = new ArrayList<>();
	}

	public CartDTO(List<CartItemDTO> cartItemDTOs) {

		this.cartItemDTOs = cartItemDTOs;
	}

	public void them(String slug) {

		CartItemDTO newCartItemDTO = new CartItemDTO(slug);

		int index = this.cartItemDTOs.indexOf(newCartItemDTO);

		// chưa có sản phẩm
		if (index == -1) {

			newCartItemDTO.setSoLuong(1);
			this.cartItemDTOs.add(newCartItemDTO);
			return;
		}

		// đã có sản phẩm
		CartItemDTO cartItemDTO = this.cartItemDTOs.get(index);
		cartItemDTO.setSoLuong(cartItemDTO.getSoLuong() + 1);

	}

	public void giam(String slug) {

		CartItemDTO cartItemDTOTempt = new CartItemDTO(slug);

		int index = this.cartItemDTOs.indexOf(cartItemDTOTempt);

		// không có sản phẩm này
		if (index == -1)
			return;

		CartItemDTO cartItemDTO = this.cartItemDTOs.get(index);

		// nếu chỉ còn 1 sản phẩm thì xóa đi
		if (cartItemDTO.getSoLuong() <= 1) {
			xoa(slug);
			return;
		}

		cartItemDTO.setSoLuong(cartItemDTO.getSoLuong() - 1);

	}

	public void xoa(String slug) {

		CartItemDTO cartItemDTOTempt = new CartItemDTO(slug);

		this.cartItemDTOs.remove(cartItemDTOTempt);

	}

}
