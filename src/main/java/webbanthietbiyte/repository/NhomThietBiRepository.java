package webbanthietbiyte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import webbanthietbiyte.entity.NhomThietBi;

public interface NhomThietBiRepository extends JpaRepository<NhomThietBi, Integer> {
	boolean existsByTenNhomThietBi(String tenNhomThietBi);

	List<NhomThietBi> findByTenNhomThietBiContainingIgnoreCase(String tenNhomThietBi);

	boolean existsByTenNhomThietBiAndIdNot(String tenNhomThietBi, Integer id);

	NhomThietBi findByTenNhomThietBi(String tenNhomThietBi);
}
