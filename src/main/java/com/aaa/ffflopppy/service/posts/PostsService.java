package com.aaa.ffflopppy.service.posts;

import com.aaa.ffflopppy.domain.posts.Posts;
import com.aaa.ffflopppy.domain.posts.PostsRepository;
import com.aaa.ffflopppy.web.dto.PostResponseDto;
import com.aaa.ffflopppy.web.dto.PostsSaveRequestDto;
import com.aaa.ffflopppy.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.PostUpdate;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public Long save(@RequestBody PostsSaveRequestDto requestDto ) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public Long update(Long id , PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("해당 게시글이 없습니다. ID= " + id) );

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostResponseDto findById (Long id) {

        Posts entity = postsRepository.findById(id) .orElseThrow( () -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id) );

        return new PostResponseDto(entity);
    }
}
