package sy.tech.space.AddressManager_Backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public void deleteAddress(Long id) {
        boolean exists = addressRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Receipt" +
                    " with id " + id +
                    "does not exists");
        }
        addressRepository.deleteById(id);
    }

    public void deleteAllAddresses() {
        addressRepository.deleteAll();
    }
}
