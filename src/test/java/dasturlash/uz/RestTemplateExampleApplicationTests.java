package dasturlash.uz;

import dasturlash.uz.dto.Post;
import dasturlash.uz.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

@SpringBootTest
class RestTemplateExampleApplicationTests {

    //    @Autowired
//    private GetForObjectExampleService getForObjectExampleService;
    @Autowired
    private PostForObjectExampleService postForObjectExampleService;

    @Autowired
    private ExchangeExampleService exchangeExampleService;
    @Autowired
    private RequestEntityExampleService requestEntityExampleService;

    @Autowired
    private GetForEntityExampleService getForEntityExampleService;

    @Test
    void contextLoads() {
//        Post post = exampleService.getPostById(1);
//        Post post = exampleService.getPostById_withUriVariables_usingArray(1);
//        Post post = exampleService.getPostById_withUriVariables_usingMap(1);
//        List<Post> post = exampleService.getAllPostList();
//        List<Post> post = getForObjectExampleService.queryParamExample(1);
//        System.out.println(post);
//        Post result = postForObjectExampleService.crate();
//        Post result = exchangeExampleService.cratePost();
//        List<Post> resultList = exchangeExampleService.getPostList();
//        System.out.println(resultList);
//        Post post = requestEntityExampleService.getById(1);
//        Post post1 = getForEntityExampleService.getPostById(1);
//        Post post2 = getForEntityExampleService.getPostByIdAsString(1);
//        System.out.println(post1);
//        System.out.println(post2);
        Post post = exchangeExampleService.getById(1);
        System.out.println(post);
    }

}
