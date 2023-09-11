package com.shop.now.ms.models.mappers;

import com.shop.now.ms.models.dtos.UserDto;
import com.shop.now.ms.models.entities.UserEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "role", target = "role")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "email", target = "email")
    UserDto toUserDto(UserEntity userEntity);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "role", target = "role")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "email", target = "email")
    UserEntity toUserEntity(UserDto userDto);

    default List<UserDto> toListUserDto(List<UserEntity> userEntities) {
        return userEntities
                .stream()
                .map(this::toUserDto)
                .toList();
    }

    default List<UserEntity> toListUserEntity(List<UserDto> userDtos) {
        return userDtos
                .stream()
                .map(this::toUserEntity)
                .toList();
    }

}
