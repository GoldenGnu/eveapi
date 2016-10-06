package com.beimin.eveapi.model.corporation;

public class OutpostServiceDetail {
	private long stationID;
	private long ownerID;
	private String serviceName;
	private double minStanding;
	private double surchargePerBadStanding;
	private double discountPerGoodStanding;

	public long getStationID() {
		return stationID;
	}

	public void setStationID(long stationID) {
		this.stationID = stationID;
	}

	public long getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(long ownerID) {
		this.ownerID = ownerID;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public double getMinStanding() {
		return minStanding;
	}

	public void setMinStanding(double minStanding) {
		this.minStanding = minStanding;
	}

	public double getSurchargePerBadStanding() {
		return surchargePerBadStanding;
	}

	public void setSurchargePerBadStanding(double surchargePerBadStanding) {
		this.surchargePerBadStanding = surchargePerBadStanding;
	}

	public double getDiscountPerGoodStanding() {
		return discountPerGoodStanding;
	}

	public void setDiscountPerGoodStanding(double discountPerGoodStanding) {
		this.discountPerGoodStanding = discountPerGoodStanding;
	}
}