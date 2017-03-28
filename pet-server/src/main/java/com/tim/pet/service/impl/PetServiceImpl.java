package com.tim.pet.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim.pet.dao.entity.Pet;
import com.tim.pet.dao.repo.PetRepository;
import com.tim.pet.service.IPetService;

@Service
@Transactional
public class PetServiceImpl implements IPetService {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(PetServiceImpl.class);

	@Autowired
	private PetRepository petRepo;

	@Override
	public Iterable<Pet> getAllPets() {
		return petRepo.findAll();
	}

	@Override
	public Pet getPet(Long id) {
		LOGGER.info("getPet() id: {}", id);
		return petRepo.findOne(id);
	}
	
	@Override
	public Long addPet(Pet pet) {
		Pet savedPet = petRepo.save(pet);
		return savedPet.getId();
	}

	@Override
	public void deletePet(Long id) {
		petRepo.delete(id);
	}

}
