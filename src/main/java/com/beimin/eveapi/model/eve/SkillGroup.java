package com.beimin.eveapi.model.eve;

import java.util.ArrayList;
import java.util.Collection;

public class SkillGroup implements Comparable<SkillGroup> {
    private String groupName;
    private int groupID;
    private final Collection<Skill> skills = new ArrayList<Skill>();

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(final String groupName) {
        this.groupName = groupName;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(final int groupID) {
        this.groupID = groupID;
    }

    public void add(final Skill skill) {
        skills.add(skill);
    }

    public Collection<Skill> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        result.append(groupName).append(" (").append(skills.size()).append(" skills)\n");
        for (final Skill skill : skills) {
            result.append("\t").append(skill).append("\n");
        }
        return result.toString();
    }

    @Override
    public int compareTo(final SkillGroup o) {
        return groupName.compareTo(o.groupName);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + groupID;
        result = (prime * result) + ((groupName == null) ? 0 : groupName.hashCode());
        result = (prime * result) + skills.hashCode();
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SkillGroup other = (SkillGroup) obj;
        if (groupID != other.groupID) {
            return false;
        }
        if (groupName == null) {
            if (other.groupName != null) {
                return false;
            }
        } else if (!groupName.equals(other.groupName)) {
            return false;
        }
        if (!skills.equals(other.skills)) {
            return false;
        }
        return true;
    }
}
