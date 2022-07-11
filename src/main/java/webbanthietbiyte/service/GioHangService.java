package webbanthietbiyte.service;

import webbanthietbiyte.dto.CartDTO;
import webbanthietbiyte.dto.CartThietBiDTO;


public interface GioHangService {

	
	CartThietBiDTO convertCartDTOToCartThietBiDTO(CartDTO cartDTO);
	
	boolean datHang(CartDTO cartDTO);
}
