package webbanthietbiyte.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import webbanthietbiyte.entity.ThietBi;


public interface ThietBiRepository extends JpaRepository<ThietBi, Integer> {
	List<ThietBi> findByTenThietBiContainingAndThuongHieuTenThuongHieuContainingAndNhomThietBiTenNhomThietBiContaining(
			String tenThietBi, String tenThuongHieu, String tenNhomThietBi);

	List<ThietBi> findAllByNoiBatTrue(Pageable page);

	ThietBi findBySlug(String slug);
	Optional<ThietBi> findById(Integer id);

}
