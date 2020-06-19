package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping ("v1/ecommercee/group")
public class GroupController {

    @Autowired
    GroupDbService groupDbService;

    @Autowired
    GroupMapper groupMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDtoList(groupDbService.getAllGroups());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGroup")
    public GroupDto getGroup (@RequestParam Long groupId) throws GroupNotFoundException {
        return groupMapper.mapToGroupDto(groupDbService.getGroup(groupId).orElseThrow(GroupNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteGroup")
    public void deleteGroup(@RequestParam Long groupId) throws GroupNotFoundException {
        if(groupDbService.getGroup(groupId).isPresent())
            groupDbService.deleteGroup(groupId);
        else
            throw new GroupNotFoundException();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup", consumes = APPLICATION_JSON_VALUE)
    public GroupDto createGroup(@RequestBody GroupDto groupDto) {
        return groupMapper.mapToGroupDto(groupDbService.saveGroup(groupMapper.mapToGroup(groupDto)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroup")
    public GroupDto updateGroup (@RequestBody GroupDto groupDto) {
        return groupMapper.mapToGroupDto(groupDbService.saveGroup(groupMapper.mapToGroup(groupDto)));
    }
}