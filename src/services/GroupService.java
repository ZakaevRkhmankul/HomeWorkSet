package services;

import models.Group;
import models.Student;

import java.util.Set;

public interface GroupService {

    String addNewGroup(Group group);

    Group getGroupByName(String name);

    Group updateGroupName(String name,String newName);

    Set<Group>getAllGroups();

    String deleteGroup(String groupName);


}
