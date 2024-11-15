package dasturlash.uz.service;

import dasturlash.uz.dto.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestEntityExampleService {
    @Autowired
    private RestTemplate restTemplate;

    public Post getById(Integer id) {
        String url = "https://jsonplaceholder.typicode.com/posts/" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        RequestEntity<Void> request = RequestEntity
                .get(url)
                .headers(headers)
                .build();

        ResponseEntity<Post> response = restTemplate.exchange(request, Post.class);

        return response.getBody();
    }

    public Post createPost() {
        String url = "https://jsonplaceholder.typicode.com/posts";

        Post post = new Post();
        post.setTitle("Yangi post");
        post.setBody("Yangi postning body qismi");
        post.setUserId(1);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        RequestEntity<Post> request = RequestEntity
                .post(url)
                .headers(headers)
                .body(post);

        ResponseEntity<Post> response = restTemplate.exchange(request, Post.class);
        return response.getBody();
    }
}
