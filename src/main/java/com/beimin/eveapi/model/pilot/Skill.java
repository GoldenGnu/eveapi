package com.beimin.eveapi.model.pilot;

public class Skill {
    private int typeID;
    private int level = 0;
    private int skillpoints = 0;
    private boolean unpublished = false;

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(final int typeID) {
        this.typeID = typeID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(final int level) {
        this.level = level;
    }

    public int getSkillpoints() {
        return skillpoints;
    }

    public void setSkillpoints(final int skillpoints) {
        this.skillpoints = skillpoints;
    }

    public boolean isUnpublished() {
        return unpublished;
    }

    public void setUnpublished(final boolean unpublished) {
        this.unpublished = unpublished;
    }
}
