package dasturlash.uz.service;

import dasturlash.uz.dto.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExchangeExampleService {
    @Autowired
    private RestTemplate restTemplate;

    public Post getById(Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<Void> httpEntity = new HttpEntity<>(headers);

        String url = "https://jsonplaceholder.typicode.com/posts/{id}";
        ResponseEntity<Post> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Post.class, id);

        return response.getBody();
    }

    public Post cratePost() {
        Post post = new Post();
        post.setTitle("Yangi post");
        post.setBody("Yangi postning body qismi");
        post.setUserId(1);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<Post> httpEntity = new HttpEntity<>(post, headers);

        String url = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<Post> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Post.class);

        return response.getBody();
    }

    public Post cratePost_withOutHeader() {
        Post post = new Post();
        post.setTitle("Yangi post");
        post.setBody("Yangi postning body qismi");
        post.setUserId(1);

        HttpEntity<Post> httpEntity = new HttpEntity<>(post);

        String url = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<Post> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Post.class);


        return response.getBody();
    }

    public List<Post> getPostList() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<Post> httpEntity = new HttpEntity<>(headers);

        String url = "https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<List<Post>> response = restTemplate.exchange(url,
                HttpMethod.GET,
                httpEntity,
                new ParameterizedTypeReference<List<Post>>() {
                });
        return response.getBody();
    }

    public Post getPostById() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity httpEntity = new HttpEntity(headers);

        String url = "https://jsonplaceholder.typicode.com/posts/1";
        ResponseEntity<Post> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Post.class);

        return response.getBody();
    }


}
