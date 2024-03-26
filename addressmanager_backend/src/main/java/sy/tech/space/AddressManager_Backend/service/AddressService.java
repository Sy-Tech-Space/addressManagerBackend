package sy.tech.space.AddressManager_Backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sy.tech.space.AddressManager_Backend.model.Address;
import sy.tech.space.AddressManager_Backend.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service // is a Bean and Service
public class AddressService {
   private final AddressRepository addressRepository;

   @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    public void addNewAddress(Address address) {
        addressRepository.save(address);
    }

    public void deleteById (Long id){
       addressRepository.deleteById(id);
      /*
        Optional<Address> addressOptional = addressRepository.findById(id);

        if (addressOptional.isPresent()) {
            addressRepository.delete(addressOptional.get());
            return ResponseEntity.noContent().build(); // 204 No Content response
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found response
        }*/
    }


    public ResponseEntity<Address> updateById(Long id, Address updatedAddress) {
        Optional<Address> existingAddressOptional = addressRepository.findById(id);
        if (existingAddressOptional.isPresent()) {
            Address existingAddress = existingAddressOptional.get();
               existingAddress.updateAll(updatedAddress);
            addressRepository.save(existingAddress);
            return ResponseEntity.ok(existingAddress);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
