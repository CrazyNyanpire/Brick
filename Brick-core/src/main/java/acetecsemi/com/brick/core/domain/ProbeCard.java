package acetecsemi.com.brick.core.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author harlow
 * @version 1.0
 * @created 09-02-2015 15:27:10
 */
@Entity
@DiscriminatorValue("PROBECARD")
public class ProbeCard extends Part {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6351530688769251047L;
	private String inLongestNeedle;// 进厂最长针长
	private String inShortestNeedle;// 进厂最短针长
	private String scrappingStandard;// 报废标准
	private String probeMaterials;// 探针材质
	private String maintenanceUpperLimit;// 保养上限
	private String maintenanceLowerLimit;// 保养下限
	private String openRemake;// 是否拆板重制
	private String maintenanceBase;// 保养基数
	private String tipHeight;// 针尖高度
	private String tipLongest;// 针尖最长长度
	private String tipShortest;// 针尖最短长度
	private String xyNeedlePosition;// X，Y针位
	private String zNeedlePositionFlatness;// Z针位平坦度
	private String tipMaximumDiameter; // 针尖最大直径
	private String tipMinimumDiameter; // 针尖最小直径
	private String ExpoxyToTipAngleDistance;// Expoxy至针尖Angle距离
	private String testTemperature;// 测试温度
	private String appearanceOfProbeCard;// Probe Card外观
	private String reinforcingPlate;// 补强板
	private String remakeNumber;
	private Long touchTime;
	private Long touchTimeTotal;
	private String inTipMaximumDiameter; // 进厂针尖最大直径
	private String inTipMinimumDiameter; // 进厂针尖最小直径
	
	private Integer pinQty;
	
	private String pcbSize;
	
	private String equipmentCategory;

	public String getInLongestNeedle() {
		return inLongestNeedle;
	}

	public void setInLongestNeedle(String inLongestNeedle) {
		this.inLongestNeedle = inLongestNeedle;
	}

	public String getInShortestNeedle() {
		return inShortestNeedle;
	}

	public void setInShortestNeedle(String inShortestNeedle) {
		this.inShortestNeedle = inShortestNeedle;
	}

	public String getScrappingStandard() {
		return scrappingStandard;
	}

	public void setScrappingStandard(String scrappingStandard) {
		this.scrappingStandard = scrappingStandard;
	}

	public String getProbeMaterials() {
		return probeMaterials;
	}

	public void setProbeMaterials(String probeMaterials) {
		this.probeMaterials = probeMaterials;
	}

	public String getMaintenanceUpperLimit() {
		return maintenanceUpperLimit;
	}

	public void setMaintenanceUpperLimit(String maintenanceUpperLimit) {
		this.maintenanceUpperLimit = maintenanceUpperLimit;
	}

	public String getMaintenanceLowerLimit() {
		return maintenanceLowerLimit;
	}

	public void setMaintenanceLowerLimit(String maintenanceLowerLimit) {
		this.maintenanceLowerLimit = maintenanceLowerLimit;
	}

	public String getOpenRemake() {
		return openRemake;
	}

	public void setOpenRemake(String openRemake) {
		this.openRemake = openRemake;
	}

	public String getMaintenanceBase() {
		return maintenanceBase;
	}

	public void setMaintenanceBase(String maintenanceBase) {
		this.maintenanceBase = maintenanceBase;
	}

	public String getTipHeight() {
		return tipHeight;
	}

	public void setTipHeight(String tipHeight) {
		this.tipHeight = tipHeight;
	}

	public String getTipLongest() {
		return tipLongest;
	}

	public void setTipLongest(String tipLongest) {
		this.tipLongest = tipLongest;
	}

	public String getTipShortest() {
		return tipShortest;
	}

	public void setTipShortest(String tipShortest) {
		this.tipShortest = tipShortest;
	}

	public String getXyNeedlePosition() {
		return xyNeedlePosition;
	}

	public void setXyNeedlePosition(String xyNeedlePosition) {
		this.xyNeedlePosition = xyNeedlePosition;
	}

	public String getZNeedlePositionFlatness() {
		return zNeedlePositionFlatness;
	}

	public void setZNeedlePositionFlatness(String zNeedlePositionFlatness) {
		this.zNeedlePositionFlatness = zNeedlePositionFlatness;
	}

	public String getTipMaximumDiameter() {
		return tipMaximumDiameter;
	}

	public void setTipMaximumDiameter(String tipMaximumDiameter) {
		this.tipMaximumDiameter = tipMaximumDiameter;
	}

	public String getTipMinimumDiameter() {
		return tipMinimumDiameter;
	}

	public void setTipMinimumDiameter(String tipMinimumDiameter) {
		this.tipMinimumDiameter = tipMinimumDiameter;
	}

