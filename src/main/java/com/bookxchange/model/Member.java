package com.bookxchange.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
public class Member {

  private UUID id;
  private String username;
  private List<BooksEntity> bookList;
  private short points;

  public Member(String username, List<BooksEntity> bookList) {
    this.id = UUID.randomUUID();
    this.username = username;
    this.bookList = bookList;
    this.points=0;
  }
}
