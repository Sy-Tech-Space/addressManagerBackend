package sy.tech.space.AddressManager_Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sy.tech.space.AddressManager_Backend.model.Address;
import sy.tech.space.AddressManager_Backend.service.AddressService;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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
   /* @RequestMapping(method=GET, value={"/delete", "/{id}"})
    public void get(@PathVariable Long id) {
        System.out.println(id);
          addressService.deleteById(id);
    }*/

    @DeleteMapping(path="/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        System.out.println(id);
        addressService.deleteById(id);
    }
    @PostMapping
    public void addNewAddress(@RequestBody Address address) {
        addressService.addNewAddress(address);
    }

 /*   @GetMapping(path = "delete")
    public ResponseEntity<Address> deleteAddress(@PathVariable("addressId") Long id) {
        return addressService.deleteById(id);
    }*/

    // TODO:  @PutMapping is used to update an object
    @PutMapping(path = "{addressId}")
    public ResponseEntity<Address> updateAddress(@PathVariable("addressId") Long id, @RequestBody Address updatedAddress) {
          return  addressService.updateById(id, updatedAddress);
    }
}
