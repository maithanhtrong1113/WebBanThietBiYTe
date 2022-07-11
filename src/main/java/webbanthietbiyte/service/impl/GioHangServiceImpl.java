package webbanthietbiyte.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webbanthietbiyte.converter.ThietBiConverter;
import webbanthietbiyte.dto.CartDTO;
import webbanthietbiyte.dto.CartItemDTO;
import webbanthietbiyte.dto.CartThietBiDTO;
import webbanthietbiyte.dto.CartThietBiItemDTO;
import webbanthietbiyte.dto.ThietBiDTO;
import webbanthietbiyte.entity.ChiTietHoaDon;
import webbanthietbiyte.entity.HoaDon;
import webbanthietbiyte.entity.NguoiDung;
import webbanthietbiyte.entity.ThietBi;
import webbanthietbiyte.repository.HoaDonRepository;
import webbanthietbiyte.repository.NguoidungRepository;
import webbanthietbiyte.repository.ThietBiRepository;
import webbanthietbiyte.service.GioHangService;
import webbanthietbiyte.utils.ThongTinNguoiDung;
import webbanthietbiyte.utils.TrangThaiDonHangConstant;

@Service
@Transactional
public class GioHangServiceImpl implements GioHangService {

	@Autowired
	private ThietBiRepository thietBiRepository;

	@Autowired
	private NguoidungRepository nguoiDungRepository;

	@Autowired
	private ThietBiConverter thietBiConverter;

	@Autowired
	private HoaDonRepository hoaDonRepository;

	@Override
	public CartThietBiDTO convertCartDTOToCartThietBiDTO(CartDTO cartDTO) {

		List<CartThietBiItemDTO> cartThietBiItemDTOs = new ArrayList<>();

		for (CartItemDTO cartItemDTO : cartDTO.getCartItemDTOs()) {

			ThietBi thietBi = thietBiRepository.findBySlug(cartItemDTO.getSlug());

			ThietBiDTO thietBiDTO = thietBiConverter.toThietBiDTO(thietBi);

			CartThietBiItemDTO cartThietBiItemDTO = new CartThietBiItemDTO(thietBiDTO, cartItemDTO.getSoLuong());

			cartThietBiItemDTOs.add(cartThietBiItemDTO);
		}

		return new CartThietBiDTO(cartThietBiItemDTOs);
	}

	@Override
	public boolean datHang(CartDTO cartDTO) {

		if (cartDTO == null || cartDTO.getCartItemDTOs().isEmpty())
			return false;

		NguoiDung nguoiDung = nguoiDungRepository.findByEmail(ThongTinNguoiDung.getUsername());

		HoaDon hoaDon = new HoaDon();

		hoaDon.setId(RandomStringUtils.randomNumeric(9));
		hoaDon.setHoTenKhachHang(nguoiDung.getHoTen());
		hoaDon.setSoDienThoaiGiaoHang(nguoiDung.getSoDienThoai());
		hoaDon.setDiaChiGiaoHang(nguoiDung.getDiaChi());
		hoaDon.setEmail(nguoiDung.getEmail());
		hoaDon.setGhiChu("");
		hoaDon.setThoiGianDat(LocalDateTime.now());
		hoaDon.setTrangThaiDonHang(TrangThaiDonHangConstant.DANG_CHO_XU_LY);
		hoaDon.setNguoiDung(nguoiDung);

		List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<>();

		for (CartItemDTO cartItemDTO : cartDTO.getCartItemDTOs()) {

			ThietBi thietBi = thietBiRepository.findBySlug(cartItemDTO.getSlug());

			ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
			chiTietHoaDon.setHoaDon(hoaDon);
			chiTietHoaDon.setThietBi(thietBi);
			chiTietHoaDon.setGia(thietBi.getGia());
			chiTietHoaDon.setKhuyenMai(thietBi.getKhuyenMai());
			chiTietHoaDon.setSoLuong(cartItemDTO.getSoLuong());

			chiTietHoaDons.add(chiTietHoaDon);

		}

		hoaDon.setChiTietHoaDons(chiTietHoaDons);
		hoaDonRepository.save(hoaDon);

		return true;
	}

}