	public String getExpoxyToTipAngleDistance() {
		return ExpoxyToTipAngleDistance;
	}

	public void setExpoxyToTipAngleDistance(String expoxyToTipAngleDistance) {
		ExpoxyToTipAngleDistance = expoxyToTipAngleDistance;
	}

	public String getTestTemperature() {
		return testTemperature;
	}

	public void setTestTemperature(String testTemperature) {
		this.testTemperature = testTemperature;
	}

	public String getAppearanceOfProbeCard() {
		return appearanceOfProbeCard;
	}

	public void setAppearanceOfProbeCard(String appearanceOfProbeCard) {
		this.appearanceOfProbeCard = appearanceOfProbeCard;
	}

	public String getReinforcingPlate() {
		return reinforcingPlate;
	}

	public void setReinforcingPlate(String reinforcingPlate) {
		this.reinforcingPlate = reinforcingPlate;
	}

	public String getRemakeNumber() {
		return remakeNumber;
	}

	public void setRemakeNumber(String remakeNumber) {
		this.remakeNumber = remakeNumber;
	}

	public String getzNeedlePositionFlatness() {
		return zNeedlePositionFlatness;
	}

	public void setzNeedlePositionFlatness(String zNeedlePositionFlatness) {
		this.zNeedlePositionFlatness = zNeedlePositionFlatness;
	}

	public Long getTouchTime() {
		return touchTime;
	}

	public void setTouchTime(Long touchTime) {
		this.touchTime = touchTime;
	}

	public Long getTouchTimeTotal() {
		return touchTimeTotal;
	}

	public void setTouchTimeTotal(Long touchTimeTotal) {
		this.touchTimeTotal = touchTimeTotal;
	}

	public Integer getPinQty() {
		return pinQty;
	}

	public void setPinQty(Integer pinQty) {
		this.pinQty = pinQty;
	}

	public String getPcbSize() {
		return pcbSize;
	}

	public void setPcbSize(String pcbSize) {
		this.pcbSize = pcbSize;
	}

	public String getEquipmentCategory() {
		return equipmentCategory;
	}

	public void setEquipmentCategory(String equipmentCategory) {
		this.equipmentCategory = equipmentCategory;
	}

	public String getInTipMaximumDiameter() {
		return inTipMaximumDiameter;
	}

	public void setInTipMaximumDiameter(String inTipMaximumDiameter) {
		this.inTipMaximumDiameter = inTipMaximumDiameter;
	}

	public String getInTipMinimumDiameter() {
		return inTipMinimumDiameter;
	}

