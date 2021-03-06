package com.beimin.eveapi.model.corporation;

import java.util.Date;

public class Member {
    private long characterID;
    private String name;
    private Date startDateTime;
    private int baseID;
    private String base;
    private String title;
    private Date logonDateTime;
    private Date logoffDateTime;
    private int locationID;
    private String location;
    private int shipTypeID;
    private String shipType;
    private long roles;
    private long grantableRoles;

    public long getCharacterID() {
        return characterID;
    }

    public void setCharacterID(final long characterID) {
        this.characterID = characterID;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(final Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public int getBaseID() {
        return baseID;
    }

    public void setBaseID(final int baseID) {
        this.baseID = baseID;
    }

    public String getBase() {
        return base;
    }

    public void setBase(final String base) {
        this.base = base;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Date getLogonDateTime() {
        return logonDateTime;
    }

    public void setLogonDateTime(final Date logonDateTime) {
        this.logonDateTime = logonDateTime;
    }

    public Date getLogoffDateTime() {
        return logoffDateTime;
    }

    public void setLogoffDateTime(final Date logoffDateTime) {
        this.logoffDateTime = logoffDateTime;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(final int locationID) {
        this.locationID = locationID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    public int getShipTypeID() {
        return shipTypeID;
    }

    public void setShipTypeID(final int shipTypeID) {
        this.shipTypeID = shipTypeID;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(final String shipType) {
        this.shipType = shipType;
    }

    public long getRoles() {
        return roles;
    }

    public void setRoles(final long roles) {
        this.roles = roles;
    }

    public long getGrantableRoles() {
        return grantableRoles;
    }

    public void setGrantableRoles(final long grantableRoles) {
        this.grantableRoles = grantableRoles;
    }
}
