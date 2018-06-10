package org.foobarspam.fpInformatica.forum.service;

import org.foobarspam.fpInformatica.forum.entities.Topic;
import org.foobarspam.fpInformatica.forum.mapper.TopicMapper;
import org.foobarspam.fpInformatica.forum.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    protected TopicMapper topicMapper;

//    public TopicDTO findtopicById(Long id) {
//        Topic topic = topicRepository.getOne(id);
//        return topicMapper.toDTO(topic);
//    }

//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    public Topic findtopicById(Long id) {
//        return topicRepository.getOne(id);
//    }

    public Topic save(Topic topic) {
        return topicRepository.save(topic);
    }
}
