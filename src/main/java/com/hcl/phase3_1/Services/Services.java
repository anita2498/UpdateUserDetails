package com.hcl.phase3_1.Services;

import java.util.Optional;

import com.hcl.phase3_1.Repo.UserEntity;

public interface Services {

	public UserEntity update(UserEntity user);
	public Optional<UserEntity> findById(String Userid);

}
