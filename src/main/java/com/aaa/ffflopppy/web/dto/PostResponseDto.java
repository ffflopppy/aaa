package com.aaa.ffflopppy.web.dto;

import com.aaa.ffflopppy.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostResponseDto {

    private Long id ;
    private String title;
    private String contents;
    private  String author;

    @Builder
    public PostResponseDto(Long id, String title, String contents, String author) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.author = author;
    }

    public PostResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.contents = entity.getContent();
        this.author = entity.getAuthor();
    }
}
