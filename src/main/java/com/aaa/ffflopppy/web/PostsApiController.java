package com.aaa.ffflopppy.web;

import com.aaa.ffflopppy.service.posts.PostsService;
import com.aaa.ffflopppy.web.dto.PostResponseDto;
import com.aaa.ffflopppy.web.dto.PostsSaveRequestDto;
import com.aaa.ffflopppy.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto ) {
        return  postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update (@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping
    public PostResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }



}
