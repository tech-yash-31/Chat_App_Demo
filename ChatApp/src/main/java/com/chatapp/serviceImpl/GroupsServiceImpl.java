package com.chatapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.chatapp.entity.Groups;
import com.chatapp.entity.User;
import com.chatapp.repository.GroupsRepository;
import com.chatapp.repository.UserRepository;
import com.chatapp.service.GroupsService;

@Service
public class GroupsServiceImpl implements GroupsService {

	@Autowired
	GroupsRepository groupsRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Groups addGroups(@RequestBody Groups groups) {
		return groupsRepository.save(groups);
	}


	@Override
	public List<Groups> getAllGroups() {
			List<Groups> groupslist = groupsRepository.findAll();
			return groupslist;
	}
	
	
	@Override
	public Optional<Groups> getGroupsById(@PathVariable("groupId") int groupId) {
			
		return groupsRepository.findById(groupId);
	}


}
