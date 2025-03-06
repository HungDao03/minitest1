package com.minitest.service.type;

import com.minitest.dto.TypeDTO;
import com.minitest.model.Computer;
import com.minitest.model.Type;
import com.minitest.repository.ITypeRepository;
import com.minitest.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TypeService implements ITypeService {

    @Autowired
    private ITypeRepository typeRepository;

    @Override
    public Iterable<Type> findAll() {
        return typeRepository.findAll();
    }
    @Override
    public Type save(Type type) {
       return typeRepository.save(type);
    }
    @Override
    public Optional<Type> findById(Long id) {
        return typeRepository.findById(id);
    }
    @Override
    public void remove(Long id) {
        typeRepository.deleteTypeById(id);
    }
}