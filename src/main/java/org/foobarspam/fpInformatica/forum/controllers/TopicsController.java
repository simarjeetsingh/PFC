package org.foobarspam.fpInformatica.forum.controllers;

import org.foobarspam.fpInformatica.forum.dto.TopicDTO;
import org.foobarspam.fpInformatica.forum.entities.Topic;
import org.foobarspam.fpInformatica.forum.repositories.AnswerRepository;
import org.foobarspam.fpInformatica.forum.repositories.TopicRepository;
import org.foobarspam.fpInformatica.forum.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class TopicsController {

    private final TopicRepository topicRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;

    @Autowired
    public TopicsController(TopicRepository topicRepository, AnswerRepository answerRepository, UserRepository userRepository) {
        this.topicRepository = topicRepository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("topics")
    public List<Topic> topicsList() {
          return topicRepository.findAll(new Sort(Sort.Direction.DESC, "createdDate"));
    }

    @PostMapping("newTopic")
    public String newTopic(@Valid @RequestBody TopicDTO dto) {
        Topic topic = new Topic();
//        topic.setUser(userRepository.getUserById(2));
        topic.setTitle(dto.getTitle());
        topic.setContent(dto.getContent());
        topic.setCategory(dto.getCategory());
        topic.setCreatedDate(LocalDateTime.now());
        topicRepository.save(topic);
        return "topic successfully added";
    }

    @GetMapping("topics/{category}")
    public String displayTopicsByCategory(@PathVariable String category) {
//        List<Topic> topics = topicRepository.findTopicsByCategoryOrderByCreatedDateDesc(category);
        return "topics";
    }

    @GetMapping("topics/user/{id}")
    public String displayTopicsByUser(@PathVariable String id) {
        return "topics";
    }

    private String setHeader(String category) {
        switch (category) {
            case "all":
                return "All topics";
            default:
                return "";
        }
    }
}