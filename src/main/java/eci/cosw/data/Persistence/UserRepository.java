package eci.cosw.data.Persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import eci.cosw.data.model.User;


public interface UserRepository extends MongoRepository<User, String> {

}