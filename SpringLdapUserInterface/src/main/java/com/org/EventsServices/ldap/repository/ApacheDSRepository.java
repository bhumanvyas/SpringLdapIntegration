package com.org.EventsServices.ldap.repository;


import com.org.EventsServices.ldap.model.UserModel;
import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApacheDSRepository extends LdapRepository<UserModel> {

}

