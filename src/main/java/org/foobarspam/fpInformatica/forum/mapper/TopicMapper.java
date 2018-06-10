package org.foobarspam.fpInformatica.forum.mapper;

import org.foobarspam.fpInformatica.forum.dto.TopicDTO;
import org.foobarspam.fpInformatica.forum.entities.Topic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TopicMapper extends BaseMapper<Topic, TopicDTO>{
}
