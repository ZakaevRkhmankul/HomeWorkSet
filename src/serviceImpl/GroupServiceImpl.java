package serviceImpl;

import database.Database;
import models.Group;
import services.GroupService;

import java.util.Set;

public class GroupServiceImpl implements GroupService {


    @Override
    public String addNewGroup(Group group) {
        Database.groups.add(group);
        return group + "\n" + group.getGroupName() + " аттуу группа ийгиликтуу сакталды!";
    }

    // Kata
    @Override
    public Group getGroupByName(String name) {
        try {
            if (Database.groups.isEmpty()) {
                throw new IllegalAccessException("Группа тузуло элек");
            }
            for (Group group : Database.groups) {
                if (group.getGroupName().equalsIgnoreCase(name)) {
                    return group;
                } else {
                    throw new IllegalAccessException(name + " аттуу группа табылган жок");
                }
            }
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка чыкты!");
        }
        return null;
    }

    @Override
    public Group updateGroupName(String oldName, String newName) {
        for (Group group : Database.groups) {
            if (group.getGroupName().equalsIgnoreCase(oldName)) {
                group.setGroupName(newName);
                return group;
            }
        }
        return null;
    }

    @Override
    public Set<Group> getAllGroups() {
        return Database.groups;
    }

    @Override
    public String deleteGroup(String groupName) {
        for (Group group : Database.groups) {
            if (group.getGroupName().equalsIgnoreCase(groupName)) {
                Database.groups.remove(group);
                return groupName +" аттуу группа ийгиликтуу очурулду!";
            }
        }
        return "Error";
    }
}
