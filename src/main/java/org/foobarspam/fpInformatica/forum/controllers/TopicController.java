package org.foobarspam.fpInformatica.forum.controllers;

import org.foobarspam.fpInformatica.forum.dto.AnswerDTO;
import org.foobarspam.fpInformatica.forum.entities.Answer;
import org.foobarspam.fpInformatica.forum.entities.Topic;
import org.foobarspam.fpInformatica.forum.mapper.TopicMapper;
import org.foobarspam.fpInformatica.forum.repositories.AnswerRepository;
import org.foobarspam.fpInformatica.forum.repositories.TopicRepository;
import org.foobarspam.fpInformatica.forum.repositories.UserRepository;
import org.foobarspam.fpInformatica.forum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDateTime;

//@Controller
@RestController
@RequestMapping("/api/")
@CrossOrigin
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@JsonAutoDetect
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TopicController {

    private final UserRepository userRepository;
    private final TopicRepository topicRepository;
    private final AnswerRepository answerRepository;
    private final TopicService topicService;
    private final TopicMapper topicMapper;

    @Autowired
    public TopicController(UserRepository userRepository, TopicRepository topicRepository, AnswerRepository answerRepository, TopicService topicService, TopicMapper topicMapper) {
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
        this.answerRepository = answerRepository;
        this.topicService = topicService;
        this.topicMapper = topicMapper;
    }

//    @GetMapping(value ="/topic/{id}")
//    public TopicDTO displayTopic(@PathVariable Long id) {
////        List<Answer> answers = answerRepository.findAnswerByTopic_Id(id);
//        return topicService.findtopicById(id);
//    }

//    @GetMapping(value ="topic/{id}")
////    @JsonProperty
////    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    public Topic displayTopic(@PathVariable Long id) {
////        List<Answer> answers = answerRepository.findAnswerByTopic_Id(id);
////        return topicService.findtopicById(id);
//        Topic topic = topicRepository.getOne(id);
//        return topic;
//    }

    @GetMapping("topic/{id}")
    public Topic readTopic(@PathVariable Long id) {

        return this.topicRepository.findById(id)
                .orElseThrow(() -> new TopicNotFoundException(id.toString()));
    }

    @PostMapping("topic/{topicId}/addAnswer")
    public String addAnswer(@PathVariable Long topicId, @Valid @RequestBody AnswerDTO dto) {
        Answer answer = new Answer();
        answer.setContent(dto.getContent());
        answer.setCode(dto.getCode());
        answer.setUseful(false);
        answer.setCreatedDate(LocalDateTime.now());
        answer.setTopic(topicRepository.findTopicById(topicId));
        answerRepository.save(answer);
        return "Answer successfully added";
    }


//    @GetMapping("/{id}")
//    public Topic readTopic(@PathVariable String userId, @PathVariable Long id) {
//        this.validateUser(userId);
//
//        return this.topicRepository.findById(id)
//                .orElseThrow(() -> new TopicNotFoundException(id.toString()));
//    }
//
//    private void validateUser(String userId) {
//        this.userRepository.findByUsername(userId).orElseThrow(
//                () -> new UserNotFoundException(userId));
//    }

}