package sy.tech.space.AddressManager_Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sy.tech.space.AddressManager_Backend.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {


}