	public void setInTipMinimumDiameter(String inTipMinimumDiameter) {
		this.inTipMinimumDiameter = inTipMinimumDiameter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((ExpoxyToTipAngleDistance == null) ? 0
						: ExpoxyToTipAngleDistance.hashCode());
		result = prime
				* result
				+ ((appearanceOfProbeCard == null) ? 0 : appearanceOfProbeCard
						.hashCode());
		result = prime * result
				+ ((inLongestNeedle == null) ? 0 : inLongestNeedle.hashCode());
		result = prime
				* result
				+ ((inShortestNeedle == null) ? 0 : inShortestNeedle.hashCode());
		result = prime * result
				+ ((maintenanceBase == null) ? 0 : maintenanceBase.hashCode());
		result = prime
				* result
				+ ((maintenanceLowerLimit == null) ? 0 : maintenanceLowerLimit
						.hashCode());
		result = prime
				* result
				+ ((maintenanceUpperLimit == null) ? 0 : maintenanceUpperLimit
						.hashCode());
		result = prime * result
				+ ((openRemake == null) ? 0 : openRemake.hashCode());
		result = prime * result
				+ ((probeMaterials == null) ? 0 : probeMaterials.hashCode());
		result = prime
				* result
				+ ((reinforcingPlate == null) ? 0 : reinforcingPlate.hashCode());
		result = prime * result
				+ ((remakeNumber == null) ? 0 : remakeNumber.hashCode());
		result = prime
				* result
				+ ((scrappingStandard == null) ? 0 : scrappingStandard
						.hashCode());
		result = prime * result
				+ ((testTemperature == null) ? 0 : testTemperature.hashCode());
		result = prime * result
				+ ((tipHeight == null) ? 0 : tipHeight.hashCode());
		result = prime * result
				+ ((tipLongest == null) ? 0 : tipLongest.hashCode());
		result = prime
				* result
				+ ((tipMaximumDiameter == null) ? 0 : tipMaximumDiameter
						.hashCode());
		result = prime
				* result
				+ ((tipMinimumDiameter == null) ? 0 : tipMinimumDiameter
						.hashCode());
		result = prime * result
				+ ((tipShortest == null) ? 0 : tipShortest.hashCode());
		result = prime * result
				+ ((touchTime == null) ? 0 : touchTime.hashCode());
		result = prime * result
				+ ((touchTimeTotal == null) ? 0 : touchTimeTotal.hashCode());
		result = prime
				* result
				+ ((xyNeedlePosition == null) ? 0 : xyNeedlePosition.hashCode());
		result = prime
				* result
				+ ((zNeedlePositionFlatness == null) ? 0
						: zNeedlePositionFlatness.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProbeCard other = (ProbeCard) obj;
		if (ExpoxyToTipAngleDistance == null) {
			if (other.ExpoxyToTipAngleDistance != null)
				return false;
		} else if (!ExpoxyToTipAngleDistance
				.equals(other.ExpoxyToTipAngleDistance))
			return false;
		if (appearanceOfProbeCard == null) {
			if (other.appearanceOfProbeCard != null)
				return false;
		} else if (!appearanceOfProbeCard.equals(other.appearanceOfProbeCard))
			return false;
		if (inLongestNeedle == null) {
			if (other.inLongestNeedle != null)
				return false;
		} else if (!inLongestNeedle.equals(other.inLongestNeedle))
			return false;
		if (inShortestNeedle == null) {
			if (other.inShortestNeedle != null)
				return false;
		} else if (!inShortestNeedle.equals(other.inShortestNeedle))
			return false;
		if (maintenanceBase == null) {
			if (other.maintenanceBase != null)
				return false;
		} else if (!maintenanceBase.equals(other.maintenanceBase))
			return false;
		if (maintenanceLowerLimit == null) {
			if (other.maintenanceLowerLimit != null)
				return false;
		} else if (!maintenanceLowerLimit.equals(other.maintenanceLowerLimit))
			return false;
		if (maintenanceUpperLimit == null) {
			if (other.maintenanceUpperLimit != null)
				return false;
		} else if (!maintenanceUpperLimit.equals(other.maintenanceUpperLimit))
			return false;
		if (openRemake == null) {
			if (other.openRemake != null)
				return false;
		} else if (!openRemake.equals(other.openRemake))
			return false;
		if (probeMaterials == null) {
			if (other.probeMaterials != null)
				return false;
		} else if (!probeMaterials.equals(other.probeMaterials))
			return false;
		if (reinforcingPlate == null) {
			if (other.reinforcingPlate != null)
				return false;
		} else if (!reinforcingPlate.equals(other.reinforcingPlate))
			return false;
		if (remakeNumber == null) {
			if (other.remakeNumber != null)
				return false;
		} else if (!remakeNumber.equals(other.remakeNumber))
			return false;
		if (scrappingStandard == null) {
			if (other.scrappingStandard != null)
				return false;
		} else if (!scrappingStandard.equals(other.scrappingStandard))
			return false;
		if (testTemperature == null) {
			if (other.testTemperature != null)
				return false;
		} else if (!testTemperature.equals(other.testTemperature))
			return false;
		if (tipHeight == null) {
			if (other.tipHeight != null)
				return false;
		} else if (!tipHeight.equals(other.tipHeight))
			return false;
		if (tipLongest == null) {
			if (other.tipLongest != null)
				return false;
		} else if (!tipLongest.equals(other.tipLongest))
			return false;
		if (tipMaximumDiameter == null) {
			if (other.tipMaximumDiameter != null)
				return false;
		} else if (!tipMaximumDiameter.equals(other.tipMaximumDiameter))
			return false;
		if (tipMinimumDiameter == null) {
			if (other.tipMinimumDiameter != null)
				return false;
		} else if (!tipMinimumDiameter.equals(other.tipMinimumDiameter))
			return false;
		if (tipShortest == null) {
			if (other.tipShortest != null)
				return false;
		} else if (!tipShortest.equals(other.tipShortest))
			return false;
		if (touchTime == null) {
			if (other.touchTime != null)
				return false;
		} else if (!touchTime.equals(other.touchTime))
			return false;
		if (touchTimeTotal == null) {
			if (other.touchTimeTotal != null)
				return false;
		} else if (!touchTimeTotal.equals(other.touchTimeTotal))
			return false;
		if (xyNeedlePosition == null) {
			if (other.xyNeedlePosition != null)
				return false;
		} else if (!xyNeedlePosition.equals(other.xyNeedlePosition))
			return false;
		if (zNeedlePositionFlatness == null) {
			if (other.zNeedlePositionFlatness != null)
				return false;
		} else if (!zNeedlePositionFlatness
				.equals(other.zNeedlePositionFlatness))
			return false;
		return true;
	}

}