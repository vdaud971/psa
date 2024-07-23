package com.example.paylod;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PostDto {

    private Long id;

    private String title;

    private String description;

}