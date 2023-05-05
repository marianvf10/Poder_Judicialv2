package com.rpcwebservice.repositories;

import com.rpcwebservice.entities.SedeSocial;
import org.springframework.data.repository.CrudRepository;

public interface SedeSocialRepository extends CrudRepository<SedeSocial,Integer> {
    SedeSocial findBySociedadCuitAndValidado(String cuit,Boolean validado);
}
