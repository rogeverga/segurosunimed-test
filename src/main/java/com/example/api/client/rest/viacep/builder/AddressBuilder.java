package com.example.api.client.rest.viacep.builder;

import com.example.api.client.rest.viacep.domain.Endereco;
import com.example.api.domain.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressBuilder {

    public Address build(Endereco endereco) {
        Address address = new Address();

        address.setCity(endereco.getLocalidade());
        address.setFederativeUnit(endereco.getUf());
        address.setNeighborhood(endereco.getBairro());
        address.setStreet(endereco.getLogradouro());

        return address;
    }

}