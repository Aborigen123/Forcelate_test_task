package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.email = :email")
	User findUserByEmail(@Param("email") String email);

	@Query("SELECT u FROM User u WHERE u.id = :id")
	User findUserById(@Param("id") Long id);

	@Query("SELECT u FROM User u WHERE u.age > :age ")
	List<User> findUserByMoreAge(@Param("age") int age);

	@Query("SELECT DISTINCT u FROM User u LEFT JOIN Articles a ON  u.id = a.user Group by name  having COUNT(a.user ) > 3")
	List<User> findUniqueNameMoreThree();

}
