package com.otp_system.user_service.Repository;

import com.otp_system.user_service.Enitity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends MongoRepository<Users, Object> {

        Optional<Users> findByMobile(String mobile);

}
