package com.fmi.p01todoapp.services;

import org.springframework.stereotype.Component;

@Component
public class SequenceGenerator {
  private static Long sequence = 1L;

  public Long getNextId(){
    return sequence++;
  }

}
