package webbanthietbiyte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import webbanthietbiyte.entity.ThuongHieu;

public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, Integer> {
	boolean existsByTenThuongHieu(String tenThuongHieu);

	List<ThuongHieu> findByTenThuongHieuContainingIgnoreCase(String tenThuongHieu);

	boolean existsByTenThuongHieuAndIdNot(String tenThuongHieu, Integer id);

	ThuongHieu findByTenThuongHieu(String tenThuongHieu);
}
