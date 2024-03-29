package sy.tech.space.AddressManager_Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sy.tech.space.AddressManager_Backend.model.Address;
import sy.tech.space.AddressManager_Backend.service.AddressService;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(path = "api/v1/address")
public class addressController {

    private final AddressService addressService;

    @Autowired // the addressService will be created automatically
    public addressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAddresses() {
        return this.addressService.getAddresses();
    }

    @DeleteMapping(value = {"/delete", "/delete/{id}"})
    public void deleteAddress(@PathVariable(required = false) Long id) {
        if (id == null){
            addressService.deleteAllAddresses();
        }else {
            addressService.deleteAddress(id);
        }
    }

    @PostMapping(path = "/save")
    public void addNewAddress(@RequestBody Address address) {
        addressService.addNewAddress(address);
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable("id") Long id, @RequestBody Address updatedAddress) {
        return addressService.updateById(id, updatedAddress);
    }
}
