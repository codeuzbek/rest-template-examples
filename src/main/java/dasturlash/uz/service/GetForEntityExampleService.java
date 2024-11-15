package dasturlash.uz.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dasturlash.uz.dto.Post;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetForEntityExampleService {
    @Autowired
    private RestTemplate restTemplate;


    public Post getPostById(Integer id) {
        String url = "https://jsonplaceholder.typicode.com/posts/" + id;
        ResponseEntity<Post> response = restTemplate.getForEntity(url, Post.class);
        // Status kodni olish
        System.out.println("Status Code: " + response.getStatusCode());

        // Headersni olish
        HttpHeaders headers = response.getHeaders();
        System.out.println("Headers: " + headers);

        // Body ni olish
        Post body = response.getBody();
        System.out.println("Body: " + body);

        return response.getBody();
    }

    public Post getPostByIdAsString(Integer id) {
        String url = "https://jsonplaceholder.typicode.com/posts/" + id;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode().value() != 200) { // not success
            System.out.println("Request Failed");
            return null;
        }

        System.out.println("Body in String: " + response.getBody());
        ObjectMapper mapper = new ObjectMapper();
        Post result = null;
        try {
            result = mapper.readValue(response.getBody(), Post.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
