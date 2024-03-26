package sy.tech.space.AddressManager_Backend.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sy.tech.space.AddressManager_Backend.model.Address;
import sy.tech.space.AddressManager_Backend.repository.AddressRepository;

import java.util.List;

@Configuration
public class addressConfig {
    @Bean
    CommandLineRunner commandLineRunner(AddressRepository addressRepository) {
        return args -> {

            Address address =
                    new Address(1234,
                            "Mohammad",
                            "Assaf",
                            "myStreet",
                            "myCity",
                            "myTelNumber",
                            234567);
            addressRepository.saveAll(List.of(address));
        };
    }
}
