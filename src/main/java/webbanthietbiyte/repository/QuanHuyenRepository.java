package webbanthietbiyte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import webbanthietbiyte.entity.QuanHuyen;

public interface QuanHuyenRepository extends JpaRepository<QuanHuyen, String>{

	List<QuanHuyen> findAllByMaThanhPho(String maThanhPho);
	
}
