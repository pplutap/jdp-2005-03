package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {

    public Group mapToGroup (final GroupDto groupDto) {
        return new Group(
                groupDto.getId(),
                groupDto.getName()
        );
    }

    public GroupDto mapToGroupDto (final Group group) {
        return new GroupDto(
                group.getId(),
                group.getName()
        );
    }

    public List<GroupDto> mapToGroupDtoList(final List<Group> productsList) {
        return productsList.stream()
                .map(p -> new GroupDto(p.getId(),p.getName()))
                .collect(Collectors.toList());
    }
}
