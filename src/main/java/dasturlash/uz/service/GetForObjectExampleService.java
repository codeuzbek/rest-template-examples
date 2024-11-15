package dasturlash.uz.service;

import dasturlash.uz.dto.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GetForObjectExampleService {
    @Autowired
    private RestTemplate restTemplate;

    public Post getPostById(Integer id) {
        String url = "https://jsonplaceholder.typicode.com/posts/" + id;
        Post post = restTemplate.getForObject(url, Post.class);
        return post;
    }

    public Post getPostById_withUriVariables_usingArray(Integer id) {
        String url = "https://jsonplaceholder.typicode.com/posts/{id}";
        Post post = restTemplate.getForObject(url, Post.class, id);
        return post;
    }

    // example. Adding request params to url using map
    public Post getPostById_withUriVariables_usingMap(Integer id) {
        String url = "https://jsonplaceholder.typicode.com/posts/{id}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(id));

        Post post = restTemplate.getForObject(url, Post.class, params);
        return post;
    }

    public List<Post> getAllPostList() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        Post[] response = restTemplate.getForObject(url, Post[].class);
        return Arrays.asList(response);
    }

    public List<Post> queryParamExample(Integer id) {
        String url = "https://jsonplaceholder.typicode.com/comments";
        UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("postId", id)
                .queryParam("page", "0")
                .queryParam("size", "10").build();

        Post[] response = restTemplate.getForObject(uriBuilder.toUriString(), Post[].class);
        return Arrays.asList(response);
    }

    // example. Adding request params to url
    public Post getPostById_uriComponent(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts/{id}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(id));

        String restTemplateURL = UriComponentsBuilder.fromUriString(url)
                .buildAndExpand(params)
                .toUriString();

        Post post = restTemplate.getForObject(restTemplateURL, Post.class);
        return post;
    }

}
