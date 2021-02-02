package com.hcl.phase3_1.Services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.phase3_1.Repo.UserCrudRepository;
import com.hcl.phase3_1.Repo.UserEntity;

@Transactional
@Service
public class UserService implements Services {
	@Autowired
	private UserCrudRepository userCrudRepository;

	@Override
	public UserEntity update(UserEntity user) {
		// TODO Auto-generated method stub
		return userCrudRepository.save(user);
	}

	@Override
	public Optional<UserEntity> findById(String userid) {
		// TODO Auto-generated method stub
		return userCrudRepository.findById(userid);
	}

}
