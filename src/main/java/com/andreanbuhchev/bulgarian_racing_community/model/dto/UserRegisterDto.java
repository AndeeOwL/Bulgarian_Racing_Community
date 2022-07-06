package com.andreanbuhchev.bulgarian_racing_community.model.dto;

import com.andreanbuhchev.bulgarian_racing_community.model.validation.FieldMatch;
import com.andreanbuhchev.bulgarian_racing_community.model.validation.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



    @FieldMatch(
            first = "password",
            second = "confirmPassword",
            message = "Passwords do not match."
    )
    public class UserRegisterDto {

        @NotEmpty(message = "Username should be provided.")
        @UniqueUsername(message = "Username should be unique.")
        private String username;

        @NotEmpty
        @Size(min = 2, max = 20)
        private String firstName;
        @NotEmpty
        @Size(min = 2, max = 20)
        private String lastName;

        @NotEmpty
        @Email
        private String email;

        @NotEmpty
        @Size(min = 8,max = 20)
        private String password;
        private String confirmPassword;

        public String getFirstName() {
            return firstName;
        }

        public UserRegisterDto setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public String getLastName() {
            return lastName;
        }

        public UserRegisterDto setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public String getPassword() {
            return password;
        }

        public UserRegisterDto setPassword(String password) {
            this.password = password;
            return this;
        }

        public String getConfirmPassword() {
            return confirmPassword;
        }

        public UserRegisterDto setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
            return this;
        }

        public String getUsername() {
            return username;
        }

        public UserRegisterDto setUsername(String username) {
            this.username = username;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
