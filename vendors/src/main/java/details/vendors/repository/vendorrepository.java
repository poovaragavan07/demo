package details.vendors.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import details.vendors.model.vendor;
 
@Repository
public interface vendorrepository extends JpaRepository<vendor, Long>{

 
}
