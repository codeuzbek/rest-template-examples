package dasturlash.uz.service;

import dasturlash.uz.dto.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostForObjectExampleService {
    @Autowired
    private RestTemplate restTemplate;

    public Post crate() {
        Post post = new Post();
        post.setTitle("Yangi post");
        post.setBody("Yangi postning body qismi");
        post.setUserId(1);

        String url = "https://jsonplaceholder.typicode.com/posts/";
        Post result = restTemplate.postForObject(url, post, Post.class);
        return result;
    }

    public Post crateWith_urlParams() {
        Post post = new Post();
        post.setTitle("Yangi post");
        post.setBody("Yangi postning body qismi");
        post.setUserId(1);

        Integer someUriVariable = 3;

        String url = "https://jsonplaceholder.typicode.com/posts/";
        Post result = restTemplate.postForObject(url, post, Post.class, someUriVariable);
        return result;
    }

    public Post getPostById_withUriVariables_usingMap(Integer id) {
        String url = "https://jsonplaceholder.typicode.com/posts/{id}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(id));

        Post post = new Post();
        post.setTitle("Yangi post");
        post.setBody("Yangi postning body qismi");
        post.setUserId(1);

        Post result = restTemplate.postForObject(url, post, Post.class, params);
        return result;
    }


    public Post crateWithURI() {
        Post post = new Post();
        post.setTitle("Yangi post");
        post.setBody("Yangi postning body qismi");
        post.setUserId(1);

        try {
            URI uri = new URI("https://jsonplaceholder.typicode.com/posts/");
            Post result = restTemplate.postForObject(uri, post, Post.class);
            return result;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
