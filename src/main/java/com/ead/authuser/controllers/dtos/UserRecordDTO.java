package com.ead.authuser.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRecordDTO(@JsonView(UserView.RegistrationPost.class)
                            @NotBlank(groups = UserView.RegistrationPost.class, message = "Username is mandatory")
                            @Size(groups = UserView.RegistrationPost.class, min = 4, max = 50, message = "Size must be between 4 and 50")
                            String username,
                            @JsonView(UserView.RegistrationPost.class)
                            @NotBlank(groups = UserView.RegistrationPost.class, message = "Email is mandatory")
                            @Email(groups = UserView.RegistrationPost.class, message = "Email must be in the expected format")
                            String email,
                            @JsonView({UserView.RegistrationPost.class,UserView.PasswordPut.class})
                            @NotBlank(groups = {UserView.RegistrationPost.class,UserView.PasswordPut.class}, message = "Password is mandatory")
                            @Size(groups = {UserView.RegistrationPost.class,UserView.PasswordPut.class}, min = 6, max = 20, message = "Size must be between 6 and 20")
                            String password,
                            @JsonView(UserView.PasswordPut.class)
                            @NotBlank(groups = UserView.PasswordPut.class, message = "Old Password is mandatory")
                            @Size(groups = UserView.PasswordPut.class, min = 6, max = 20, message = "Size must be between 6 and 20")
                            String oldPassword,
                            @JsonView({UserView.RegistrationPost.class,UserView.UserPut.class})
                            @NotBlank(groups = {UserView.RegistrationPost.class,UserView.UserPut.class}, message = "Full Name is mandatory")
                            String fullName,
                            @JsonView({UserView.RegistrationPost.class,UserView.UserPut.class})
                            String phoneNumber,
                            @JsonView(UserView.ImagePut.class)
                            @NotBlank(groups = UserView.ImagePut.class, message = "Image URL is mandatory")
                            String imageUrl) {

    public interface UserView {
        interface RegistrationPost{}
        interface UserPut{}
        interface PasswordPut{}
        interface ImagePut{}
    }

}
