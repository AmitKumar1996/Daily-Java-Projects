package com.amit3.Amit31.service;

import org.springframework.stereotype.Service;

import com.amit3.Amit31.repository.iplrepository;

import entity.IplTeam;

@Service

public class serviceImpl implements iplService{
	
	iplrepository iplrepository;

	public serviceImpl(com.amit3.Amit31.repository.iplrepository iplrepository) {
		super();
		this.iplrepository = iplrepository;
	}

	@Override
	public IplTeam insertData(IplTeam iplTeam) {
		// TODO Auto-generated method stub
		return iplrepository.save(iplTeam);
	}

}
