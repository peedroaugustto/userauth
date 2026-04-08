package com.ead.authuser.controllers.dtos;

public record UserRecordDTO(String username,
                            String email,
                            String password,
                            String oldPassword,
                            String fullName,
                            String phoneNumber,
                            String imageUrl) {
}
