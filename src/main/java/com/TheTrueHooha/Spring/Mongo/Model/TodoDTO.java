package com.TheTrueHooha.Spring.Mongo.Model;

import com.TheTrueHooha.Spring.Mongo.Category.Category;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "todos")

public class TodoDTO {

    @Id
    private String id;

    @Field("tasks")
    private String tasks;

    @Field("description")
    private String description;

    @Field("category")
    private Category category;

    @Field("completed")
    private Boolean completed;

    @Field("Date Created")
    private Date createdAt;

    @Field("Date Updated")
    private Date updatedAt;

}
