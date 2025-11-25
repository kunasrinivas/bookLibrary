package com.kuna.booklibrary.repository;

import org.springframework.stereotype.Repository;

import com.kuna.booklibrary.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepository extends JpaRepository <Book,Integer>{

}
