package com.minitest.service;

import com.minitest.model.Computer;
import com.minitest.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IComputerService extends IGenerateService<Computer> {
    Iterable<Computer> findAllByType(Type type);
    Page<Computer> findAll(Pageable pageable);
    Page<Computer> findAllByNameContaining(Pageable pageable, String name);
    Page<Computer> findAllByName(Pageable pageable, String name);
}