package com.shymmi.itscouts.exception;

public class TalentNotFoundException extends RuntimeException {
    public TalentNotFoundException(Long id) {
        super("Could not find talent " + id);
    }
}
