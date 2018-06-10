package org.foobarspam.fpInformatica.forum.mapper;

import org.foobarspam.fpInformatica.forum.dto.UserDTO;
import org.foobarspam.fpInformatica.forum.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDTO> {
    
}
