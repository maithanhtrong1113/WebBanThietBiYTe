package webbanthietbiyte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import webbanthietbiyte.entity.PhuongXa;

public interface PhuongXaRepository extends JpaRepository<PhuongXa, String>{

	List<PhuongXa> findAllByMaQuanHuyen(String maQuanHuyen);
}
