package com.back.global.initData;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseInitData {
    @Autowired
    private PostRepository postRepository;

    @Bean
    ApplicationRunner baseInitDataApplicationRunner() {
        return args -> {
            if (postRepository.count() > 0) return;

            Post post1 = postRepository.save(new Post("제목 1", "내용 1"));
            Post post2 = postRepository.save(new Post("제목 1", "내용 2"));

            System.out.println("기본 데이터가 초기화되었습니다.");
        };
    }
}
