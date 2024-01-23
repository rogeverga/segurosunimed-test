package com.example.api.client.rest.viacep;

import com.example.api.client.rest.viacep.builder.AddressBuilder;
import com.example.api.client.rest.viacep.domain.Endereco;
import com.example.api.client.rest.viacep.exception.ViaCepIntegrationException;
import com.example.api.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ViaCepRestClient {

    @Autowired
    private AddressBuilder addressBuilder;

    @Value("${viacep.host}")
    private String host;

    @Autowired
    private RestTemplate restTemplate;

    public Address getAddressByZipCode(String zipCode) throws Exception {
        ResponseEntity<Endereco> responseEntity =
                restTemplate.getForEntity(
                        host + "/ws/{cep}/json",
                        Endereco.class,
                        zipCode
                );

        Endereco endereco = responseEntity.getBody();

        if (responseEntity.getStatusCode() != HttpStatus.OK || endereco.getBairro() == null ||
                endereco.getLocalidade() == null || endereco.getLogradouro() == null || endereco.getUf() == null
        ) {
            throw new ViaCepIntegrationException("Não foi possível obter endereço do CEP: " + zipCode);
        }

        return addressBuilder.build(endereco);
    }

}